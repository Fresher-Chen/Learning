/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inherit;

/**
 *
 * @author Charles Chen
 */
public abstract class Programmer {      //改成抽象类
    private String name;
    
    public String getName()    //getter
    {
        return name;
    }
    
    public void setName(String name)   //setter
    {
        this.name = name;
    }
    
    public abstract void coding();        //coding方法   //改抽象方法
    //{
    //    System.out.println("Coding...");
   // }
    
    public abstract void debuging();      //debug方法   //改抽象方法
    //{
     //   System.out.println("Debuging...");
    //}
    
    
    public static void main(String[] args)      //main
    {
        /*Programmer pro = new Programmer();      //父类对象
        System.out.println("-----父类------");
        pro.coding();
        pro.debuging(); */
        
        JavaClass java = new JavaClass();       //子类java对象
        System.out.println("-----java子类------");
        java.coding();
        java.debuging();
        
        PythonClass python = new PythonClass();     //子类python对象
        System.out.println("-----python子类------");
        python.coding();
        python.debuging();
        
        Programmer p_j = new JavaClass();       //父类调用java子类重写方法/向上转型
        System.out.println("-----多态java------");
        p_j.coding();
        p_j.debuging();
        
        Programmer p_p = new PythonClass();     //父类调用python子类重写方法/向上转型
        System.out.println("-----多态python------");
        p_p.coding();
        p_p.debuging();
        
        
        
    }
}


