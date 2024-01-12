import java.util.Scanner;

public class KiemTraNgayCuaThang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter month to check: ");
		int n = sc.nextInt();
		System.out.println("Enter year to check: ");
		int y = sc.nextInt();
		switch (n) {
			case 1:
				System.out.println("January has 31 days");
				break;
			case 3:
				System.out.println("March has 31 days");
				break;
			case 5:
				System.out.println("May has 31 days");
				break;
			case 7:
				System.out.println("July has 31 days");
				break;
			case 8:
				System.out.println("August has 31 days");
				break;
			case 10:
				System.out.println("October has 31 days");
				break;
			case 12:
				System.out.println("December has 31 days");
				break;
			case 4:
				System.out.println("April has 30 days");
				break;
			case 6:
				System.out.println("Junw has 30 days");
				break;
			case 9:
				System.out.println("September has 30 days");
				break;
			case 11:
				System.out.println("November has 30 days");
				break;
			case 2:
				if((y%4==0 && y%100==0) || (y%400==0)) {
					System.out.println("February has 29 days");
				}else {
					System.out.println("February has 28 days");
				}
			default:
				System.out.println("Enter Wrong!!!");
		}
	}
}
