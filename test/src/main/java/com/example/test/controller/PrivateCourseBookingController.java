package com.example.test.controller;

import com.example.test.entity.PrivateCourseBooking;
import com.example.test.service.PrivateCourseBookingService;
import com.example.test.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class PrivateCourseBookingController {
    @Autowired
    private PrivateCourseBookingService privateCourseBookingService;

    /**
     * 进入私教课程预约管理的接口
     * 通过Session中是否有curAdminName值进行访问权限控制和安全检查
     * */
    @RequestMapping("/privateCourseBookingList1")
    public String privateCourseBookingList1(HttpServletRequest request) {
        if (request.getSession().getAttribute("curAdminName") != null) {
            return "privateCourseBookingListPage";
        }
        return "404_admin_login_expired"; //没有管理员登陆，妄图访问投诉管理页面，直接跳到404
    }

    /**
     * 查询私教课程预约信息列表
     * @return
     */
    @RequestMapping("/getPrivateCourseBookingList")
    @ResponseBody
    public LayuiData getPrivateCourseBookingList(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        if(page>0){
            page = (page-1)*limit;
        }
        String userName = request.getParameter("userName");
        String coachName = request.getParameter("coachName");

        if (userName == null) {
            System.out.println("userName is NULL!");
            userName = "";
        }
        if (coachName == null) {
            System.out.println("coachName is NULL");
            coachName = "";
        }
        System.out.println("userName:["+userName+"], coachName:["+coachName+"]");
        LayuiData layuiData = new LayuiData();
        List<PrivateCourseBooking> privateCourseBookingList = privateCourseBookingService.getPrivateCourseBookingList(userName, coachName, page, limit);
        layuiData.setData(privateCourseBookingList);
        int count = privateCourseBookingService.getPrivateCourseBookingListCount();
        layuiData.setCode(0);
        layuiData.setCount(count);
        layuiData.setMsg("数据请求成功");
        return layuiData;
    }

    /**
     * 转到新增私教课程预约信息的页面
     * @return
     */
    @RequestMapping("/toPrivateCourseBooking")
    public String toPrivateCourseBooking (){
        return "privateCourseBookingAdd";  //去到privateCourseBookingAdd.html
    }

    /**
     * 新增
     * @param userId
     * @param coachId
     * @param beginTime
     * @param endTime
     * @param remark
     * @return
     */
    @RequestMapping("/privateCourseBookingAdd")
    @Transactional
    @ResponseBody
    public Integer privateCourseBookingAdd (
            String userId,
            String coachId,
            String beginTime,
            String endTime,
            String remark
    ) {
        if (remark==null || remark == "") {
            remark = "无";
        }
        Timestamp bTime = null;
        Timestamp eTime = null;
        if (beginTime != "" && beginTime != null) {
            StringBuilder strBuilder = new StringBuilder(beginTime);
            strBuilder.setCharAt(10, ' ');
            beginTime = strBuilder.toString();
            beginTime = beginTime + ":00";
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                bTime = Timestamp.valueOf(sdf.format(sdf.parse(beginTime)));
            } catch(Exception exception) {
                System.out.println("日期转换异常："+exception.toString());
            }
        }

        if (endTime != "" && endTime != null) {
            StringBuilder strBuilder = new StringBuilder(endTime);
            strBuilder.setCharAt(10, ' ');
            endTime = strBuilder.toString();
            endTime = beginTime + ":00";
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                eTime = Timestamp.valueOf(sdf.format(sdf.parse(endTime)));
            } catch(Exception exception) {
                System.out.println("日期转换异常："+exception.toString());
            }
        }

        PrivateCourseBooking bean = new PrivateCourseBooking(0, userId, coachId, bTime, eTime, remark);
        int num = privateCourseBookingService.addPrivateCourseBooking(bean);
        return num;
    }

    /**
     * 根据bookingId删除私教课程预约信息
     * @param bookingId
     * @return
     */
    @RequestMapping("/deletePrivateCourseBooking")
    @ResponseBody
    public Integer deletePrivateCourseBooking(Integer bookingId) {
        int num = privateCourseBookingService.deletePrivateCourseBooking(bookingId);
        return num;
    }

    /**
     * 去私教课程预约详细信息查看界面
     * @param bookingId
     * @param model
     * @return
     */
    @RequestMapping("/toPrivateCourseBookingDetail")
    public String toPrivateCourseBookingDetail(Integer bookingId, Model model) {
        PrivateCourseBooking bean = privateCourseBookingService.getPrivateCourseBookingById(bookingId);
        model.addAttribute("privateCourseBooking",bean);
        return "privateCourseBookingDetail";
    }

    /**
     * 去修改界面
     * @param bookingId
     * @param model
     * @return
     */
    @RequestMapping("/toUpdatePrivateCourseBooking")
    public String toUpdatePrivateCourseBooking(Integer bookingId, Model model) {
        PrivateCourseBooking bean = privateCourseBookingService.getPrivateCourseBookingById(bookingId);
        model.addAttribute("privateCourseBooking",bean);
        return "privateCourseBookingUpdate";  // 根据前端传来的bookingId查到该用户的信息，封装到model对象中，并带着数据跳转到privateCourseBookingUpdate.html页面
    }

    /**
     * 根据id修改私教课程预约信息
     * @return
     */
    @RequestMapping("/privateCourseBookingUpdate")
    @Transactional
    @ResponseBody
    public int privateCourseBookingUpdate(
            @RequestParam("bookingId")Integer bookingId,
            @RequestParam("beginTime")String beginTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("remark") String remark
    ){
        if (remark==null || remark == "") {
            remark = "无";
        }
        Timestamp bTime = null;
        Timestamp eTime = null;
        if (beginTime != "" && beginTime != null) {
            StringBuilder strBuilder = new StringBuilder(beginTime);
            strBuilder.setCharAt(10, ' ');
            beginTime = strBuilder.toString();
            beginTime = beginTime + ":00";
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                bTime = Timestamp.valueOf(sdf.format(sdf.parse(beginTime)));
            } catch(Exception exception) {
                System.out.println("日期转换异常："+exception.toString());
            }
        }

        if (endTime != "" && endTime != null) {
            StringBuilder strBuilder = new StringBuilder(endTime);
            strBuilder.setCharAt(10, ' ');
            endTime = strBuilder.toString();
            endTime = beginTime + ":00";
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                eTime = Timestamp.valueOf(sdf.format(sdf.parse(endTime)));
            } catch(Exception exception) {
                System.out.println("日期转换异常："+exception.toString());
            }
        }
        PrivateCourseBooking bean = new PrivateCourseBooking(bookingId, "", "", bTime, eTime, remark);
        int num = privateCourseBookingService.updatePrivateCourseBooking(bean);
        return num;
    }


}
