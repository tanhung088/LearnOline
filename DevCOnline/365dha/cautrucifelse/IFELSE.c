#include<stdio.h>

int main(){
	int a = 1, b = 2;
	int c;
	c = b - a;
	char d;
	if(a == b){
		d = 'T';
		printf("%c", d);
	}
	else{
		d = 'F';
		printf("\n%c", d);
	}
	return 0;
}
