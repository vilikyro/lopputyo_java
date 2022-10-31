package com.vilikyro.lopputyo.data;

import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    private int age;
    private String studentID;
    private String groupID;
    private String email;
    private String number;

    public Student(String name, int age, String studentID, String groupID, String email, String number) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.groupID = groupID;
        this.email = email;
        this.number = number;
    }

    public Student(){
        this("", 0, "", "", "", "");
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
