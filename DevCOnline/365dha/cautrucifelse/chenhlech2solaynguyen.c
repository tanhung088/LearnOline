#include<stdio.h>

int main(){
	int a, b, c;
	printf("Nhap so nguyen a = ");
	scanf("%d", &a);
	printf("\nNhap so nguyen b = ");
	scanf("%d", &b);
	int MAX;
	MAX = a;
	if(MAX < b){
		MAX = b - MAX;
	}
	else{
		MAX = MAX - b;
	}
	printf("\n%d", MAX);
	return 0;
}
