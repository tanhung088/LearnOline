package test;

import java.util.Scanner;

import main.Student;
import main.StudentList;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentList stdList = new StudentList();
		Student std = new Student();
		int choice;
        do {
            System.out.println("\n1.Add student\n2.Display student\n3.Display tax\n4.Exit");
            System.out.println("Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                	std.Enter1Student(sc);
                    break;
                case 2:
                	stdList.displayStudentList();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Bye Bye!!!");
                    break;
                default:
                    System.out.println("Wrong choice!!!");
                    break;
            }
        } while (choice != 4);
    }
}
