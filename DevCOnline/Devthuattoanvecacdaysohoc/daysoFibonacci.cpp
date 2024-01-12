#include <STDIO.H>
#include <CONIO.H>
//day so Fibonacci
int main()
{
	int i, n, fib = 0;
	printf("Enter number of Fibonacci : ");
	scanf("%d", &n);
	int a = 0, b = 1;
	printf("\n%d\t%d", a, b);
	for(i = 2; i < n; i++){
		fib = a + b;
		printf("\t%d", fib);
		a = b;
		b = fib;
	}
	getch();
	return 0;
}


