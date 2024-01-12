#include <STDIO.H>
#include <CONIO.H>
// day so Factorial
int main()
{
	int fac = 1, n, i;
	printf("Enter number factorial : ");
	scanf("%d", &n);
	for(i = 1; i <= n; i++){
		fac = fac * i;
	}
	printf("\nFactorial of %d = %d", n, fac);
	getch();
	return 0;
}


