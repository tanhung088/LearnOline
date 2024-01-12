
public class Student  extends Person {
	// ham con se co them cac thuoc tinh khac
	private String ClassName;
	private String SchoolName;
	//tao ham dung voi cac parameter cua ham cha  va ham con
	public Student() {
	}
	public Student(String name, String gender, int age, String className, String schoolName) {
		super(name, gender, age);
		ClassName = className;
		SchoolName = schoolName;
	}
	
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getSchoolName() {
		return SchoolName;
	}
	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
	// tao cac ham cua rieng ham con
	public void DoHomwork() {
		System.out.print("Doing homework...");
	}
	public void Exam() {
		System.out.print("Doing exam...");
	}
	
}
