package main;

import main.StudentList;
import java.util.Scanner;

public class Student {
	private String name;
	private String Id;
	private int birthDay;
	private float average;
	Scanner sc = new Scanner(System.in);
	StudentList stdList = new StudentList();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String id, int birthDay, float average) {
		this.name = name;
		Id = id;
		this.birthDay = birthDay;
		this.average = average;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "Student [name=" + this.name + ", Id=" + this.Id + ", birthDay=" + this.birthDay + ", average=" + this.average + "]";
	}
	
	//ham nhap thong tin 1 sv
	public void Enter1Student(Scanner sc) {
		System.out.print("Enter name : ");
		name = sc.nextLine();
		System.out.print("Enter id : ");
		Id = sc.nextLine();
		System.out.print("Enter birthday : ");
		birthDay = Integer.parseInt(sc.nextLine());
		System.out.print("Enter average : ");
		average = Float.parseFloat(sc.nextLine());
		Student std = new Student();
		stdList.addStudent(std);
	}
	
	//ham xuat thong tin 1 sv
	public void display1Student() {
		System.out.println(	"Student [name=" + this.name + ", Id=" + this.Id + ", birthDay=" + this.birthDay + ", average=" + this.average + "]");
	}
	
}
