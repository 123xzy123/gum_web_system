package com.example.test.controller;

import com.example.test.entity.UserInfo;
import com.example.test.service.UserInfoService;
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
public class UserInfoController {
    //将Service注入Web层
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 进入用户管理的接口
     * 通过Session中是否有curAdminName值进行访问权限控制和安全检查
     * */
    @RequestMapping("/userInfoList1")
    public String userInfoList1(HttpServletRequest request) {
        if(request.getSession().getAttribute("curAdminName") == null) {
            return "404_admin_login_expired"; //没有管理员登陆，妄图访问投诉管理页面，直接跳到404
        }
        return "userInfoListPage";
    }

    /**
     * 查询用户信息列表
     * @return
     */
    @RequestMapping("/getUserInfoList")
    @ResponseBody
    public LayuiData getUserInfoList(HttpServletRequest request) {
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
        List<UserInfo> userInfoList = userInfoService.getUserInfoList(fullName, page, limit);
        layuiData.setData(userInfoList);
        int count = userInfoService.getUserInfoListCount();
        layuiData.setCode(0);
        layuiData.setCount(count);
        layuiData.setMsg("数据请求成功");
        return layuiData;
    }

    /**
     * 到转到新增用户信息页面
     * @return
     */
    @RequestMapping("/toUserInfo")
    public String toUserInfo (){
        return "userInfoAdd";  //去到userInfoAdd.html
    }

    /**
     * 新增
     * @param userId
     * @param nickName
     * @param phoneNumber
     * @param fullName
     * @param sex
     * @param membershipLevel
     * @param membershipDeadline
     * @return
     */
    @RequestMapping("/userInfoAdd")
    @Transactional
    @ResponseBody
    public Integer userInfoAdd (
            String userId,
            String nickName,
            String phoneNumber,
            String fullName,
            String sex,
            Integer membershipLevel,
            String membershipDeadline //"yyyy-MM-ddThh:mm"格式，Timestamp需要"yyyy-MM-dd hh:mm:ss"格式
    ) {
        if (membershipLevel == null) {
            membershipLevel = 0;
        }

        Timestamp mddl = null;
        if (membershipDeadline != "" && membershipDeadline != null) {
            StringBuilder strBuilder = new StringBuilder(membershipDeadline);
            strBuilder.setCharAt(10, ' ');
            membershipDeadline = strBuilder.toString();
            membershipDeadline = membershipDeadline + ":00";

            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                mddl = Timestamp.valueOf(sdf.format(sdf.parse(membershipDeadline)));
            } catch(Exception exception) {
                System.out.println("日期转换异常："+exception.toString());
            }
        }
        UserInfo bean = new UserInfo(userId, nickName, phoneNumber, fullName, sex, membershipLevel, mddl);
        int num = userInfoService.addUserInfo(bean);
        return num;
    }

    /**
     * 根据userId删除用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/deleteUserInfo")
    @ResponseBody
    public Integer deleteUserInfo(String userId) {
        int num = userInfoService.deleteUserInfo(userId);
        return num;
    }

    /**
     * 去用户详细信息查看界面
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/toUserInfoDetail")
    public String toUserInfoDetail(String userId, Model model) {
        UserInfo bean = userInfoService.getUserInfoById(userId);
        model.addAttribute("userInfo",bean);
        return "userInfoDetail";
    }

    /**
     * 去修改界面
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/toUpdateUserInfo")
    public String toUpdateUserInfo(String userId, Model model) {
        UserInfo bean = userInfoService.getUserInfoById(userId);
        model.addAttribute("userInfo",bean);
        return "userInfoUpdate";  // 根据前端传来的userId查到该用户的信息，封装到model对象中，并带着数据跳转到userInfoUpdate.html页面
    }

    /**
     * 根据id修改用户信息
     * @return
     */
    @RequestMapping("/userInfoUpdate")
    @Transactional
    @ResponseBody
    public int userInfoUpdate(
            @RequestParam("userId")String userId,
            @RequestParam("nickName")String nickName,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("fullName") String fullName,
            @RequestParam("sex")String sex,
            @RequestParam("membershipLevel") Integer membershipLevel,
            @RequestParam("membershipDeadline") String membershipDeadline
    ){
        if (membershipLevel == null) {
            membershipLevel = 0;
        }

        Timestamp mddl = null;
        if (!("".equals(membershipDeadline))  && membershipDeadline != null) {
            StringBuilder strBuilder = new StringBuilder(membershipDeadline);
            strBuilder.setCharAt(10, ' ');
            membershipDeadline = strBuilder.toString();
            membershipDeadline = membershipDeadline + ":00";

            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                mddl = Timestamp.valueOf(sdf.format(sdf.parse(membershipDeadline)));
            } catch(Exception exception) {
                System.out.println("日期转换异常："+exception.toString());
            }
        }
        UserInfo bean = new UserInfo(userId, nickName, phoneNumber, fullName, sex, membershipLevel, mddl);
        int num = userInfoService.updateUserInfo(bean);
        return num;
    }





}
