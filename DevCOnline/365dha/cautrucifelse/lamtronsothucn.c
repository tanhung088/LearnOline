#include<stdio.h>
#include<math.h>

int main(){
	float a, ketqua;
	printf("Nhap vao mot so thuc a =");
	scanf("%f", &a);
	ketqua = round(a);
	printf("\nKet qua sau khi lam tron = %0.2f", ketqua);
	return 0;
}
