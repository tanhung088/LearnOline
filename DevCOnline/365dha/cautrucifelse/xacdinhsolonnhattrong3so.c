#include<stdio.h>

int main(){
	int a, b, c;
	printf("Nhap so nguyen a = ");
	scanf("%d", &a);
	printf("\nNhap so nguyen b = ");
	scanf("%d", &b);
	printf("\nNhap so nguyen c = ");
	scanf("%d", &c);
	int MAX;
	MAX = a;
	if(MAX < b){
		MAX = b;
	}
		if(MAX < c)
		MAX = c;
	printf("\n%d", MAX);
	return 0;
}
