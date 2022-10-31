package com.vilikyro.lopputyo.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vilikyro.lopputyo.service.StudentAndCourseService;

public class Course implements Serializable{
    private String courseName;
    private String courseID;
    private String teacher;
    private String classRoom;

    private List<Student> participants;


    public Course(String courseName, String courseID, String teacher, String classRoom) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.teacher = teacher;
        this.classRoom = classRoom;
        this.participants = new ArrayList<>();
    }

    public Course(){
        this("", "", "", "");
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return this.courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public List<Student> getParticipants() {
        return this.participants;
    }

    public void addParticipants(Student student){
        this.participants.add(student);
    }

}
