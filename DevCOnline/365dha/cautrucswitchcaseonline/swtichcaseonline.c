#include <STDIO.H>
#include <CONIO.H>
#include<STDLIB.H>

int main()
{
	printf("************************************");
	printf("\n=========C PROGRAMG LANGUEG=======");
	printf("\n 1. Tinh Tong hai so nguyen");
	printf("\n 2. Tinh hieu hai so nguyen");
	printf("\n 3. Tinh tich hai so nguyen");
	printf("\n 4. Chia hai so nguyen lay du");
	printf("\n 5. Chia hai so nguyen lay phan nguyen");
	printf("\n 6. Thoat");
	do{
	int a, b,luachon;
	printf("\n Nhap so nguyen dau tien :");
	scanf("%d", &a);
	printf("\n Nhap so nguyen thu hai :");
	scanf("%d", &b);
	printf("\n Ban muon thuc hien phep tinh nao? : ");
	scanf("%d", &luachon);
	switch(luachon){
		case 1 :
			printf("\nTong hai so nguyen = %d", a+b);
			break;
		case 2 :
			printf("\n Hieu hai so nguyen = %d", a-b);
			break;
		case 3 :
			printf("\n Tich hai so nguyen = %d", a*b);
			break;
		case 4 :
			printf("\n Thuong hai so nguyen lay du = %d", a%b);
			break;
		case 5 :
			printf("\n Thuong hai so nguyen lay nguyen = %d", a/b);
			break;
		case 6 :
			exit(0);
			break;
		default :
			printf("\nLua chon khong phu hop!!!");
			break;
		}
	}while( luachon != 0);
	getch();
	return 0;
}


