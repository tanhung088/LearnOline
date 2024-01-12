#include<stdio.h>

int main(){
    int a , b;
    printf("Nhap vao so nguyen a = ");
    scanf("%d", &a);
    printf("\nNhap vao so nguyen b =");
    scanf("%d", &b);
    if(a>b){
        printf("\nSo nguyen lon nhat la a");
    }
    else{
        printf("\nSo nguyen lon nhat la b");
    }
    //cach khac
	int MAX;
	MAX = a;
	if(MAX < b){
		MAX = b;
	}
	printf("\n%d", MAX);
		

    return 0;
}
