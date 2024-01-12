package general;

import java.util.Scanner;

import dell.DellComputer;

public  class TestComputer {
	int maxComputer;
	int nextComputer;
	DellComputer [] cpt;
	Scanner sc = new Scanner(System.in);
	
	public TestComputer() {
		System.out.print("Enter max account : ");
		maxComputer = Integer.parseInt(sc.nextLine());
		cpt = new DellComputer[maxComputer];
	}
	
	//ham add comp
		public void addComputer() {
			if(nextComputer == maxComputer) {
				System.out.print("Cannot add computer!!!");
			}else {
				DellComputer cpts = new DellComputer();
				
				cpt[nextComputer] = cpts;
				nextComputer++;
			}
		}
	
		//ham print thin copm
		public void displayThin() {
			Scanner sc = new Scanner(System.in);
				for(int i = 0; i < cpt.length; i++) {
					if(cpt[i].getWeight() < 1.5) {
						System.out.print("Maunufurer : " + cpt[i].manufacturer + "\t");
						System.out.print("Price : " + cpt[i].price + "\t");
						System.out.print("Weight : " + cpt[i].weight + "\t");
						System.out.println("\n");
					}
				}
		}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestComputer t = new TestComputer();
			int Choice;
			do {
				//Menu
				System.out.println("\n1.Add computer");
				System.out.println("2.Display Thin Computer");
				System.out.println("3.Exit"); 
				
				//Nhap Choice
				System.out.print("Enter your choice :");
				Choice = Integer.parseInt(sc.nextLine());
				switch(Choice){
			    case 1:
			        t.addComputer();
			        break;
			    case 2:
			    	System.out.println("Computer thin is :");
			       t.displayThin();
			        break;
			    case 3:
			    	System.out.println("Bye Bye!!!");
			        break;
			    default:
			        System.out.print("Wrong choice.Try again!");   
			        break;
			}
			} while (Choice != 3);
	}
}
