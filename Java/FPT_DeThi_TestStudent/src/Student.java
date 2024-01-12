import java.util.Scanner;

public class Student {
	private String Id, Name;
	private float PraticalMark, TheoryMark, ProjectMark;
	Scanner sc = new Scanner(System.in);
	
	public  Student() {
	}
	public String getId() {
		return Id;
	}
	public float getPraticalMark() {
		return PraticalMark;
	}
	public String getName() {
		return Name;
	}
	public float getProjectMark() {
		return ProjectMark;
	}
	public float getTheoryMark() {
		return TheoryMark;
	}
	public void setId(String id) {
		Id = id;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setPraticalMark(float praticalMark) {
		PraticalMark = praticalMark;
	}
	public void setProjectMark(float projectMark) {
		ProjectMark = projectMark;
	}
	public void setTheoryMark(float theoryMark) {
		TheoryMark = theoryMark;
	}
	
	//hàm input
    public Student input()
    {
        System.out.print("ID: ");
        this.Id = sc.nextLine();
        System.out.print("Name: ");
        this.Name = sc.nextLine();
        System.out.print("Practical: ");
        this.PraticalMark = Float.parseFloat(sc.nextLine());
        System.out.print("Theory: ");
        this.TheoryMark = Float.parseFloat(sc.nextLine());
        System.out.print("Project: ");
        this.ProjectMark = Float.parseFloat(sc.nextLine());
		return null;
    }
    
    //ham tinh diem trung binh
    public float avgMark()
    {
        return (this.PraticalMark*0.4f+ this.TheoryMark*0.6f);
    }
    
    //ham xuat thong tin
    public void display()
    {
        System.out.println("\n--------------------------------");
        System.out.println("|Id: " + this.Id);
        System.out.println("|Name: " + this.Name);
        System.out.println("|Practical: " + this.PraticalMark);
        System.out.println("|Theory: " + this.TheoryMark);
        System.out.printf("|AvgMark: %.2f" , avgMark()); 
    }
    
}



