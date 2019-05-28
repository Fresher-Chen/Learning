/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;




/**
 *
 * @author Charles Chen
 */
public class TestSelectCourse {
    static int selectNum = 0;
    static int courseNum = 2;
    static Scanner scan = new Scanner(System.in);
    static int check_course=0;    //查询循环的计数器
    static int check_student=0;   //查询循环的计数器
    static Student[] Stu = new Student[100];    //实例化学生数组，max100
    static Course[] Cour = new Course[20];         //实例化课程数组
    static SelectCourse[] S_c = new SelectCourse[10];      //实例化选课数组，max10
    static String[] stuNames = new String[]{"Alice","Bob","Cindy"};
    static String[] stuIDs = new String[]{"2014aaa","2014bbb","2014ccc"};
    
    public static void main(String[] args) {
        Cour[0] = new Course("java", 3.0);       //实例化java课程条目，Java/3学分
        Cour[1] = new Course("C", 2.0);
        
        for(int i=0;i<3;i++){
            Stu[Student.nextID] = new Student(stuNames[i], stuIDs[i]);
            //System.out.println("NextID:"+Student.nextID);
        }

            
        while(true){
            System.out.println("Menu:\n"
                    + "1. Query\n"
                    + "2. Add Scores\n"
                    + "3. Average Score>=60\n"
                    + "4. Add Students\n"
                    + "5. Exit");
            
            //System.out.println("Type to add a object, \"exit\" to exit!");
            String menuChoice = scan.next();
            if(menuChoice.equals("1")){
                Query();
                continue;
            }
            else if(menuChoice.equals("2"))
                System.out.println("\nCreate an entry...");
            else if(menuChoice.equals("3")){
                Show();
                continue;
            }
            else if(menuChoice.equals("4")){
                adminAdd(); 
                continue ;
            }    
            else if(menuChoice.equals("5")){
                System.out.println("Bye~~"); 
                break;
            }
            else{
                System.out.println("Invalid Choice!");
                continue;
            }
            //输入格式待check
            
            System.out.println("Student ID:");
            String input_name = scan.next();
            System.out.println("Course Name(java/C):");
            String input_course = scan.next();
            System.out.println("Score:");
            double input_score = is_Double(scan.next());
            if (input_score<0||input_score>100) {
                System.out.println("Invalid Score!");
                continue;
            }

            S_c[selectNum] = new SelectCourse();        //先读入，check完格式合法性，再实例化对象
            S_c[selectNum].SelectCourse(input_name, input_course);
            S_c[selectNum].setScore(input_score);
            
            //check输入内容是否存在
            //int check_course;
            for(check_course=0;check_course<courseNum;check_course++){
                if((S_c[selectNum].getCourseName()).equals(Cour[check_course].getCourseName()))       //判断输入课程是否存在
                    break;    
            }
            if(check_course==courseNum){
                System.out.println("Course Name Not Found!");
                check_course=0;
                continue;
            }
            check_course=0;
            
            for(check_student=0;check_student<Student.nextID;check_student++){
                if(input_name.equals(Stu[check_student].getstudentID()))
                    break;   
            }
            if(check_student==Student.nextID){
                System.out.println("Invalid Student ID!");
                check_student=0;
                continue;
            }
            check_student=0;
            selectNum++; 
                

            //条目录入Course
            for(int i=0;i<courseNum;i++){
                if((S_c[selectNum-1].getCourseName()).equals(Cour[i].getCourseName())){      //判断添加的是哪门课
                    Cour[i].addCourse(S_c[selectNum-1].getScore(), S_c[selectNum-1].getCourseName());     //处理存入课程对象中
                    break;
                }
                if(i==courseNum-1)
                    System.out.println("No such Course!");
                break;
            }

            //条目录入Student
            String currentStuName = new String();
            double currentAver = 0;
            String currentStuID = new String();
            lable_save_stu:
            for(int a = 0;a<=Student.nextID;a++){
                //System.out.println("***debug*** a="+a);
                //System.out.println("***debug*** S_c ID/StuID="+S_c[selectNum-1].getStudentID()+Stu[a].getstudentID());
                if(S_c[selectNum-1].getStudentID().equals(Stu[a].getstudentID())){     //判断添加的哪个学生
                    double credit_H = 0;
                    currentStuName = Stu[a].getStudentName();
                    for(int j = 0;j<courseNum;j++){
                        if(Cour[j].getCourseName().equals(S_c[selectNum-1].getCourseName()))   //根据课名提取课时给学生对象，便于计算学生总学时
                            credit_H = Cour[j].getCreditHour(); 
                    }
                    for(int j=0;j<Student.nextID;j++){
                        //System.out.println("***debug*** j="+j);     //***********************debug
                        if((Stu[j].getstudentID()).equals(S_c[selectNum-1].getStudentID())){        //按StuID查找Sutdent对象
                            Stu[j].setAverageScore(S_c[selectNum-1].getScore(),credit_H);   //存成绩和学时到Student对象
                            currentAver = Stu[j].getAverageScore();
                            currentStuID = Stu[j].getstudentID();
                           // System.out.println("****debug***"+currentStuName+currentAver+currentStuID); //*****************debug
                            break lable_save_stu;
                        }   
                            
                        }
                }
            }
        
            //存本地
            try {
                File f = new File("D:\\student.txt");
                if(!f.exists())
                    f.createNewFile();
                try(FileWriter writer = new FileWriter(f,true);		//how to write to a file!!!
                        BufferedWriter out= new BufferedWriter(writer))
                {
                    //out.write("Name     StudentID      Score\n");
              
                    out.write(currentStuName+"          "+currentStuID+"          "+currentAver+"\n");      //写入的值待确定****************
                    
                    out.flush();
                    System.out.println("Saved to D:/student.txt");

                }catch(IOException e){            } 
            }catch (IOException e) {}
        }
    }
    
    

  
    
    //判断输入是否是int
    static int is_Int(String input){
        int result = -1;
        try{
            result = Integer.parseInt(input);
        }catch (NumberFormatException ex) {
            System.out.println("Not a number!");
            return -1;
        }
        return result;
    }
    
    static double is_Double(String input){
        int result = -1;
        try{
            result = Integer.parseInt(input);
        }catch (NumberFormatException ex) {
            //System.out.println("Not a number!");
            return -1;
        }
        return (double)result;
    }
    
    static void Query(){
        while(true){
        System.out.println("Input the Student ID:(\"e\" to exit)");
        String stuID = scan.next();
        if(stuID.equals("e"))
            return ;
        for(int i=0;i<stuIDs.length;i++){
            if(stuIDs[i].equals(stuID))
                break;
            if(i==stuIDs.length-1){
                System.out.println("Invalid Name!");
                return;
            }
        }
        String stuName = new String();
        for(int i=0;i<Student.nextID;i++){
            if((Stu[i].getstudentID()).equals(stuID))
            {    
                stuName = Stu[i].getStudentName();
                break;
            }
            
        }
        System.out.println("Scores for "+stuName+";");
        for(int i=0;i<selectNum;i++){
            if(S_c[i].getStudentID().equals(stuID))
                System.out.printf("%s: %.1f\n",S_c[i].getCourseName(),S_c[i].getScore());
        }
        }
    }
    
    static void Show(){
        for(int i=0;i<Student.nextID;i++){
            if(Stu[i].getAverageScore()>60.0)
                System.out.println(Stu[i].getStudentName());
        }
    }
    
    static void adminAdd(){
        String input_Name;
        String input_ID;
        System.out.println("Name:");
        input_Name = scan.next();
        
        for(int i=0;i<stuNames.length;i++){
            if(input_Name.equals(stuNames[i])){
                System.out.println("Existed Name!");
                return ;
            }
        }
        System.out.println("Student ID:");
        input_ID = scan.next();
        for(int i =0;i<stuIDs.length;i++){
            if(input_ID.equals(stuIDs[i])){
                System.out.println("Existed ID!");
                return ;
            }
        }
        String[] tempNames = new String[stuNames.length+1];
        String[] tempIDs = new String[stuIDs.length+1];
        System.arraycopy(stuNames, 0, tempNames,0,stuNames.length);
        tempNames[tempNames.length-1] = input_Name;
        stuNames=tempNames;
        
        System.arraycopy(stuIDs, 0, tempIDs,0,stuIDs.length);
        tempIDs[tempIDs.length-1] = input_ID;
        stuIDs=tempIDs;
        Stu[Student.nextID] = new Student(stuNames[stuNames.length-1], stuIDs[stuIDs.length-1]);
    }
    
}
