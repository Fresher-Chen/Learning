/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusystem;

/**
 *
 * @author dell'
 */
public class Student {
    private String studentID;
    private String studentName;
    private int courseNum = 0;
    private double averageScore = 0;
    private double creditHour = 0;
    public static int nextID = 0;
    {
        nextID++;
        //System.out.println(nextID);
    }
    
    public String getstudentID(){
        return this.studentID;
    }
    
    public String getStudentName(){
        return this.studentName;
    }
   
    
    public int getCourseNum(){
        return this.courseNum;
    }
    
    public double getAverageScore(){
        return this.averageScore;
    }
    
    
    public double getCreditHour(){
        return this.creditHour;
    }
    
    public int getNextID(){
        return nextID;
    }
    /*
    public void setCourseNum(int courseNum){    //读入课程，课程数增加，计算总学时
        this.courseNum = courseNum;
    }
    
    public void setAverageScore(int inputScore){
        this.averageScore = (this.averageScore+(double)inputScore)/(double)this.courseNum;
        
    }
    
    public void setCreditHour(double creditHour){
        this.creditHour = creditHour;
    }*/
    
    public void setAverageScore(double inputScore,double inputHour){
        this.courseNum++;                   //课程数累计加一
        this.averageScore = (this.averageScore + inputScore)/this.courseNum;    //重新计算平均成绩
        if(inputScore>=60.0)
           this.creditHour+=inputHour;         //总学时累加
    }
    
    public Student(String studentName,String studentID){
        this.studentID = studentID;
        this.studentName = studentName;
    }
    
    public void print(){
        System.out.printf("Student ID:%s\nStudent Name:%s\nCourse Number:%d\nAverage Score:%f\nCredit Hour:%f\nNext ID:%d",
                this.studentID,this.studentName,this.courseNum,this.averageScore,this.creditHour,nextID);
    }
    
}
