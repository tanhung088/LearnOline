import java.util.Scanner;

public class OperatorDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		System.out.println("Enter a : ");
		a = sc.nextInt();
		System.out.println("Enter b : ");
		b = sc.nextInt();
		System.out.println("a = " + a);
		System.out.println("++a = " + ++a);//thuc hien a+1 roi sau do xuat ra ct
		System.out.println("a++ = " + a++);// xuat ra a = 6 truoc khi a+1
		System.out.println("a = " + a);
		
		// Phep toan so sanh
		System.out.println("Ca 2 so deu la so chan " + (a%2==0 && b%2==0));
		System.out.println("Ca 2 so deu la so le " + (a%2!=0 && b%2!=0));
	}
}
