import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		// Khai bao Class Scanner cua java de nhao du lieu tu ban phim
		Scanner sc = new Scanner(System.in);
		// Khai bao bien 
		String Name;
		String Gender;
		int Age;
		// Nhap tu ban phim vao cac thong tin theo yeu cau VD: ten bien = sc.nextInt(); Nếu biến là int
		System.out.println("Enter Name : ");
		Name = sc.nextLine();
		System.out.println("Enter Gender : ");
		Gender = sc.nextLine();
		System.out.println("Enter Age : ");
		Age = Integer.parseInt(sc.nextLine());
		// Xuat ra các thông tin đã nhập
		System.out.println("Information of student");
		System.out.println("Name : " + Name);
		System.out.println("Gender : " + Gender);
		System.out.println("Age : " + Age);
	}
}
