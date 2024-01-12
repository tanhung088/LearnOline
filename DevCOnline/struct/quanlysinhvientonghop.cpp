#include <STDIO.H>
#include <CONIO.H>
#include <STDLIB.H>
#include <STRING.H>
#include <MATH.H>
//Quan ly sinh vien
struct students{
	int id;
	char name[25];
	int age;
	char sex[10];
	char classname[20];
	float marks1;
	float marks2;
};

int main()
{
	int n, i, j;
	do{
		printf("\nHow many student would you want manager : ");
		scanf("%d", &n);
		if(n <= 0 || n > 10){
			printf("\nPlease enter again!!!");
		}
	}while(n <= 0 || n > 10);

	_flushall();
	
	struct students std[n];
	for(i = 0; i < n; i++){
		printf("\nEnter information of student %d : ", i + 1);
		printf("\n_Enter ID : ");
		scanf("%d", &std[i].id);
		_flushall();
		printf("\n_Enter name : ");
		gets(std[i].name);
		printf("\n_Enter marks 1 : ");
		scanf("%f", &std[i].marks1);
		printf("\n_Enter marks 2 : ");
		scanf("%f", &std[i].marks2);
	}
	//Tinh diem trung binh cua sinh vien
	for(i = 0; i < n; i++){
		printf("\nAverage score of student %d = %.2f", i + 1, (std[i].marks1 + std[i].marks2)/2);
	}	
	
	//sap xep theo diem trung binh tu nho den thap
	
	struct students tmp;
	
	for(i = 0; i < n - 1; i ++){
		for(j = i + 1; j < n; j++){
			if(((std[i].marks1 + std[i].marks2)/2) > (std[j].marks1 + std[j].marks2)/2){
				tmp = std[j];
				std[j] = std[i];
				std[i] = tmp;
			}
		}
	} 
	
	printf("\n---------------------------------------");
	printf("\nAfter sort depend on average :");
	for(i = 0; i < n; i ++){
		printf("\nID : %d\tName : %s\tAvergage : %f",std[i].id, std[i].name, (std[i].marks1 + std[i].marks2)/2);
	}

	// sap xep theo thu tu ID
	int tmp2;
	for(i = 0; i < n - 1; i ++){
		for(j = i + 1; j < n; j++){
			if(std[i].id >std[j].id){
				tmp = std[j];
				std[j] = std[i];
				std[i] = tmp;
			}
		}
	} 
	
	printf("\n---------------------------------------");
	printf("\nAfter sort depend on ID :");
	for(i = 0; i < n; i ++){
		printf("\nID : %d\tName : %s\tAvergage : %f",std[i].id, std[i].name, (std[i].marks1 + std[i].marks2)/2);
	}
	
	//sap xep theo ten alphabet
	for(i = 0; i < n - 1; i ++){
		for(j = i + 1; j < n; j++){
			if(strcmp(std[i].name, std[j].name) > 0){
				tmp = std[j];
				std[j] = std[i];
				std[i] = tmp;
			}
		}
	} 	
	printf("\n---------------------------------------");
	printf("\nAfter sort depend on NAME :");
	for(i = 0; i < n; i ++){
		printf("\nID : %d\tName : %s\tAvergage : %f",std[i].id, std[i].name, (std[i].marks1 + std[i].marks2)/2);
	}

	//tim sinh vien dua tren ten cua sinh vien do
	_flushall();
	char timkiem[10];
	int check = 0;
	printf("\nEnter name of student : ");
	scanf("%s", timkiem);
	for(i = 0; i < n; i++){
		if(strcmp(std[i].name, timkiem) == 0){
			printf("\nYou find this student :");
			printf("\nID : %d\tName : %s\tAvergage : %f",std[i].id, std[i].name, (std[i].marks1 + std[i].marks2)/2);
			check++;
		}
		
		if(check == 0){
			printf("\nThe student is not exist!!!");
		}
	}	

	// xoa sinh vien theo ten
	
	printf("\nEnter name of student need delete : ");
	for(i = 0; i < n; i++){
		if(strcmp(std[i].name, timkiem) == 0){
			std[i] = std[i + 1];
			n--;
		}	
	}
	printf("\n---------------------------------------");
	printf("\nAfter delete depend on NAME :");
	printf("\nList student : ");
	for(i = 0; i < n; i++){
		printf("\nID : %d\tName : %s\tAvergage : %f",std[i].id, std[i].name, (std[i].marks1 + std[i].marks2)/2);
	}

	getch();
	return 0;
}


