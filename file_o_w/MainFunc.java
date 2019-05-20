/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.file;

import java.util.Scanner;

/**
 *
 * @author dell'
 */
public class MainFunc {
    public static void main(String[] args)
    {
        System.out.println("Choose the function first:\n"
                + "1. Open a file\n"
                + "2. Write to a file");
        
        Scanner scan1 = new Scanner(System.in);
        String choice = scan1.next();
        //scan1.close();
        
        if(choice.equals("1"))   //输出一个文本的内容
        {
            System.out.println("Input the full path of the file:");
            Scanner scan2 = new Scanner(System.in);
            String filePath = scan2.next();
            Read readf = new Read();
            readf.readFile(filePath);
        }
        else if(choice.equals("2"))  //向一个文件写入
        {
            System.out.println("Input the full path of the file:");
            Scanner scan2 = new Scanner(System.in);
            String filePath = scan2.next();
            System.out.println("Write 1 line to the file,Input \'bye\' to exit:");
            Scanner scan3 = new Scanner(System.in);
            
            String writeLine = scan3.nextLine();
            
            Write writef = new Write();
            while(!writeLine.equals("bye"))
            {
                writef.writeToFile(filePath,writeLine);
                writeLine = scan3.nextLine(); 
            }
        }
        else
            System.out.println("Wrong Input!"); 
    }   
}
