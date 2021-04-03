package com.example.test.controller;

import com.example.test.entity.Course;
import com.example.test.service.CourseService;
import com.example.test.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 进入课程管理的接口
     * 通过Session中是否有curAdminName值进行访问权限控制和安全检查
     * */
    @RequestMapping("/courseList1")
    public String courseList1(HttpServletRequest request) {
        if(request.getSession().getAttribute("curAdminName") == null) {
            return "404_admin_login_expired"; //没有管理员登录
        }
        return "courseListPage"; //courseListPage.html
    }

    /**
     * 查询课程信息列表
     * @return
     */
    @RequestMapping("/getCourseList")
    @ResponseBody
    public LayuiData getCourseList(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        if(page>0){
            page = (page-1)*limit;
        }
        LayuiData layuiData = new LayuiData();
        List<Course> courseList = courseService.getCourseList(page, limit);
        layuiData.setData(courseList);
        int count = courseService.getCourseListCount();
        layuiData.setCode(0);
        layuiData.setCount(count);
        layuiData.setMsg("数据请求成功");
        return layuiData;
    }

    /**
     * 到转到新增课程信息页面
     * @return
     */
    @RequestMapping("/toCourse")
    public String toCourse (){
        return "courseAdd";  //去到courseAdd.html
    }

    /**
     * 新增
     * @param teacherName
     * @param briefIntroduction
     * @param beginTime
     * @param endTime
     * @param capacity
     * @param price
     * @return
     */
    @RequestMapping("/courseAdd")
    @Transactional
    @ResponseBody
    public Integer courseAdd (
            String teacherName,
            String briefIntroduction,
            String beginTime, //"yyyy-MM-ddThh:mm"格式，Timestamp需要"yyyy-MM-dd hh:mm:ss"格式
            String endTime, //"yyyy-MM-ddThh:mm"格式，Timestamp需要"yyyy-MM-dd hh:mm:ss"格式
            Integer capacity,
            BigDecimal price
    ) {
        if (price == null) {
            price = new BigDecimal("0.00");
        }
        Timestamp bTime = null;
        Timestamp eTime = null;
        if (beginTime != "" && beginTime != null) {
            StringBuilder strBuilder = new StringBuilder(beginTime);
            strBuilder.setCharAt(10, ' ');
            beginTime = strBuilder.toString();
            beginTime = beginTime + ":00";

            StringBuilder strBuilder2 = new StringBuilder(endTime);
            strBuilder2.setCharAt(10, ' ');
            endTime = strBuilder2.toString();
            endTime = endTime + ":00";

            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                bTime = Timestamp.valueOf(sdf.format(sdf.parse(beginTime)));
                eTime = Timestamp.valueOf(sdf.format(sdf.parse(endTime)));
            } catch(Exception exception) {
                System.out.println("日期转换异常："+exception.toString());
            }
        }
        Course bean = new Course(0, teacherName, briefIntroduction, bTime, eTime, capacity, price);
        int num = courseService.addCourse(bean);
        return num;
    }

    /**
     * 根据id删除课程信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteCourse")
    @ResponseBody
    public Integer deleteCourse(Integer id) {
        int num = courseService.deleteCourse(id);
        return num;
    }

    /**
     * 去课程详细信息查看界面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toCourseDetail")
    public String toCourseDetail(Integer id, Model model) {
        Course bean = courseService.getCourseById(id);
        model.addAttribute("course",bean);
        return "courseDetail";
    }

    /**
     * 去修改界面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUpdateCourse")
    public String toUpdateCourse(Integer id, Model model) {
        Course bean = courseService.getCourseById(id);
        model.addAttribute("course",bean);
        return "courseUpdate";  // 根据前端传来的id查到该课程的信息，封装到model对象中，并带着数据跳转到courseUpdate.html页面
    }

    /**
     * 根据id修改课程信息
     * @return
     */
    @RequestMapping("/courseUpdate")
    @Transactional
    @ResponseBody
    public int courseUpdate(
            @RequestParam("id")Integer id,
            @RequestParam("teacherName")String teacherName,
            @RequestParam("briefIntroduction") String briefIntroduction,
            @RequestParam("beginTime") String beginTime,
            @RequestParam("endTime")String endTime,
            @RequestParam("capacity") Integer capacity,
            @RequestParam("price") BigDecimal price
    ){
        if (price == null) {
            price = new BigDecimal("0.00");
        }
        Timestamp bTime = null;
        Timestamp eTime = null;
        if (beginTime != "" && beginTime != null) {
            StringBuilder strBuilder = new StringBuilder(beginTime);
            strBuilder.setCharAt(10, ' ');
            beginTime = strBuilder.toString();
            beginTime = beginTime + ":00";

            StringBuilder strBuilder2 = new StringBuilder(endTime);
            strBuilder2.setCharAt(10, ' ');
            endTime = strBuilder2.toString();
            endTime = endTime + ":00";

            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                bTime = Timestamp.valueOf(sdf.format(sdf.parse(beginTime)));
                eTime = Timestamp.valueOf(sdf.format(sdf.parse(endTime)));
            } catch(Exception exception) {
                System.out.println("日期转换异常："+exception.toString());
            }
        }
        Course bean = new Course(id, teacherName, briefIntroduction, bTime, eTime, capacity, price);
        int num = courseService.updateCourse(bean);
        return num;
    }







}
