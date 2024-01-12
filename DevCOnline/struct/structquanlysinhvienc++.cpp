#include <STDIO.H>
#include <CONIO.H>
#include<TIME.H>
//struc quan ly sinh vien

struct date {
	int ngay;
	int thang;
	int nam;
};

struct sinhvien{
	int id;
	char ten[50];
	char gioitinh[10];
	struct date ngaysinh;
	int tuoi;
	float diemmon1;
	float diemmon2;
	float diemmon3;
	float dtb;
	char hocluc[10];
	char tenlop[20];
};
typedef sinhvien SV;
void nhapthongtinsinhvien(SV &sv){
	_flushall();
	printf("\nEnter full name : ");			scanf("%s", sv.ten);
	printf("\nEnter subject score 1 : ");	scanf("%f", &sv.diemmon1);
	printf("\nEnter subject score 2 : ");	scanf("%f", &sv.diemmon2);
	printf("\nEnter subject score 3 : ");	scanf("%f", &sv.diemmon3);	
}
void inthongtinsinhvien(SV sv){
	printf("\nName : %s", sv.ten);
	printf("\nSunject score 1: %.2f", sv.diemmon1);
	printf("\nSubject score 2 : %.2f", sv.diemmon2);
	printf("\nSubject score 3 : %.2f", sv.diemmon3);
}
void nhapdanhsachsinhvien(SV ds[], int &n){
	do{
		printf("\nEnter student numbers : ");
		scanf("%d", &n);
	}while(n < 0);	
	for(int i = 0; i < n; i++){
		printf("\nInformation of student %d", i + 1);
		nhapthongtinsinhvien(ds[i]);
	}
}

void xuatdanhsachsinhvien(SV ds[], int n){
	int i;
	for(i = 0; i < n; i++){
		printf("\nInformation of student %d is", i + 1);
		inthongtinsinhvien(ds[i]);
	}
}

float tinhDTB(SV sv){
	float DTB = (sv.diemmon1 + sv.diemmon2 + sv.diemmon3)/3;
	return DTB;
}

void tinhDTBdanhsach(SV ds[], int n){
	int i;
	for(i = 0; i < n; i++){
	printf("\nAverage of student %d = %.2f", i + 1, tinhDTB(ds[i]));		
	}
}

void timMax_DTB(SV ds[], int n){
	int i;
	float max = tinhDTB(ds[0]);
	for(i = 1; i < n; i++){
		if(max < tinhDTB(ds[i])){
			max = tinhDTB(ds[i]);
		}
	}
	printf("\nThis information student have average max : ");
	for(i = 0; i < n; i++){
		if(tinhDTB(ds[i]) == max){
			inthongtinsinhvien(ds[i]);
		}
	}
}

void sapxeptheoDTB(SV ds[], int n){
	int i, j;
	SV tmp;
	printf("\n\n\nAfter sort depend average :");
	for(i = 0; i < n-1; i++){
		for(j = i + 1; j < n; j++){
			if(tinhDTB(ds[i]) > tinhDTB(ds[j])){
				tmp = ds[j];
				ds[j] = ds[i];
				ds[i] = tmp;
			}
		}
	}
	
	for(i = 0; i < n; i++){
		printf("\nInformation of student %d", i + 1);
		inthongtinsinhvien(ds[i]);
	}
}



int main()
{
	SV sv1;
	SV ds[100];
	int n;
	//nhapthongtinsinhvien(sv1); 
	//inthongtinsinhvien(sv1);
	nhapdanhsachsinhvien(ds,n);
	xuatdanhsachsinhvien(ds,n);
	tinhDTBdanhsach(ds,n);
	timMax_DTB(ds,n);
	sapxeptheoDTB(ds,n);
	getch();
	return 0;
}


