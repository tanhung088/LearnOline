--Link BT: --https://bdkhtravinh.vn/bai-tap-truy-van-sql-co-loi-giai/
	--Tao database ThucTap
	USE master
	GO
	IF EXISTS (SELECT NAME FROM master..sysdatabases WHERE NAME = 'ThucTap')
	DROP DATABASE ThucTap
	GO
	CREATE DATABASE ThucTap
	GO
	USE ThucTap
	GO
	CREATE TABLE Khoa(
		MaKhoa VARCHAR(10) CONSTRAINT PK_MaKhoa PRIMARY KEY,
		TenKhoa VARCHAR(20),
		SDT VARCHAR(10)
	)
	CREATE TABLE GIangVien(
		MaGV INT NOT NULL CONSTRAINT PK_MaGV PRIMARY KEY,
		HoTenGV VARCHAR(50),
		Luong DECIMAL(5,2),
		MaKhoa VARCHAR(10) CONSTRAINT FK_GVMaKhoa FOREIGN KEY REFERENCES Khoa(Makhoa)
	)
	CREATE TABLE SinhVien(
		MaSV INT NOT NULL CONSTRAINT PK_MaSV PRIMARY KEY,
		HoTen VARCHAR(50),
		MaKhoa VARCHAR(10) CONSTRAINT FK_SVMaKhoa FOREIGN KEY REFERENCES Khoa(MaKhoa),
		NamSinh INT,
		QueQuan VARCHAR(20)
	)
	CREATE TABLE DeTai(
		MaDT VARCHAR(10) NOT NULL CONSTRAINT PK_MaDT PRIMARY KEY,
		TenDT VARCHAR(30),
		KinhPhi INT,
		NoiThucTap VARCHAR(30)
	)
	CREATE TABLE HuongDan(
		MaSV INT CONSTRAINT PK_HDMaSV PRIMARY KEY ,
		MaDT VARCHAR(10) CONSTRAINT FK_MaDT FOREIGN KEY REFERENCES DeTai(MaDT),
		MaGV INT CONSTRAINT FK_MaGV FOREIGN KEY REFERENCES GiangVien(MaGV),
		KetQua decimal(5,2)
	)
	--Them DL vao cac bang theo thu tu tu tren xuong
	INSERT INTO Khoa VALUES 
	('Geo', 'DiaLy va QLTN' , 3855413),
	('Math', 'Toan', 3855411),
	('Bio', 'SinhHoc', 3855412)
	INSERT INTO GiangVien VALUES
	(11,'Thanh Xuan',700,'Geo'),
	(12,'Thu Minh',500,'Math'),
	(13,'Chu Tuan',650,'Geo'),
	(14,'Le Thi Lan',500,'Bio'),
	(15,'Tran Xoay',900,'Math');
	INSERT INTO SinhVien VALUES
	(1,'Le Van Sao','Bio',1990,'Nghe An'),
	(2,'Nguyen Thi My','Geo',1990,'Thanh Hoa'),
	(3,'Bui Xuan Duc','Math',1992,'Ha Noi'),
	(4,'Nguyen Van Tung','Bio',null,'Ha Tinh'),
	(5,'Le Khanh Linh','Bio',1989,'Ha Nam'),
	(6,'Tran Khac Trong','Geo',1991,'Thanh Hoa'),
	(7,'Le Thi Van','Math',null,'null'),
	(8,'Hoang Van Duc','Bio',1992,'Nghe An');
	INSERT INTO DeTai VALUES
	('Dt01','GIS',100,'Nghe An'),
	('Dt02','ARC GIS',500,'Nam Dinh'),
	('Dt03','Spatial DB',100, 'Ha Tinh'),
	('Dt04','MAP',300,'Quang Binh' );
	INSERT INTO HuongDan VALUES
	(1,'Dt01',13,8),
	(2,'Dt03',14,0),
	(3,'Dt03',12,10),
	(5,'Dt04',14,7),
	(6,'Dt01',13,Null),
	(7,'Dt04',11,10),
	(8,'Dt03',15,6);
	--Cau2: Dua ra ma so, ho ten va ten khoa cua giang vien
	GO
	-- cach 1
	SELECT  GV.MaGV, GV.HoTenGV, K.TenKhoa 
	FROM GIangVien AS GV, Khoa AS K
	WHERE GV.MaKhoa = K.MaKhoa
	--cach 2 dung join
	SELECT GV.MaGV, GV.HoTenGV, K.TenKhoa
	FROM GIangVien AS GV INNER JOIN Khoa AS K 
	ON (GV.MaKhoa = K.MaKhoa)

	-- Cau3: ma so, ho ten, ten khoa cua giang vien huong dan 3 SV tro len 
	GO
	SELECT	GV.MaGV, GV.HoTenGV, K.TenKhoa
	FROM GIangVien GV INNER JOIN Khoa K
	ON	(GV.MaKhoa = K.MaKhoa)
	WHERE GV.MaGV IN (
		SELECT HD.MaGV
		FROM HuongDan HD
		GROUP BY HD.MaGV
		HAVING COUNT(HD.MaGV) >= 2
	)

	--Cau4: xuat ra thong tin sinh vien chua co diem thuc tap
	GO
	SELECT	*
	FROM	SinhVien SV INNER JOIN HuongDan HD
	ON		(SV.MaSV = HD.MaSV)
	WHERE	HD.KetQua is NULL

	--Cau5: Xuat ra SDT cua khoa ma co SInh Vien LE Van Sao  dang hoc

	--Cach1:
	GO
	SELECT	K.SDT, K.TenKhoa
	FROM	SinhVien SV JOIN Khoa K
	ON		(SV.MaKhoa = K.MaKhoa)
	WHERE	SV.HoTen = 'Le Van Sao'
	--Cach 2

	GO
	SELECT	K.SDT, K.TenKhoa
	FROM	SinhVien SV JOIN Khoa K
	ON		(SV.MaKhoa = K.MaKhoa)
	WHERE	SV.HoTen = (
		SELECT SV.HoTen
		FROM SinhVien SV
		WHERE SV.HoTen = 'Le Van Sao'
	)

	--Cau6: xuat ra ma so va ten de tai co nhieu hon 2 sinh vien dang hoc
	GO
	SELECT DT.Madt,DT.Tendt
	FROM DeTai DT
	WHERE DT.MaDT in (
		SELECT HD.MaDT
		FROM HuongDan HD
		GROUP BY HD.MaDT
		HAVING COUNT(HD.MaDT) > 2
	)

	--cau7: xua ra ma so va ten De tai co kinh phi cao nhat
	GO
	--Cach1:
	SELECT DT.MaDT, DT.TenDT
	FROM	DeTai DT
	WHERE	DT.KinhPhi IN(
		SELECT	TOP 1 DT.KinhPhi
		FROM	DeTai DT
		ORDER BY DT.KinhPhi DESC
	)
	--Cach2:
	SELECT DT.MaDT, DT.TenDT
	FROM	DeTai DT
	WHERE	DT.KinhPhi IN(
		SELECT	MAX(DT.KinhPhi)
		FROM	DeTai DT
	)

	--cau8: xuat ra ten khoa va so luong sinh vien cua moi khoa
	GO
	SELECT	K.TenKhoa
	FROM	Khoa K JOIN SinhVien SV
	ON		(k.MaKhoa = SV.MaKhoa) JOIN HuongDan HD
	ON		(SV.MaSV = HD.MaSV)


















	
