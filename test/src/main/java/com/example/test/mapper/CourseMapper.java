package com.example.test.mapper;

import com.example.test.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> getCourseList(@Param("page") int page, @Param("limit") int limit);
    int getCourseListCount();
    Course getCourseById(@Param("id") Integer id);
    int addCourse(@Param("course") Course course);
    int updateCourse(@Param("course") Course course);
    int deleteCourse(@Param("id") Integer id);
}
