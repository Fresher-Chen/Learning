/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charles Chen
 */
public class Students {
    private String name;
    private int age;
    private String gender;
    private String stu_num;
    private int score;
     
    
    public Students(){
    super();
    }
   
    public String getStuNum() {
        return stu_num;
    }
    public void setStuNum(String stu_num) {
        this.stu_num = stu_num;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}

