package com.example.test.controller;

import com.example.test.entity.CoachInfo;
import com.example.test.service.CoachInfoService;
import com.example.test.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CoachInfoController {
    @Autowired
    private CoachInfoService coachInfoService;

    /**
     * 进入教练管理的接口
     * 通过Session中是否有curAdminName值进行访问权限控制和安全检查
     * */
    @RequestMapping("/coachInfoList1")
    public String coachInfoList1(HttpServletRequest request) {
        if(request.getSession().getAttribute("curAdminName") == null) {
            return "404_admin_login_expired"; //没有管理员登陆，妄图访问投诉管理页面，直接跳到404
        }
        return "coachInfoListPage";
    }

    /**
     * 查询教练信息列表
     * @return
     */
    @RequestMapping("/getCoachInfoList")
    @ResponseBody
    public LayuiData getCoachInfoList(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        if(page>0){
            page = (page-1)*limit;
        }
        String fullName = request.getParameter("fullName");
        if (fullName == null) {
            fullName = "";
        }
        LayuiData layuiData = new LayuiData();
        List<CoachInfo> coachInfoList = coachInfoService.getCoachInfoList(fullName, page, limit);
        layuiData.setData(coachInfoList);
        int count = coachInfoService.getCoachInfoCount();
        layuiData.setCode(0);
        layuiData.setCount(count);
        layuiData.setMsg("数据请求成功");
        return layuiData;
    }

    /**
     * 到转到新增教练信息页面
     * @return
     */
    @RequestMapping("/toCoachInfo")
    public String toCoachInfo (){
        return "coachInfoAdd";  //coachInfoAdd.html
    }

    /**
     * 新增
     * @param coachId
     * @param nickName
     * @param phoneNumber
     * @param fullName
     * @param sex
     * @param star
     * @param introduction
     * @return
     */
    @RequestMapping("/coachInfoAdd")
    @Transactional
    @ResponseBody
    public Integer coachInfoAdd (
            String coachId,
            String nickName,
            String phoneNumber,
            String fullName,
            String sex,
            Integer star,
            String introduction
    ) {
        if (star == null) {
            star = 3;
        }
        CoachInfo bean = new CoachInfo(coachId, nickName, phoneNumber, fullName, sex, introduction, star);
        int num = coachInfoService.addCoachInfo(bean);
        return num;
    }

    /**
     * 根据coachId删除教练信息
     * @param coachId
     * @return
     */
    @RequestMapping("/deleteCoachInfo")
    @ResponseBody
    public Integer deleteCoachInfo(String coachId) {
        int num = coachInfoService.deleteCoachInfo(coachId);
        return num;
    }

    /**
     * 去教练详细信息查看界面
     * @param coachId
     * @param model
     * @return
     */
    @RequestMapping("/toCoachInfoDetail")
    public String toCoachInfoDetail(String coachId, Model model) {
        CoachInfo bean = coachInfoService.getCoachInfoById(coachId);
        model.addAttribute("coachInfo",bean);
        return "coachInfoDetail";
    }

    /**
     * 去修改界面
     * @param coachId
     * @param model
     * @return
     */
    @RequestMapping("/toUpdateCoachInfo")
    public String toUpdateCoachInfo(String coachId, Model model) {
        CoachInfo bean = coachInfoService.getCoachInfoById(coachId);
        model.addAttribute("coachInfo",bean);
        return "coachInfoUpdate";  // 根据前端传来的coachId查到该教练的信息，封装到model对象中，并带着数据跳转到coachInfoUpdate.html页面
    }

    /**
     * 根据coachid修改教练信息
     * @return
     */
    @RequestMapping("/coachInfoUpdate")
    @Transactional
    @ResponseBody
    public int userInfoUpdate(
            @RequestParam("coachId")String coachId,
            @RequestParam("nickName")String nickName,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("fullName") String fullName,
            @RequestParam("sex")String sex,
            @RequestParam("introduction") String introduction,
            @RequestParam("star") Integer star
    ){
        if (star == null) {
            star = 3;
        }

        CoachInfo bean = new CoachInfo(coachId, nickName, phoneNumber, fullName, sex, introduction, star);
        int num = coachInfoService.updateCoachInfo(bean);
        return num;
    }


}
