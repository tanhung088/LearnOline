package dell;

import java.util.Scanner;

import general.Computer;

public class DellComputer extends Computer{
	public float weight;
	
	public DellComputer() {
		super();
		Scanner sc = new Scanner(System.in);
			System.out.print("Enter manufaturer: ");
			manufacturer = sc.nextLine();
			System.out.print("Enter price: ");
			price = Integer.parseInt(sc.nextLine());
			System.out.print("Enter weight : ");
			weight = Float.parseFloat(sc.nextLine());
	}
	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	/*
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter manufaturer: ");
			manufacturer = sc.nextLine();
			System.out.print("Enter price: ");
			price = Integer.parseInt(sc.nextLine());
			System.out.print("Enter weight : ");
			while(true) {
				weight = Float.parseFloat(sc.nextLine());
				if(weight < 0.5) {
					System.out.println("Weight must be between 0.5kg and 3.0kg!");
				}else {
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	*/
	
	@Override
	public String toString() {
		return  String.format("%s\t%d\t%s", getManufacturer(), getPrice(), weight);
	}

	@Override
	public void input() {
		// TODO Auto-generated method stub
		
	}
	
}
