import java.util.Scanner;

import javax.swing.event.ListDataEvent;

@SuppressWarnings("unused")
public class StudentList {
	Student student[];
	int max;
	int next;
	// tao doi tuong s cua object Student
	static Student std = new Student();
	Scanner sc = new Scanner(System.in);
	
	
	public StudentList() {
		System.out.println("Enter maximum size of the Student Array : ");
		max = Integer.parseInt(sc.nextLine());
		// cap phat vung nho cho mang
		student = new Student[max];
	}
	
	// ham add student
	public void addStudent() {
		// kiem tra mang con cho trong ko
		/*
		if(next == max) {
			System.out.println("Array Full");
            return;	
		}
		*/
		
		for(int i = 0; i < max; i++) {
			std.input();
			student[i] = std.input();
			//student[i].avgMark();
			next++;
		}
		for(int i = 0; i < max; i++) {
			student[i].display();
		}
        //std.input();
        //đưa vào mảng
        //student[next] = std;
        //student[next].avgMark();
        //next++;
	}
	
	// ham xuat ra tat ca thong tin cua sinh vien co trong dnah sach
	/*
	public void outAll() {
		if(next == 0) {
			System.out.println("No data");
			return;
		}
		System.out.println("----------List of Student--------------");
		// dung vong lap de xet tung phan tu trong mang student[]
		for(int i = 0; i < max; i++) {
			student[i].display();
		}
	}
	*/
	//ham in ra student pass
	public void displayPassExam() {
		if(next == 0) {
			System.out.println("Array is empty");
			return;
		}
		System.out.println("-------List student pass exam--------------");
		for(int i = 0; i< next; i++) {
			if(student[i].getPraticalMark() >= 40 && student[i].getTheoryMark() >= 40) {
				student[i].display();
			}
		}
	}
	
	//ham find top 1
	public void FindTop1() {
		if(next == 0) {
			System.out.println("Array is empty");
			return;
		}
		int maxx = 0;
		for(int i = 0; i< next; i++) {
			if(student[i].getProjectMark() >= 40 && student[maxx].getProjectMark() >= 40) {
				maxx = i;
			}
		}
		System.out.println("-------Student have the highest average mark");
		student[maxx].display();
	}
}
