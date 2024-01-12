import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// tao 3 toa do bang ham dung co tham so trong class coordinate
		Coordinate coor1 = new Coordinate(5,8);
		Coordinate coor2 = new Coordinate(6,8);
		Coordinate coor3 = new Coordinate(7,8);
		
		//Shape s = new Shape(); khong the tao doi tuong tu abstract class
		Shape h1 = new Circle(coor1, 5);
		Shape h2 = new rectangle(coor2, 10, 5);
		
		System.out.println("Area of circle : " + h1.Area());
		System.out.println("Area of rectangle: " + h2.Area());
	}
}
