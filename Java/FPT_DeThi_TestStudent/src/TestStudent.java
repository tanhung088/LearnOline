import java.util.Scanner;

public class TestStudent {
	public static void main(String[] args) {
		Scanner scc = new Scanner(System.in);
		StudentList stdList = new StudentList();
		int Choice;
		do {
			//Menu
			System.out.println("\n1.Add");
			System.out.println("2.Find All");
			System.out.println("3.STudent Pass");
			System.out.println("4. Find top 1");
			System.out.println("5.Exit"); 
			
			//Nhap Choice
			System.out.println("Enter your choice");
			Choice = Integer.parseInt(scc.nextLine());
			switch(Choice){
            case 1:
                stdList.addStudent();
                break;
            case 2:
               //stdList.outAll();
                break;
            case 3:
            	stdList.FindTop1();
                break;
            case 4:
                break;
                default:
                    System.out.print("Wrong choice.TRy again!");   
                    break;
        }
		} while (Choice != 5);
	}
}
