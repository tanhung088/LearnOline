#include<stdio.h>

int main(){
	int a = 100, b = 200;
	int c, d;
	c = a/b;
	printf("gia tri cua bien c = %d", c);
	c = ++a;
	printf("\ngia tri cua bien c2 = %d", c);
	a = 100;
	d = a++;
	printf("\ngia tri cua bien d = %d", d);
	c = !a;
	printf("\ngia tri cua bien phu dinh cua a = %d", c);	
	return 0;
}
