import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//-----------------------------------------------------------
abstract class Person{
  
  private String full_name, id;

 public Person(String full_name, String id){
    this.id=id;
    this.full_name=full_name;
  }

  public Person(){
    
    this.full_name="";
    this.id="";
  }


  public void setfullname(String full_name){
        this.full_name=full_name;
    }


  public void setID(String id){
        this.id=id;
    }

  public String getfullname(){
    return this.full_name;
    
  }
  public String getID(){
       return this.id;
    }

  public abstract void print();
   

  

}
//---------------------------------------------------------------
class Employee extends Person{

private String department;

  public Employee(){
    super();
    this.department="";
  }

  public Employee(String full_name, String id, String department){
    super( full_name, id);
    this.department=department;
  }

  public void setDep(String department){
   this.department=department;
  }

  public String getDep(){
    return this.department;
  }
  @Override
   public void print(){
     
   }


  
}
//-----------------------------------------------------------------------------

class Faculty extends Employee{
private String rank;

  public Faculty(){
    super();
    this.rank="";
  }

  public Faculty(String full_name, String id, String department, String rank){
    super( full_name, id, department);
    this.rank=rank;
  }

  public void setRank(String rank){
   this.rank=rank;
  }

  public String getrank(){
    return this.rank;
  }
  @Override
  public void print(){
    System.out.println("\n" + "--------------------------------------------------------------------------- \n"+ this.getfullname()+ "        " + this.getID() + "\n" + this.getDep()+" Department, "+this.getrank() +"\n---------------------------------------------------------------------------");
      
  
  }


  @Override
  public String toString(){
   return (this.getfullname()+"\nID: " + this.getID() + "\n"+ this.getrank()+","+this.getDep());
      
  
  }
  

  
}

//---------------------------------------------------------

class Staff extends Employee{
private String status;

  public Staff(){
    super();
    this.status="";
  }

  public Staff(String full_name, String id, String department, String status){
    super( full_name, id, department);
    this.status=status;
  }

  public void setRank(String status){
   this.status=status;
  }

  public String getStatus(){
    return this.status;
  }

   @Override
  public void print(){
    System.out.println("\n" + "--------------------------------------------------------------------------- \n"+ this.getfullname()+ "        " + this.getID() + "\n" + this.getDep()+" Department, "+this.getStatus() +"\n---------------------------------------------------------------------------");
      
  
  }

  @Override
  public String toString(){
    return (this.getfullname()+"\nID: " + this.getID() + "\n"+ this.getDep()+","+this.getStatus());



    
  }

}
//-------------------------------------------------------------------------
class Student extends Person{

  //236.45 per credit + 52 admin fee (25% off if gpa>3.85)

  private double gpa, credits_taken;
  private boolean isScholar;

  public Student(){
    super();
    this.gpa=0.00;
    this.credits_taken=0.0;
    this.isScholar=false;
  }

  public Student(String full_name, String id, double gpa, double credits_taken, boolean isScholar){
  super( full_name, id);
  this.credits_taken=credits_taken;
  this.gpa=gpa;
    this.isScholar=isScholar;
  }

  public void setgpa(double gpa){
   this.gpa=gpa;
  }


   public void setcredits(double credits_taken){
   this.credits_taken=credits_taken;
  }

  public double getgpa(){
    return this.gpa;
  }

  public double getcreditstaken(){
    return this.credits_taken;
  }


@Override
  public void print(){
    if(isScholar==true){
      System.out.println("Here is the tuition invoice for " + this.getfullname()+ " :\n" + "--------------------------------------------------------------------------- \n"+ this.getfullname()+ "        " + this.getID() + "\nCredit Hours:" + String.format("%.0f",this.getcreditstaken())+ " ($236.45/credit hour)\n " + "Fees: $52\n" +"\nTotal payment (after discount): $"+String.format("%.2f",((52+236.45*this.getcreditstaken())*0.75))+ "    (" + String.format("%.2f",((52+236.45*this.getcreditstaken())*0.25)) + "$discount applied"+")\n---------------------------------------------------------------------------");
      
    }
    else{
      System.out.println("Here is the tuition invoice for " + this.getfullname()+ " :\n" + "--------------------------------------------------------------------------- \n"+ this.getfullname()+ "        " + this.getID() + "\nCredit Hours:" + String.format("%.0f",this.getcreditstaken())+ " ($236.45/credit hour)\n " + "Fees: $52" +"\nTotal payment (after discount): $"+String.format("%.2f",((52+236.45*this.getcreditstaken())))+ "    (" + String.format("%.2f",((52+236.45*this.getcreditstaken())*0.0)) +"$discount applied"+")\n---------------------------------------------------------------------------");
      
    }
}

  @Override
  public String toString(){
  
      return (this.getfullname()+"\nID: " + this.getID() + "\nGpa: "+String.format("%.2f",this.getgpa())+ "\nCredit Hours: " + String.format("%.0f",this.getcreditstaken()));
      
    
   
    
  }
  
    


  }



//----------------------------------------------------------------------

  public class Project2{

public static boolean isNumeric(String string) {

  
    double gpaValue;
		
    //System.out.println(String.format("Parsing string: \"%s\"", string));
		
    if(string == null || string.equals("")) {
        //System.out.println("String cannot be parsed, it is null or empty.");
        return false;
    }
    
    try {
        gpaValue = Double.parseDouble(string);
        return true;
    } catch (NumberFormatException e) {
        //System.out.println("Input String cannot be parsed to Integer.");
    }
    return false;
}




    
   public static boolean isIdValid(String ID)
   {
      boolean result = true;
      if(ID.length()!=6)
      {
         result= false;
      }
      else if(ID.length()==6)
      {    while(true){
         if(Character.isLetter(ID.charAt(0))==false)
         {
            result=false;
           break;
           
         }

        if(Character.isLetter(ID.charAt(1))==false)
         {
            result=false;
           break;
         }

        if(Character.isDigit(ID.charAt(2))==false)
         {
            result=false;
           break;
         }

        if(Character.isDigit(ID.charAt(3))==false)
         {
            result=false;
           break;
         }

        if(Character.isDigit(ID.charAt(4))==false)
         {
            result=false;
           break;
         }

        if(Character.isDigit(ID.charAt(5))==false)
         {
            result=false;
           break;
         }
        
        break;

      }
        
        
      }
      

      return result;   
   }



    





    public static String capitalizeFirstLetter(String str) {//method to capitalize first letter of string that needs printing

    // converting first letter to uppercase
    String capitalized = str.substring(0, 1).toUpperCase() + str.substring(1);

    return capitalized;
}
   
    
    
 
 public static void main(String[] args){  
   Scanner sc = new Scanner(System.in);
   boolean answ=false;//boolean for while loop running whole thing

   Student[] students = new Student[5000];
   Person[] person = new Person[5000];
   Faculty[] faculty = new Faculty[5000];
   Staff[] staff = new Staff[5000];
   Staff staff_start = new Staff();
     Student stud_start = new Student();
   Faculty fac_start = new Faculty();
   students[0]=stud_start;
   staff[0]=staff_start;
   faculty[0]=fac_start;
   person[0]=stud_start;
   int numStuds=0;
   int numPpl=0;
   int numFaculty=0;
   int numStaff=0;
   System.out.println("Welcome to my Personal Management Program");

   //Vars and arrays Used throughout
  

   
     
       
       
   
   while(answ==false){//keep running till this is true which only 7 or max people
 System.out.println("\n\n1-  Enter the information a faculty \n2-  Enter the information of a student \n3-  Print tuition invoice for a student \n4-  Print faculty information \n5-  Enter the information of a staff member \n6-  Print the information of a staff member \n7-  Exit Program  \n");
     


   

   System.out.print("Enter your selection: ");
       
     

   String respon= sc.nextLine();

     if((respon.equals("4")==true)&&numFaculty==0){//if fac search but none input yet so runs smoothly
        System.out.print("Enter the Faculty’s id: ");
       String fake_id=sc.nextLine();
        System.out.println("No Faculty member matched! ");
       
     }
     else if((respon.equals("3")==true)&&numStuds==0){//if stud search but none input yet so runs smoothly
       System.out.print("Enter the Student’s id: ");
       String fake_id=sc.nextLine();
        System.out.println("No Student matched! ");
     }
     else if((respon.equals("6")==true)&&numStaff==0){//if staff search but none input yet so runs smoothly
      System.out.print("Enter the Staff’s id:");
       String fake_id=sc.nextLine();
        System.out.println("No Staff member matched! ");
     }
      else if(respon.equals("1")==true){//faculty input
     System.out.println("\nEnter the faculty info: ");

      System.out.print("\nName of faculty: ");
     String fac_name = sc.nextLine();//faculty name
     

     String fac_id = " ";
     

     

          boolean isIDcorrect=false;
        boolean isIDdup=false;
          while(isIDcorrect==false){
            System.out.print("\nID: ");
     
            fac_id=sc.next();
            
          isIDcorrect=isIdValid(fac_id);
            for(int i=0;i<numPpl;i++){
            if(fac_id.equals(person[i].getID())){
              isIDcorrect=false;
              isIDdup=true;
            }
              }
            if(isIDcorrect==false&&isIDdup==false){
              System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
            }
            if(isIDcorrect==false&&isIDdup==true){
              System.out.println("ID is duplicate ");
            }
            
          }
          sc.nextLine();//faculty id

      System.out.print("\nRank: ");
     String fac_rank = sc.nextLine();//rank
       String fac_holder=fac_rank;
    fac_rank=fac_rank.toLowerCase();
    
    //turned to lowercase to check is these words w no capital errors
      while(fac_rank.equals("professor")==false&&(fac_rank.equals("adjunct"))==false){
            System.out.println("\""+fac_holder+"\""+" is invalid");
        System.out.print("Rank: ");
      fac_rank = sc.nextLine();
        fac_holder=fac_rank;//holder for org and switching
        fac_rank=fac_rank.toLowerCase();
        
    }
    
     System.out.print("\nDepartment: ");
    String fac_dep = sc.nextLine();
    fac_dep=fac_dep.toLowerCase();//dep input and to lower to check if these words w no capital errors
    while(fac_dep.equals("engineering")==false&&(fac_dep.equals("mathematics"))==false&&(fac_dep.equals("english"))==false){
            System.out.println("\""+fac_dep+"\""+" is invalid");
      System.out.print("Department: ");
      fac_dep = sc.nextLine();
      fac_dep=fac_dep.toLowerCase();
    }

    fac_dep.toUpperCase();

    fac_dep=capitalizeFirstLetter(fac_dep);//right word form
    fac_rank=capitalizeFirstLetter(fac_rank);

    Faculty fac_info = new Faculty(fac_name, fac_id, fac_dep, fac_rank);//making faculty
     

     faculty[numFaculty]=fac_info;
     person[numPpl]=fac_info;
     numFaculty++;
     numPpl++;
    System.out.println("Faculty added!");
        //putting to arrays and adding to keep track of num

    
  }
   else if(respon.equals("2")==true){
     
     boolean isScholar=false;
    System.out.println("\nEnter the student info: ");

      System.out.print("\nName of Student: ");
     String stud_name = sc.nextLine();

     String stud_id = " ";
     

     

          boolean isIDcorrect=false;
        boolean isIDdup=false;
          while(isIDcorrect==false){
            System.out.print("\nID: ");
     
            stud_id=sc.next();
            
          isIDcorrect=isIdValid(stud_id);
            for(int i=0;i<numPpl;i++){
            if(stud_id.equals(person[i].getID())){
              isIDcorrect=false;
              isIDdup=true;
            }
              }
            if(isIDcorrect==false&&isIDdup==false){
              System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
            }
            if(isIDcorrect==false&&isIDdup==true){
              System.out.println("ID is duplicate ");
            }
            
          }
          sc.nextLine();
     

     
     Double stud_gpa=0.0;
     boolean number=false;
     
    

     System.out.print("\nGpa: ");
     String gpa_hold = sc.next();
     while(number==false){
     
     
     if(isNumeric(gpa_hold)) { 
    //System.out.println("String is numeric!");
    // Do something
        stud_gpa= Double.parseDouble(gpa_hold); 
       number=true;
} else {
    System.out.print("GPA is not a number input again: ");
       gpa_hold = sc.next();
       
}
     }
     
     if (stud_gpa>=3.75){
       isScholar=true;//to see discount for invoice
       
     }

     System.out.print("\nCredit hours:  ");
     
     Double stud_credHrs=0.0;
     boolean number2=false;
     String stud_Str_credHrs = sc.next();
    

    
     while(number2==false){
     
     
     if(isNumeric(stud_Str_credHrs)) { 
    //System.out.println("String is numeric!");
    // Do something
        stud_credHrs= Double.parseDouble(stud_Str_credHrs); 
       number2=true;
} else {
    System.out.print("Credit input is not a number input again: ");
       stud_Str_credHrs = sc.next();
       
}
     }


     System.out.println("\nStudent added!");

     Student studinfo = new Student(stud_name, stud_id, stud_gpa, stud_credHrs, isScholar);
     

     students[numStuds]=studinfo;
     person[numPpl]=studinfo;
     numStuds++;
     numPpl++;
sc.nextLine();
     //all same as previous just with diff vars
   }
    else if(respon.equals("3")==true){
      boolean stud_and_pers=false;
     

       System.out.print("Enter the student’s id: ");
       
       String stud_input=sc.nextLine();//input to search for stud
     
      for(int i=0;i<=numStuds;i++){//checking if any equal if all null set " "
        String stud_holder = students[i].getID();
        if(students[i].getID().equals(null)){
          stud_holder=" ";
        }
         if(stud_input.equals(stud_holder)==true){//if there is can get
           stud_and_pers=true;
           break;
         }
        else if(i==numStuds-1){//if none match
          System.out.println("No student matched! ");
          break;
        }
        

        
      }
      
       for(int i=0;i<=numPpl;i++){
         String holder = person[i].getID();
         if(stud_input.equals(holder)==true&&(stud_and_pers==true)){
           person[i].print();//print the person
        
           break;
           
         }
         else if(i==numPpl-1){
           
           break;
         }
        
         
         
           
      
       }

         
       
       
       
     }
      else if(respon.equals("4")==true){//same as 3 but for faculty

        boolean fac_and_pers=false;

       System.out.print("Enter the Faculty’s id: ");
       
       String fac_input=sc.nextLine();
       

        for(int i=0;i<=numFaculty;i++){
        String fac_holder = faculty[i].getID();
          if(faculty[i].getID().equals(null)){
            fac_holder="  ";
          }
         if(fac_input.equals(fac_holder)==true){
           fac_and_pers=true;
           break;
         }
          else if(i==numFaculty-1){System.out.println("No faculty matched! ");
                                   break;
                                  }
        

        
      }

        
       
       for(int i=0;i<=numPpl;i++){
         String holder = person[i].getID();
         if(fac_input.equals(holder)==true&&(fac_and_pers==true)){
           person[i].print();
        
           break;
           
         }
         else if(i==numPpl-1){
           
           break;
         }
          
         
         
           
      
       }
       
      }
        else if(respon.equals("5")==true){//same as 1 and 2 but for staff

          

      System.out.print("\nName of the staff member: ");
     String staff_name = sc.nextLine();
          String staff_id = " ";
     

     

          boolean isIDcorrect=false;
        boolean isIDdup=false;
          while(isIDcorrect==false){
            System.out.print("\nEnter the ID: ");
     
            staff_id=sc.next();
            
          isIDcorrect=isIdValid(staff_id);
            for(int i=0;i<numPpl;i++){
            if(staff_id.equals(person[i].getID())){
              isIDcorrect=false;
              isIDdup=true;
            }
              }
            if(isIDcorrect==false&&isIDdup==false){
              System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
            }
            if(isIDcorrect==false&&isIDdup==true){
              System.out.println("ID is duplicate ");
            }
            
          }
          sc.nextLine();

          


          System.out.print("\nDepartment: ");
    String staff_dep = sc.nextLine();
    staff_dep=staff_dep.toLowerCase();
    while(staff_dep.equals("engineering")==false&&(staff_dep.equals("mathematics"))==false&&(staff_dep.equals("sciences"))==false){
            System.out.println("\""+staff_dep+"\""+" is invalid");
      System.out.print("Department: ");
      staff_dep = sc.nextLine();
      staff_dep=staff_dep.toLowerCase();
    }

    staff_dep.toUpperCase();

    staff_dep=capitalizeFirstLetter(staff_dep);
    

          
      
      
    

     

          

    

    staff_dep=capitalizeFirstLetter(staff_dep);

          System.out.print("\nStatus, Enter P for Part Time, or Enter F for Full Time:  ");
          boolean correct_input=false;
          String status_holder = sc.nextLine();
          String status =" ";
          while(correct_input==false){
          
          
          
          // status=status_holder;

          status_holder = status_holder.toLowerCase();

          if(status_holder.equals("f")==true){
            status="Full time";
            correct_input=true;
          }
          else if(status_holder.equals("p")==true){
            status ="Part Time";
            correct_input=true;
          }
          else{
            System.out.print("\""+ status_holder+"\" is invalid input again: ");
            status_holder=sc.next();
          }

          }

          

    Staff staff_info = new Staff(staff_name, staff_id, staff_dep, status);
     

     staff[numStaff]=staff_info;
     person[numPpl]=staff_info;
     numStaff++;
     numPpl++;
      System.out.println("Staff added!");
      
        }
          else if(respon.equals("6")==true){//same as 3 and 4 but staff
          
        boolean staff_and_pers=false;

       System.out.print("\nEnter the Staff’s id: ");
       
       String staff_input=sc.nextLine();
  
        for(int i=0;i<=numStaff;i++){
        String staff_holder = staff[i].getID();
         if(staff[i].getID().equals(null)){
           staff_holder= "  ";
          
         }
        if(staff_input.equals(staff_holder)==true){
          staff_and_pers=true;
          break;
        }
          else if(i==numStaff-1){
            System.out.println("No staff matched! ");
              break;
          }
        

        
      }

        
       
       for(int i=0;i<=numPpl;i++){
         String holder = person[i].getID();
         if(staff_input.equals(holder)==true&&(staff_and_pers==true)){
           person[i].print();
        
           break;
           
         }
         else if(i==numPpl-1){
           
           break;
         }
          }
          
          }
           else if(respon.equals("7")==true){
             boolean print=false;
             System.out.print("Would you like to create the report? (Y/N):");

             String report_respon = sc.next();

             
             while(true){
              report_respon=report_respon.toLowerCase();
             if(report_respon.equals("y")){
              
                 
               System.out.println("Report created and saved on your hard drive! ");
             
               
               


               String outputFileName = "report.txt";

    try{
       PrintWriter writer = new PrintWriter(outputFileName);

      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
      LocalDate localDate = LocalDate.now();
      

      writer.write("Report created on "+dtf.format(localDate)+"\n");
      writer.write("*********************** \n");

      

      writer.write("Faculty Members\n------------------------- ");
      

        

        if(numFaculty==0){
          
        }
        else{
          for(int g=0;g<numFaculty;g++){
        writer.write("\n"+(g+1)+". "+faculty[g].toString()+"\n");
      
      }
        }

      writer.write("\n\nStaff Members\n--------------------- ");
      
        if(numStaff==0){
         
        }else{
          for(int l=0;l<numStaff;l++){
        writer.write("\n"+(l+1)+". "+staff[l].toString()+"\n");
                     }
      
      }

      writer.write("\n\nStudents\n--------------- ");
      
        if(numStuds==0){
         
        }else{
          for(int k=0;k<numStuds;k++){
        writer.write("\n"+(k+1)+". "+students[k].toString()+"\n");
                     }
      
      }

      

        

        writer.close();

      


      } catch(FileNotFoundException e){
      System.out.println("An error occured.");
        e.printStackTrace();
    }
               




               
               break;
             }

             else if(report_respon.equals("n")){
               break;
             }
             else{
               System.out.println("Invalid input");
               System.out.print("Would you like to create the report? (Y/N):");
               report_respon=sc.next();
               
               
             }
             }

             
             
       System.out.println("Goodbye!");

             
       answ=true;//done searching             
            }
             else if(numPpl==4999){//got to max people
               System.out.println("MAX PEOPLE");
               answ=true;
             }
             else{System.out.println("Invalid entry- please try again ");//entry was none above
          
       
     }

     
       
     

   

     

     

   }
   
   
   




 } 
  
 
  }

  
