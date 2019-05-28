/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusystem;

/**
 *
 * @author Charles
 */
public class SelectCourse {
    private String studentID;
    private String courseName;
    private double score;
    //public static int courseNum = 0;
    
    public String getStudentID(){
        return this.studentID;
    }  
    
    public String getCourseName(){
        return this.courseName;
    }  
    
    public double getScore(){
        return this.score;
    }
    
    public void setScore(double score){
        this.score = score;
    }
    
    public void print(){
        System.out.printf("Student Name:%d\nCourse Name:%s\nScore:%d",this.studentID,this.courseName,this.score);
    }
    
    
    public void SelectCourse(String studentID,String courseName){
        this.studentID = studentID;
        this.courseName = courseName;
    }
    
 
}
