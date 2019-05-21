/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inherit;

/**
 *
 * @author dell'
 */
public class JavaClass extends Programmer{
    private String name;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void coding()
    {
        System.out.println("JAVA coding...");
    }
    
    public void debuging()
    {
        System.out.println("JAVA debuging...");
    }
}
