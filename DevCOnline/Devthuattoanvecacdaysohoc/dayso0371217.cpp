#include <STDIO.H>
#include <CONIO.H>
//day so 0, 3, 7, 12, 18
// moi so cach nhau lan luot la i++ dau tien i = 3
int main()
{
	int i, tong = 0, n;
	printf("Nhap so luong in ra cho day so : ");
	scanf("%d", &n);
	printf("%d\t", tong);
	for(i = 3; i < n; i++){
		
		tong = tong + i;
		printf("%d\t", tong);
	}
	getch();
	return 0;
}


