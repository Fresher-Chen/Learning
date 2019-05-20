/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.translate;

import java.util.Scanner;


/**
 *
 * @author dell'
 */
public class Operate {
    private int method;
    private String value;
    //打印初始菜单
    public void Menu()
    {
        System.out.println("1: 10-->16\n"
                + "2:10-->2\n"
                + "3:16-->10\n"
                + "4:16-->2\n"
                + "5:2-->10\n"
                + "6:2-->16\n"
                + "For example, Input: 1 12  Output:c\n"
                +"Pls choose the method and input a value:");
    }
    //转换计算
    public String Caculate(int method, String value)
    {
        String result = new String();
        switch(method){
            case 1:  //10 to 16
                result = Integer.toHexString(Integer.parseInt(value));
                break;
            case 2:  //10 to 2
                result = Integer.toBinaryString(Integer.parseInt(value));
                break;
            case 3:  //16 to 10
                result = Integer.valueOf(value,16).toString();
                break;
            case 4:  //16 to 2
                break;
            case 5:  //2 to 10
                result = Integer.valueOf(Integer.toString(Integer.parseInt(value)),2).toString();
            case 6:  //2 to 16
                break;
            default:
                result = "illegal Input!";
                break;
        }
        return result;
    }
    //执行函数
    public String Operate()
    {
        Menu();
        Scanner inValue = new Scanner(System.in);
        String str = inValue.nextLine();
        String[] numstr = str.split(" ");
        method = Integer.parseInt(numstr[0]);
        value = numstr[1];
        return Caculate(method, value);
    }
    
    
    
  /*  public String hex2Byte(String hexStr)  //16进制转2进制
    {
        if(hexStr.length()<1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for(int i=0;i<hexStr.length()/2;i++)
        {
             int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16); 
             int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
             result[i] = (byte) (high * 16 + low); 
        }
        System.out.print("***debug: result="+value);
        String s = new String(result);
        return s;
    }
    
    
    
    public String byte2Hex(byte buf[])   //2进制转16进制
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++)
        {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1)
                hex = '0' + hex;
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    */
}    
