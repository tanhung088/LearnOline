#include <STDIO.H>
#include <CONIO.H>
// day so 1, 2, 6, 24....
// moi so cach nhau la tich cua i, i se tang tu 2 va sau do ++
int main()
{
	int i, tong = 1, n;
	printf("\nNhap so can in ra day so : ");
	scanf("%d", &n);
	printf("%d\t", tong);
	for(i = 2; i < n; i++){
		tong = tong * i;
		printf("%d\t", tong);
	}
	getch();
	return 0;
}


