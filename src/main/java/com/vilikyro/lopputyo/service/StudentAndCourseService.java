package com.vilikyro.lopputyo.service;

import com.vilikyro.lopputyo.data.Student;
import com.vilikyro.lopputyo.data.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentAndCourseService {
    
    @Autowired
    FileService myFileService = new FileService();

    public List<Course> courses = new ArrayList<>();
    public List<Student> students = new ArrayList<>();

    public StudentAndCourseService() {
        courses = myFileService.readCoursesFromFile();
        students = myFileService.readStudentsFromFile();
    }

    public String addCourse(Course course) {

        if (course.getCourseName() == "" || course.getClassRoom() == "" || course.getTeacher() == "") {
            return "Course name, teacher and classroom required.";
        } else {
            courses.add(course);
            myFileService.writeCoursesToFile(courses);
            return "Course created successfully";
        }
    }

    public String addStudent(Student student) {
       
        if (student.getName() == "" || student.getAge() == 0 || student.getGroupID() == "" || student.getEmail() == ""
                || student.getNumber() == "") {
            return "Student name, age, groupId, email and phonenumber required.";
        } else {
            if (students.stream().anyMatch(o -> o.getEmail().equals(student.getEmail()))) {
                return "This email is already in use";
            }
            else if (students.stream().anyMatch(o -> o.getName().equals(student.getName()))) {
                return "This name is already in use";
            } else {
                students.add(student);
                myFileService.writeStudentsToFile(students);
                return "Student created successfully";
            }
        }
    }
    // If students and co
    public String addStudentToCourse(String studentID, String courseID) {

        if (studentID == "" || courseID == "") {
            return "StudentId and CourseId required";
        } else {
            for (Student student : students) {
                if (student.getStudentID().equals(studentID)) {
                    for (Course course : courses) {
                        if (course.getCourseID().equals(courseID)) {
                            
                            if (!course.getParticipants().stream().anyMatch(o -> o.getStudentID().equals(studentID))) {
                                course.addParticipants(student);
                                myFileService.writeCoursesToFile(courses);
                                return "Student added to course successfully";
                            }                          
                            return "Student already in course";
                        }
                    }                  
                    return "Course not found";
                }
            }
            return "Student not found";
        }
    }

}