import java.util.Scanner;

public class ConditionOperatorDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a: ");
		int a = sc.nextInt();
		
		
		String ketqua = (a%2==0)? "So chan": "So le";
		System.out.println("a la so "+ ketqua);
	}
}
