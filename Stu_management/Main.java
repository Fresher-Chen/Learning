
import java.util.Scanner;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell'
 */
public class Main {
    static Students[]  Stu= new Students[100];
    static Scanner scan = new Scanner(System.in);
    static int number = 0;
    
    public static void main(String[] args) {
        while(true){
            sys_menu();
        }
    }
    
    //Add a new student to the system.
     static void add(){
         while(true){
            System.out.println("Pls input \"Name Age Gender Student_Number Score\" in sequence. Type \"exit\" to exit."
            +"\nContinue?[Yes/exit]");
            if(!scan.next().equals("exit")){
                Stu[number] = new Students();
                System.out.println("Name:");        //Input name
                Stu[number].setName(scan.next());
                
                System.out.println("Age:");        //Input age
                int input_age = is_Int(scan.next());
                if(input_age>0&&input_age<130){
                    Stu[number].setAge(input_age);
                }
                else{
                    Students[] temp = new Students[number];
                    System.arraycopy(Stu, 0, temp, 0, number);
                    Stu = temp;
                    continue;
                }
                
                System.out.println("Gender:");        //Input gender
                Stu[number].setGender(scan.next());
                System.out.println("Student Number:");        //Input stu_num
                Stu[number].setStuNum(scan.next());
                
                System.out.println("Score:");        //Input Score
                int input_score = is_Int(scan.next());
                if(input_score>=0&&input_score<=100){
                    Stu[number].setScore(input_score);
                }
                else{
                    Students[] temp = new Students[number];
                    System.arraycopy(Stu, 0, temp, 0, number);
                    Stu = temp;
                    continue;
                }
           
               if(Stu.length==number+1) {
                   System.out.println("Saved!");
                   number++;
               }
            }
            else
                break;
         }
            
    }
     
     
     //Delete a student
    static void delete(){
        while(true){
            System.out.println("Input the Name or Student Number to detele a student.\n"
            + "1. Name or Student Number\n"
            + "2. exit");
            //***************************************Search with Name
            int choice = scan.nextInt();
            if(choice==1){
                sub_delete();
             }
            else if(choice==2){
                System.out.println("Exiting...");
                break;
             }
             //*****************Wrong Input
            else{
                    System.out.println("Invalid Input!!!\n");
             } 
         }       
    }

    
    
    //Modify 
    static void modify(){
        while(true){
            System.out.println("Input the Name or Student Number first,\"exit\" to exit:");
            String input = scan.next();
            lable1:
            for(int i=0;i<number;i++){
                if(input.equals(Stu[i].getName())||input.equals(Stu[i].getStuNum())){
                    System.out.println("Choose what you want to modify:"
                    + "\n1. Name:"
                    + "\n2. Age:"
                    + "\n3. Gender"
                    + "\n4. Student Number"
                    + "\n5. Score"
                    + "\nOthers:  Exit");
                    switch(scan.nextInt()){
                        case 1:
                            System.out.println("Input new Name:");
                            Stu[i].setName(scan.next());
                            System.out.println("Done!");
                            break;
                        case 2:
                            System.out.println("Input new Age:");
                            int set_age = is_Int(scan.next());
                            if(set_age>0&&set_age<130){
                                Stu[number].setAge(set_age);
                            }
                            else
                                break;
                            System.out.println("Done!");
                            break;
                        case 3:
                            System.out.println("Input new Gender:");
                            Stu[i].setGender(scan.next());
                            System.out.println("Done!");
                            break;
                        case 4:
                            System.out.println("Input new Student Number:");
                            Stu[i].setStuNum(scan.next());
                            System.out.println("Done!");
                            break;
                        case 5:
                            System.out.println("Input new Score:");
                            int set_score = is_Int(scan.next());
                            if(set_score>=0&&set_score<=100){
                                Stu[i].setScore(set_score);
                            }
                            else
                                break;
                            System.out.println("Done!");
                            break;
                        default:
                            System.out.println("Invalid Input!!!");
                            break lable1;
                    }
                }
            }
            System.out.println("Not Found!!");
            break;
        }
    }
    
    
    //Show the detial info of a student
    static void query(){
        System.out.print("\nInput Name or Student Number:");
        String input = scan.next();
        for(int i=0;i<number;i++){
            if(input.equals(Stu[i].getName())||input.equals(Stu[i].getStuNum())){
                System.out.println("     Name    Age   Gender  Stu_Number  Score");
                System.out.printf("%9s%5d%10s%10s%7d\n",Stu[i].getName(),Stu[i].getAge(),Stu[i].getGender(),Stu[i].getStuNum(),Stu[i].getScore());
                continue;
            }
            if(i==number-1)
                System.out.println("Not Found!!!");break;
        }
    }
    
    //show the info of all the students.
    static void show_all(){
        System.out.println("     Name    Age   Gender  Stu_Number  Score");
            for(int i=0;i<number;i++){
                System.out.printf("%9s%5d%10s%10s%7d\n",Stu[i].getName(),Stu[i].getAge(),Stu[i].getGender(),Stu[i].getStuNum(),Stu[i].getScore());
                //System.out.println(Stu[i].getName()+" "+Stu[i].getAge()+" "+Stu[i].getGender()+" "+Stu[i].getStuNum()+" "+Stu[i].getScore());
        }
    }

/*    
    void found_and_delete(int i){
        System.out.println("Name:"+Stu[i].getName()+"Student Number:"+Stu[i].getStuNum()
        +"\nDelete? [yes/No]:");
        if(scan.next().equals("yes")){
            for(;i<Stu.length-1;i++)
                Stu[i]=Stu[i+1];
            number--;
            System.out.println("Completed!");
    }
    }*/
    
    
    
    //sub-func of Delete function
    static void sub_delete(){
        System.out.println("Input the Name or Sutdent Number:");
        String del_str = scan.next();
        for(int i=0;i<number;i++){
            if(del_str.equals(Stu[i].getName())||del_str.equals(Stu[i].getStuNum())){
                System.out.println("Name:"+Stu[i].getName()+"Student Number:"+Stu[i].getStuNum()
                +"\nDelete? [yes/No]:");
                if(scan.next().equals("yes")){
                    for(;i<Stu.length-1;i++)
                        Stu[i]=Stu[i+1];
                    number--;
                    System.out.println("Completed!");
                    break;
                }
                else
                    continue;
            }  
            if(i==number-1){
               System.out.println("Not Found!"); 
            }
        }
        
    }
    
    
    static void sys_menu(){
        while(true){
            //System.out.println("Welcome to the Student Management System, Pls entre the password:");
            //if(scan.next().equals("admin"))
            System.out.println("\nWelcome! Max to 100 students to be stored. "
            +"\n1. Add"
            +"\n2. Delete"
            +"\n3. Modify"
            +"\n4. Query"
            +"\n5. Show all"
            +"\nothers: Exit");
            int choice = is_Int(scan.next());
            switch(choice){
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                    query();
                    break;
                case 5:
                    show_all();
                    break;
                default:
                    System.out.println("Bye~");
                    
            }
        }
    }
    
    
    static int is_Int(String input){
        int result = 0;
        try{
            result = Integer.parseInt(input);
        }catch (NumberFormatException ex) {
            System.out.println("Not a number!");
            return 0;
        }
        return result;
    }
    
   
    
}
    
