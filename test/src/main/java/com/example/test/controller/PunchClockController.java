package com.example.test.controller;

import com.example.test.entity.PunchClock;
import com.example.test.service.PunchClockService;
import com.example.test.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PunchClockController {
    @Autowired
    private PunchClockService punchClockService;

    /**
     * 进入打卡查看的接口
     * 通过Session中是否有curAdminName值进行访问权限控制和安全检查
     * */
    @RequestMapping("/punchClockList1")
    public String punchClockList1(HttpServletRequest request) {
        if(request.getSession().getAttribute("curAdminName") == null) {
            return "404_admin_login_expired"; //没有管理员登陆，妄图访问投诉管理页面，直接跳到404
        }
        return "punchClockListPage";
    }

    /**
     * 查询打卡信息列表
     * @return
     */
    @RequestMapping("/getPunchClockList")
    @ResponseBody
    public LayuiData getPunchClockList(HttpServletRequest request) {
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
        List<PunchClock> punchClockList = punchClockService.getPunchClockList(fullName, page, limit);
        layuiData.setData(punchClockList);
        int count = punchClockService.getPunchClockListCount();
        layuiData.setCode(0);
        layuiData.setCount(count);
        layuiData.setMsg("数据请求成功");
        return layuiData;
    }
}
