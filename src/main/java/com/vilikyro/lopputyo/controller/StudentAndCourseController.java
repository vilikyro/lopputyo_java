package com.vilikyro.lopputyo.controller;

import com.vilikyro.lopputyo.data.Course;
import com.vilikyro.lopputyo.data.Student;
import com.vilikyro.lopputyo.service.StudentAndCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentAndCourseController {
    
    @Autowired
    StudentAndCourseService service;

    @GetMapping("courses")
    public List<Course> getCourses(){
        return service.courses;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        return service.students;
    }

    @PostMapping("addcourse")
    public String addCourse(@RequestBody Course course){
        return service.addCourse(course);
    }

    @PostMapping("addstudent")
    public String addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @PostMapping("addstudenttocourse")
    public String addStudentToCourse(@RequestBody Map<String, Object> jsonMapping){
        String studentId = jsonMapping.get("studentID").toString();
        String courseId = jsonMapping.get("courseID").toString();

        return service.addStudentToCourse(studentId, courseId);
    }
}