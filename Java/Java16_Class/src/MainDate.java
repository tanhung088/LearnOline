
public class MainDate {
	public static void main(String[] args) {
		// tao doi tuong md va truy cap vao cac ham cua class MyDate
		MyDate md1 = new MyDate(15, 5, 2025);
		MyDate md2 = new MyDate(11, 1, 2021);
		MyDate md3 = new MyDate(15, 5, 2025);
		
		System.out.println(md1); // 15/5/2021
		System.out.println(md2);
		System.out.println(md3);
		
//		int a = 5;
//		int b = 6;
//		if(a==b) {
//			System.out.println("a = b");
//		}else {
//			System.out.println("a != b");
//		}
		
//		if(md1==md3) {
//			System.out.println("md1 == md3");
//		}else {
//			System.out.println("md1 != md3");
//		}
		System.out.println("md1 so sanh bang md2: "
		                        + md1.equals(md2));
		
		System.out.println("md1 so sanh bang md3: "
                                + md1.equals(md3));
		
		System.out.println("Hashcode md1 " + md1.hashCode());
		System.out.println("Hashcode md2 " + md2.hashCode());
		System.out.println("Hashcode md3 " + md3.hashCode());
	}
}
