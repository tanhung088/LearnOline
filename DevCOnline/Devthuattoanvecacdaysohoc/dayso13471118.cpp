#include <STDIO.H>
#include <CONIO.H>
//Viet tiep 3 so hang vao day so sau day
//1 , 3, 4, 7, 11, 18....
int main()
{
	int i = 1 , j = 3, tmp = 0;
	int dem;
	int tong = 0;
	printf("%d\t", i);
	printf("%d\t", j);
	for(dem = 1; dem < 10; dem++){
		tong = i + j;
		printf("%d\t", tong);
		i = j;
		j = tong;
	}
	
	getch();
	return 0;
}


