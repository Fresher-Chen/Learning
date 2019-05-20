/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author dell'
 */
public class Read {
    public void readFile(String filePath)    //读取文件模块
    {   
        //
        //File f = new File(filePath);
        try(FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader))
        {   //FileReader reader = new FileReader(filePath);
            //BufferedReader br = new BufferedReader(reader);
            String line;
            while((line = br.readLine())!=null)
            {
                System.out.println(line);
            }
        }catch (IOException e){
                e.printStackTrace();}
       
    }
}
