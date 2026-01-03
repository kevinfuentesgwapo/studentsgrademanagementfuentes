
package studentgrademanagementsystem;

/**
 *
 * @author paulv
 */
import java.util.*;
public class StudentGradeManagementSystem {
    
    public static Scanner sc = new Scanner(System.in);
    
    //each student data is stored in this array
    // 0 = ID, 1 = NAME, 2 = G1, 3= G2, 4= G3, 5 = AVERAGE, 6 = REMARK
    public static ArrayList<String[]> students = new ArrayList <>();
  
    
    public static void main(String[] args) {
        
        int choice;
        do {
             theMenu();
            choice = readInt("Enter Choice: ");
            
            switch (choice){
                case 1: 
                    addStudent();
                    break;
                case 2: 
                    viewStudent();
                    break;
                case 3: 
                    System.out.println("Exiting the program.....");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }while (choice != 3);
    }
    
    // the menu display
    public static void theMenu(){
        System.out.println("\n STUDENT GRADE MANAGEMENT SYSTEM\n");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Exit");
} 
    
    //add student system
    public static void addStudent(){
            
        String[] student = new String[7];
        
        // adding the subject names para dali ra ma ilhan
        String[] subjects = {"COMPROG2","ELEC1","IT121"};
            
        System.out.print("Enter ID number: ");
        student[0] = sc.nextLine();
        
        System.out.print("Enter Name: ");
        student[1] = sc.nextLine();
        
        double total = 0.0;
        
        //LOOP through projects
        for (int i = 0; i < subjects.length; i++){
            double grade = readGrade("Enter Grade: "+ subjects[i] + ":");
            student[i + 2] = String.valueOf(grade);
            total += grade;
        }
        double average = total / subjects.length;
        student[5] = String.format("%.2f", average);
        student[6] = getRemark(average);
        
        students.add(student);
        
        System.out.println("Student added successfully.");
      }
    
         //view all student
    public static void viewStudent(){
           
         if(students.isEmpty()){
             System.out.println("\n No Students Recorded.\n");
             return;
         }
         
            System.out.println("\n-----------------------------------------------------");
            System.out.printf("%-8s %-18s %-11s %-10s%n",
                    "ID", "NAME", "AVERAGE", "REMARK");
            System.out.println("-----------------------------------------------------");
            
            for(String[] s : students){
                System.out.printf("%-8s %-18s %-11s %-10s%n",
                        s[0], s[1], s[5], s[6]);
            }
            System.out.println("-----------------------------------------------------");      
   }
        
        // input validation 
    public static double readGrade(String message){
        
        while (true){
            System.out.print(message);
            try{
                double grade = Double.parseDouble(sc.nextLine());
                if (grade >= 0 && grade <= 100 ) {
                    return grade;
                }
                System.out.println("Grade must between 0 and 100.");
            } catch (Exception e){
                System.out.println("Invalid Input. Numbers Only.");
            }
        }
    }
    
    public static int readInt(String message){
        while (true){
            System.out.print(message);
            try{
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e){
                System.out.println("Invalid input. Enter a number.");
        }
    }
}
    
    public static String getRemark(double avg){
        if (avg >= 90)return "Excellent";
        if (avg >= 80)return "Very Good";
        if (avg >= 70)return "Good";
        if (avg >= 60)return "Needs Improvement";
        return "Fail";
    }
}
    
