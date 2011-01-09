create database CD_Shop_EJB

go

use Cd_shop_ejb

go

create table tblAdmin 
(
adUserName nvarchar(150) primary key,
adPassword nvarchar(150) not null,
adFullname nvarchar(150) not null,
adFunction int default'0', -- = 1 la super admin khong the update trang thai cua admin nay dc --
adStatus int default '0' -- = 0 la chua kich hoat, = 1 la da kich hoat
)

go

create table tblCustomer
(
cusEmail nvarchar(150) primary key,
cusPassword nvarchar(150) not null,
cusFullname nvarchar(150) not null,
cusAddress nvarchar(150) not null,
cusBirthDay datetime not null,
cusPhone nvarchar(150) not null,
cusStatus int default'0' -- =0 la chua kich hoat, 1 = kich hoat-
)

go
 create table tblCategory
(
cateID int identity primary key,
cateName nvarchar(150) not null,
cateDetail nvarchar(max) not null,
addFee money not null,
cateStatus int default'0' -- = 0 la chua kich hoat , 1 = kich hoat
)
go
create table tblProductCategory
(
proCateID nvarchar(150) primary key,
proCateName nvarchar(150) not null,
proCateDescription nvarchar(max) not null,
proCateStatus int default'0' --- = 0 la chua kick hoat de hien thi len web = 1 la da kich hoat
)
go

create table tblProduct
(
proID nvarchar(150) not null primary key,
cateCollection nvarchar(150) not null, -- la 1 chuoi CD,DVD,HD,VCD cach nhau dau phay the hien ro the loai dia ma san pham nay co
proCateID nvarchar(150) foreign key references tblProductCategory,
proName nvarchar(150) not null,
proDetail nvarchar(max) not null,
proImage nvarchar(150) not null,
proPublish datetime not null,
proAmountAvailable int default'0',
proPrice money ,
proPriceRent money,
proStatus int default'0'
)

go

create table tblOrder
(
orderID int identity primary key,
cusEmail nvarchar(150) foreign key references tblCustomer,
cusAccountBank nvarchar(150) ,
orderStatus int default'0'
)
go

create table tblOrderDetail
(
orderDetailID int identity primary key,
orderID int foreign key references tblOrder,
proID nvarchar(150) foreign key references tblProduct,
orderDetailCate int not null, --= 0 la mua , = 1 la thue ,
Amount int ,
dateRent datetime not null,
dateRelease datetime not null , 
orderDetailPrice money, -- = insert tien dat coc cua khach = tien mua dia moi sau day tinh tien thue theo ngay tra va update lai tien thanh toan
orderDetailStatus int default'0' -- = 0 la chua thanh toan, = 1 la da thanh toan , = 2 dang thue chua tra
)





