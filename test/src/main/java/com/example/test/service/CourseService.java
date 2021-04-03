package com.example.test.service;

import com.example.test.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {
    List<Course> getCourseList(int page, int limit);
    int getCourseListCount();
    Course getCourseById(Integer id);
    int addCourse(Course course);
    int updateCourse(Course course);
    int deleteCourse(Integer id);
}
