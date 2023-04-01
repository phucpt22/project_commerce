--DROP DATABASE AsmJava6

CREATE DATABASE AsmJava66
GO
USE AsmJava66
GO

--Tạo bảng
CREATE TABLE NguoiDung(
	id_NguoiDung int identity(1,1) primary key,
	soDT varchar(15),
	hoTen nvarchar(50), 
	ngaySinh date,
	gioiTinh bit, 	
	eMail varchar(50),
	hAnh varchar(100),
	tenTK varchar(50),
	matKhau varchar(50),
	diaChi nvarchar(255),
	isActive bit,
	vaiTro bit	
)
GO

CREATE TABLE ChungLoai (
	id_ChungLoai int identity(1,1) primary key,
	tenChungLoai nvarchar(50)	
)
GO


CREATE TABLE VaiTro (
	id_VaiTro int identity(1,1) primary key,
	tenVaiTro nvarchar(50)	
)
GO

CREATE TABLE CapQuyen (
	id_CapQuyen int identity(1,1) primary key,
	id_NguoiDung int,
	id_VaiTro int
)
GO
CREATE TABLE SanPham (
	id_SP int identity(1,1) primary key, 
	tenSP nvarchar(250),	
	trangThai bit,	
	hAnh nvarchar(250),
	gia decimal (9,0),	
	slTonKho int,	
	moTa nvarchar(250),
	id_ChungLoai int,
	is_Delete bit --Trạng thái xóa khỏi danh sách SP chưa 
	
)
GO

CREATE TABLE DonDatHang (
	id_DDH int identity(1,1) primary key, 
	ngayDat date, 
	ghiChuKH nvarchar(250), 
	tongTien decimal(9,0), 
	soDT nchar(15),	
	diaChi nvarchar(255), 
	id_NguoiDung int,
	trangThaiDH int DEFAULT 0  --- 0 dat hang , 1 admin xac nhan , 2 dangvanchuyen (lam them bang van chuyen ,phat trien sau), 3 hoanthanh, 4 huy 
	
)
GO

CREATE TABLE DonDatChiTiet (
	id_DDCT int identity(1,1) primary key, 
	id_DDH int, 
	id_SP int, 
	soLuong int,
	kichThuoc varchar(5),	
	tongTien decimal (9,0)	
)
GO

--- forginKEy

-- SanPham
ALTER TABLE SanPham ADD CONSTRAINT FK_SanPham_ChungLoai FOREIGN KEY (id_ChungLoai) REFERENCES ChungLoai(id_ChungLoai) ON DELETE SET NULL ON UPDATE NO ACTION;
go
--Cap quyen
ALTER TABLE CapQuyen ADD CONSTRAINT FK_IDnguoiDung FOREIGN KEY (id_NguoiDung) REFERENCES NguoiDung(id_NguoiDung) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE CapQuyen ADD CONSTRAINT FK_IDvaiTro FOREIGN KEY (id_VaiTro) REFERENCES VaiTro(id_VaiTro) ON DELETE NO ACTION ON UPDATE CASCADE;
go
-- Dondathang
ALTER TABLE DonDatHang ADD CONSTRAINT FK_DonDatHang_NguoiDung FOREIGN KEY (id_NguoiDung) REFERENCES NguoiDung(id_NguoiDung) ON DELETE NO ACTION ON UPDATE CASCADE;
go

-- DONdathangchitiet
ALTER TABLE DonDatChiTiet ADD CONSTRAINT FK_DonDatHangCT_SanPham FOREIGN KEY (id_SP) REFERENCES SanPham(id_SP) ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE DonDatChiTiet ADD CONSTRAINT FK_DonDatHangCT_DonDatHang FOREIGN KEY (id_DDH) REFERENCES DonDatHang(id_DDH) ON DELETE NO ACTION ON UPDATE CASCADE;
go

----------------Thêm dữ liệu vào bảng
--Bảng KhachHang
INSERT INTO NguoiDung VALUES 
					('0938475941', N'Lê Thanh Vân', '1998-04-22', 0, 'vantl2311@gmail.com', 'anh12.png','van123','van123', N'123, Gò Vấp',1,0),
					('0908657323', N'Nguyễn Văn A', '1996-10-25', 1, 'aaaa@gmail.com', 'anh11.png','aaa123','tu123', N'123, Quận 12',1,0),
					('0749357959', N'Trần Thành Tâm', '1996-12-19', 1, 'tam394@gmail.com', 'anh10.png','tam123','tam123', N'123, Quận 11',1,0),
					('0778349430', N'Đỗ Trung Nam', '2002-11-22', 1, 'nam234@gmail.com', 'anh9.png','nam123','nam123', N'123, Quận 10',1,0),
					('0339204844', N'Lâm Trần Tuấn', '1997-10-24', 1, 'tuan384@gmail.com', 'anh8.png','tuan123','tuan123', N'123, Quận 5',1,0),
					('0448305885', N'Nguyễn Thị Thu', '1995-08-22', 0, 'thds342@gmail.com', 'anh7.png','thu123','thu123', N'123, Quận 5',1,0),
					('0938495860', N'Phạm Thị Thiên Hoa', '2000-01-23', 0, 'def231@gmail.com', 'anh6.png','hoa123','hoa123', N'123, Quận 6',1,0),
					('0948584738', N'Trần Thanh Tân', '1996-05-20', 1, 'abc123@gmail.com', 'anh5.png','tan123','tan123', N'123, Quận 11',1,0),
					('0382748459', N'Bùi Tá Đại ', '2000-04-16', 1, 'dai2930@fpt.edu.vn', 'anh4.png','dai123','dai123', N'123, Quận 10',1,1),
					('0749830485', N'Phan Văn Kiên', '2001-07-13', 1, 'kien3421@fpt.edu.vn', 'anh3.png','kien123','kien123', N'234, Quận 12',1,1),
					('0344584950', N'Nguyễn Trần Anh Tú', '1996-10-21', 1, 'tups12938@fpt.edu.vn', 'anh2.png','tu123','tu123', N'123, Quận 12',1,1),
					('0338515125', N'Phạm Trọng Phúc', '2002-12-01', 1, 'phucptps19445@fpt.edu.vn', 'anh1.png','phuc123','phuc123', N'958 Quang Trung, Phường 10, Gò Vấp',1,1)				  
GO
--Bảng vai trò
INSERT INTO VaiTro VALUES
					(N'Khách hàng'),
					(N'Nhân viên'),
					(N'Quản lý')
GO
--Bảng cấp quyền
INSERT INTO CapQuyen VALUES
					(1,1),
					(2,1),
					(3,2),
					(4,2),
					(5,2),
					(6,2),
					(7,2),
					(8,2),
					(9,3),
					(10,3),
					(11,3),
					(12,3)
GO
--Bảng ChungLoai
INSERT INTO ChungLoai VALUES 
					(N'Nhẫn'),
					(N'Bông tai'),
					(N'Lắc'),
					(N'Vòng tay'),
					(N'Dây chuyền'),
					(N'Kiềng')
GO

--Bảng Sản Phẩm
INSERT INTO SanPham VALUES 
					(N'Đồng hồ Calvin Klein Nam 25200117 Dây Kim Loại 44 mm',1,N'25200117.jpg',5796000,300,N'Với lối thiết kế hợp thời trang, đơn giản nhưng vẫn có nét độc đáo riêng, được kết hợp cùng bộ máy đồng hồ Thụy Sỹ chất lượng. Những chiếc đồng hồ Calvin Klein là món phụ kiện hoàn hảo cho những tín đồ thời trang',4,1),
					(N'Đồng hồ Calvin Klein Nam 25200116 Dây Kim Loại 44 mm',1,N'25200116.jpg',4446000,300,N'Với lối thiết kế hợp thời trang, đơn giản nhưng vẫn có nét độc đáo riêng, được kết hợp cùng bộ máy đồng hồ Thụy Sỹ chất lượng. Những chiếc đồng hồ Calvin Klein là món phụ kiện hoàn hảo cho những tín đồ thời trang',4,1),
					(N'Bông tai Bạc đính Ngọc Trai PNJSilver PMXMW000001',1,N'PMXMW000001.jpg',798000,300,N'Bông tai Bạc là sự hợp nhãn hiệu thời trang nổi tiếng của Mỹ, hoạt động từ năm 2000. Với lối thiết kế hợp thời trang, đơn giản nhưng vẫn có nét độc đáo riêng, được kết hợp cùng bộ máy Bông tai Bạc chất lượng.',2,1),
					(N'Bông tai Bạc đính đá STYLE By PNJ Sexy ZTMXW000012',1,N'ZTMXW000012.jpg',796000,300,N'Bông tai Bạc là sự hợp nhãn hiệu thời trang nổi tiếng của Mỹ, hoạt động từ năm 2000. Với lối thiết kế hợp thời trang, đơn giản nhưng vẫn có nét độc đáo riêng, được kết hợp cùng bộ máy Bông tai Bạc chất lượng.',2,1),
					(N'Nhẫn Vàng đính đá Synthetic Disney|PNJ ZTXMX000003',1,N'ZTXMX000003.jpg',3796000,300,N'Có thể nói, sản phẩm này như là lời ví von xinh đẹp mà Disney|PNJ gửi tặng đến các giai nhân. Vì nàng luôn biết cách rực rỡ theo sắc màu riêng, như cầu vồng tản ánh sắc không bao giờ trùng lắp.',1,1),
					(N'Nhẫn bạc đính đá STYLE by PNJ Feminine XMXMY060002',1,N'XMXMY060002.jpg',2796000,300,N'Có thể nói, sản phẩm này như là lời ví von xinh đẹp mà Disney|PNJ gửi tặng đến các giai nhân. Vì nàng luôn biết cách rực rỡ theo sắc màu riêng, như cầu vồng tản ánh sắc không bao giờ trùng lắp.',1,1),
					(N'Dây cổ Bạc đính đá STYLE By PNJ Sweet Spring ZTZTW000005',1,N'ZTZTW000005.jpg',876000,300,N'Để thỏa sức sáng tạo với lựa chọn riêng của từng cô gái, nàng có thể kết hợp nhiều items khác để dễ dàng mix&match với nhau tùy theo cá tính thời trang và luôn refresh diện mạo mỗi ngày.',5,1),
					(N'Dây cổ Bạc đính đá STYLE By PNJ DNA XM00H000018',1,N'XM00H000018.jpg',2234000,300,N'Để thỏa sức sáng tạo với lựa chọn riêng của từng cô gái, nàng có thể kết hợp nhiều items khác để dễ dàng mix&match với nhau tùy theo cá tính thời trang và luôn refresh diện mạo mỗi ngày.',5,1),
					(N'Lắc tay đính đá Disney|PNJ Mickey&Minnie ZTXMZ000001',1,N'ZTXMZ000001.jpg',10544000,300,N'Đặc biệt hơn, chiếc lắc tay sẽ trở nên ý nghĩa hơn khi trở thành món quà ghi dấu yêu thương vào những dịp quan trọng. Đây chắc chắn sẽ là thứ giúp bạn gắn kết những khoảnh khắc đáng nhớ với mình hoặc người thương.',3,1),
					(N'Lắc tay Vàng cưới 24K PNJ 0000Y002317',1,N'0000Y002317.jpg',15332000,300,N'Đặc biệt hơn, chiếc lắc tay sẽ trở nên ý nghĩa hơn khi trở thành món quà ghi dấu yêu thương vào những dịp quan trọng. Đây chắc chắn sẽ là thứ giúp bạn gắn kết những khoảnh khắc đáng nhớ với mình hoặc người thương.',3,1),
					(N'Kiềng cưới Vàng 24K PNJ 0000Y060001',1,N'0000Y060001.jpg',18496000,300,N'Với các điểm nhấn trên sản phẩm, PNJ tin rằng nàng sẽ trở nên thật sự tỏa sáng và nổi bật khi trưng diện chúng.',4,1),
					(N'Kiềng cưới Vàng 24K PNJ 1000Y060001',1,N'1000Y060001.jpg',16798000,300,N'Với các điểm nhấn trên sản phẩm, PNJ tin rằng nàng sẽ trở nên thật sự tỏa sáng và nổi bật khi trưng diện chúng.',4,1),
					(N'Cặp nhẫn cưới ECZ PNJ 00005-00013',1,N'00005-00013.jpg',15888000,300,N'Không chỉ có vai trò là vật đính ước thiêng liêng, nhẫn cưới kim cương còn thể hiện cá tính và phong cách của mỗi cặp đôi. Tại PNJ, các cặp đôi luôn có thể sở hữu những thiết kế nhẫn cưới kim cương vừa hợp lí về tài chính, vừa đẹp về mẫu mã.',1,1),
					(N'Cặp nhẫn cưới Kim cương 00990-00976',1,N'00990-00976.jpg',19999000,300,N'Không chỉ có vai trò là vật đính ước thiêng liêng, nhẫn cưới kim cương còn thể hiện cá tính và phong cách của mỗi cặp đôi. Tại PNJ, các cặp đôi luôn có thể sở hữu những thiết kế nhẫn cưới kim cương vừa hợp lí về tài chính, vừa đẹp về mẫu mã.',1,1)
						 
GO

--Bảng Đơn Đặt Hàng
INSERT INTO DonDatHang VALUES 
					('2023-01-01',N'',5796000,'0938475941',N'123, Gò Vấp',1,1),
					('2023-01-01',N'',798000,'0749357959',N'123, Quận 11',3,1),
					('2023-01-01',N'',3796000,'0448305885',N'123, Quận 5',6,1),
					('2023-01-02',N'',3796000,'0778349430',N'123, Quận 2',4,1),
					('2023-01-02',N'',3796000,'0778349430',N'123, Quận 2',4,1)


GO

--Bảng Đơn Đặt Chi Tiết
INSERT INTO DonDatChiTiet VALUES 
					(1,1,1,'',5796000),
					(2,2,1,'',5796000),
					(3,3,1,'',5796000),
					(4,5,1,'',5796000),
					(5,8,2,'',11432000)

GO
