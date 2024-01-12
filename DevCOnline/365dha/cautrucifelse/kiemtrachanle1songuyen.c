#include<stdio.h>

int main(){
	int a;
	printf("Nhap vao 1 so nguyen =");
	scanf("%d", &a);
	if((a % 2) == 0){
		printf("\nLa so chan");
	}else{
		printf("\nLa so le");
	}
	return 0;
}
