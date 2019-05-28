/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Charles Chen
 */
public class Write {
    public void writeToFile(String filePath, String writeLine)
    {
        try {
            File f = new File(filePath);
            f.createNewFile();
            try(FileWriter writer = new FileWriter(f,true);		//how to write to a file!!!
                BufferedWriter out= new BufferedWriter(writer))
            {
                //FileWriter writer = new FileWriter(f);
                //BufferedWriter out= new BufferedWriter(writer);
                out.write(writeLine+"\r\n");
                out.flush();
                System.out.println("Type \'bye\' to exit:");
               
            }catch(IOException e){e.printStackTrace();
        } 
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
