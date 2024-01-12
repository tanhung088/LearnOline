import java.util.Scanner;

public class ClassAndFunctionOfMathDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b;
		System.out.println("Enter a: ");
		a = sc.nextDouble();
		System.out.println("Enter b : ");
		b = sc.nextDouble();
		
		//Math la 1 class viet duoi dang static nen khi dung ko can import ma chi can goi ten Math.
		
		// Lay ham tri tuyet doi Math.abs();
		System.out.println("|a| = " + Math.abs(a));
		
		//ham tim min cua 2 so
		System.out.println("min(a,b) = " + Math.min(a, b));
		
		//ham lam tron len ceil va lam tron xuong floor
		System.out.println("ceil(a) = " + Math.ceil(a));
		System.out.println("floor(a) = " + Math.floor(a));
		
		//ham can bac 2 sqrt(a);
		System.out.println("sqrt(a) = " + Math.sqrt(a));
		
		/*
		 * Luu y: trong java thi so Pi va E(logarit) cung duoc viet duoi dang static
		 * nen khi dung chi can goi Math.PI hoac Math.E
		 * */
	}
}
