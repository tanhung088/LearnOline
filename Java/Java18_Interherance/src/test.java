
public class test {
	public static void main(String[] args) {
		// tao doi tuong de goi cac ham cua class cha
		// luu y, se tu class cha se ko goi duoc cac ham cua class con
		// tu class con se goi duọc tat ca ham cung nhu tat ca thuoc tinh cua class cha
		System.out.println("---------Method from class parent--------------");
		Person ps = new Person();
		ps.eat();
		ps.sleep();
		
		System.out.println("\n--------------Method from class child-----------------");
		Student std = new Student();
		std.eat();
		std.sleep();
		std.DoHomwork();
		std.Exam();
	}
}
