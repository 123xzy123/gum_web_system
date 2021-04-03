package com.example.test.serviceImpl;

import com.example.test.entity.Course;
import com.example.test.mapper.CourseMapper;
import com.example.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getCourseList(int page, int limit) {
        return courseMapper.getCourseList(page, limit);
    }

    @Override
    public int getCourseListCount() {
        return courseMapper.getCourseListCount();
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseMapper.getCourseById(id);
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public int deleteCourse(Integer id) {
        return courseMapper.deleteCourse(id);
    }
}
