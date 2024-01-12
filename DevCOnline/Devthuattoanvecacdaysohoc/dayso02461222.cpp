#include <STDIO.H>
#include <CONIO.H>
//day so 0, 2, 4, 6, 12, 22,.....
// 3 so dau cong lai thanh so thu 4
int main()
{
	int dem, i=0, j=2, z=4, tong=0, n;
	printf("\nNhap so can cho ra day so : ");
	scanf("%d", &n);
	printf("%d\t%d\t%d", i, j, z);
	for(dem = 3; dem < n; dem++){
		tong = i + j + z;
		printf("\t%d", tong);
		i = j;
		j = z;
		z = tong;
	}
	getch();
	return 0;
}


