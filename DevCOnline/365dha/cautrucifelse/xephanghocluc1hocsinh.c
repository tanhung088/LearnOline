#include<stdio.h>

int main(){
	int a, b, c, TB;
	printf("Nhap vao diem kiem tra = ");
	scanf("%d", &a);
	printf("\nNhap vao diem thi giua ky = ");
	scanf("%d", &b);
	printf("\nNhap vao diem thi cuoi ky = ");
	scanf("%d", &c);
	printf("\nDiem trung binh cua mot hoc sinh = %d", TB = (a+b+c)/3);
	int XH;
	XH = TB;
	if(XH >= 9){
		printf("\n Hoc sinh do xep hang A.");
	}
	else{
		if((XH >= 7 ) && (XH , 9)){
			printf("\nHoc sinh do hang B");
		}
		else{
			if((XH >= 5) && (XH < 7)){
				printf("\nHoc sinh do hang C");
			}
			else{
				if((XH >= 1) && (XH < 5)){
					printf("\nHoc sinh do hang D");
				}
				else{
					if(XH < 1){
						printf("\nHoc sinh do hang E");
					}
				}
			}
		}
	}
	return 0;
}
