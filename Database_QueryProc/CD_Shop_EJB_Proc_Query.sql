use CD_Shop_EJB
go
--- cac Proc lam viec voi bang Admin {-----------------------------------------
create proc pc_selectAdmin
as
select * from tblAdmin 

go 

create proc pc_selectAdminByAdUserName @adUserName nvarchar(150)
as
select * from tblAdmin where adUserName = @adUserName

go

create proc pc_selectAdminByStatus @adStatus int
as
select * from tblAdmin where adStatus = @adStatus

go
---- Chi co supperAdmin(adminFunction = 1) moi dung dc chuc nang nay . 
create proc pc_selectAdminByFuntion @adFunction int
as
select * from tblAdmin where adFunction = @adFunction


go

create proc pc_adminLogin @adUserName nvarchar(150) , @adPassword nvarchar(150)
as
select * from tblAdmin where adUserName = @adUserName and adPassword = @adPassword

go

create proc pc_InsertAdmin @adUserName nvarchar(150), @adminPassword nvarchar(150) ,@adminFullName nvarchar(150) , @adminFunction int
as
insert into tblAdmin values (@adUserName,@adminPassword,@adminFullName,@adminFunction,'')

go

-- Neu muon thay doi pass admin trc het goi pc_adminLogin xem pass cu va user co trung nhau khong sau day truyen het cac thong tin vao pc nay tru pass thi lay pass moi add vao
-- Chu y neu khong phai la super Admin thi khong dc thay doi function cua admin hay trang thai admin

create proc pc_UpdateAdmin @adUserName nvarchar(150), @adminPassword nvarchar(150) ,@adminFullName nvarchar(150) , @adminFunction int, @adminStatus int
as
begin
	if(@adminPassword = '' and @adminFullName = '' and @adminFunction = '')
		begin
			update tblAdmin set adStatus = @adminStatus
			where adUserName = @adUserName
		end
	else if (@adminFullName = '' and @adminFunction = '' and @adminStatus = '')
		begin
			update tblAdmin set adPassword = @adminPassword
			where adUserName = @adUserName
		end
	else if (@adminPassword = '' and @adminFunction = '' and @adminStatus = '')
		begin 
			update tblAdmin set adFullname = @adminFullName
			where adUserName = @adUserName
		end
	else if (@adminPassword = '' and @adminFullName = '' and @adminStatus = '')
		begin 
			update tblAdmin set adFunction = @adminFunction
			where adUserName = @adUserName
		end
	else if (@adminPassword ='' and @adminFullName = '')
		begin
			update tblAdmin set adFunction = @adminFunction , adStatus = @adminStatus
			where adUserName = @adUserName
		end
	else if (@adminFunction = '' and @adminStatus = '')
		begin
			update tblAdmin set adPassword = @adminPassword, adFullname = @adminFullName
			where adUserName = @adUserName
		end
	else if (@adminPassword ='' and @adminStatus = '')
		begin 
			update tblAdmin set adFullname = @adminFullName , adFunction = @adminFunction
			where adUserName = @adUserName
		end
	else if (@adminFullName = '' and @adminStatus = '')
		begin
			update tblAdmin set adPassword = @adminPassword , adStatus = @adminStatus
			where adUserName = @adUserName
		end
end
------------------ } Het proc lam viec voi bang admin ---------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

------ Cac Proc lam viec voi bang Category {
go

create proc pc_SelectCateGory
as
select * from tblCategory

go

create proc pc_SelectCategoryByCategoryID @categoryID int
as
select * from tblCategory where cateID = @categoryID

go

create proc pc_SelectCategoryByStatus @cateStatus int
as
select * from tblCategory where cateStatus = @cateStatus

go

create proc pc_InsertCategory @cateName nvarchar(150),@cateDetail nvarchar(max), @addFee money
as
insert into tblCategory values (@cateName,@cateDetail,@addFee,'')

go

create proc  pc_UpdateCategory @cateID int , @cateName nvarchar(150) , @cateDetail nvarchar(max),@addFee money, @cateStatus int
as
Begin
if (@cateName='' and @cateDetail = '' and @addFee = '')
	begin 
		update tblCategory set cateStatus = @cateStatus
		where cateID = @cateID
	end
else if (@cateName = '' and @cateStatus = '' and @addFee = '')
	begin
		update tblCategory set cateDetail = @cateDetail
		where cateID = @cateID
	end
else if (@cateDetail='' and @cateStatus = '' and @addFee = '')
	begin
		update tblCategory set cateName = @cateName
		where cateID = @cateID
	end
else if (@cateDetail = '' and @cateName = '' and @cateStatus = '')
	begin
		update tblCategory set addFee = @addFee 
		where cateID = @cateID
	end
else 
	begin
		update tblCategory set cateName = @cateName , cateDetail = @cateDetail , cateStatus = @cateStatus
		where cateID = @cateID
	end
End

------- Het Proc lam viec voi Category ---------------------------------------------------------------

-------------- Bat dau proc lam viec voi bang Customer
go

create proc pc_SelectAllCustomer
as
select * from tblCustomer

go

create proc pc_SelectCustomerByEmail @email nvarchar(150)
as
select * from tblCustomer where cusEmail = @email

go

create proc pc_SelectCustomerByCustatus @cusStatus int
as
select * from tblCustomer where cusStatus = @cusStatus

go

create proc pc_CustomerLogin @email nvarchar(150) , @password nvarchar(150)
as
select * from tblCustomer where cusEmail = @email and cusPassword = @password

go

create proc pc_InsertCustomer @cusEmail nvarchar(150), @cusPassword nvarchar(150), @cusFullName nvarchar(150),@cusAddress nvarchar(150),@cusBirthDay datetime , @cusPhone nvarchar(150)
as
insert into tblCustomer values (@cusEmail,@cusPassword,@cusFullName,@cusAddress,@cusBirthDay,@cusPhone,'')

go

create proc pc_UpdateCustomer @cusEmail nvarchar(150), @cusPassword nvarchar(150), @cusFullName nvarchar(150), @cusAddress nvarchar(150),@cusBirthDay datetime, @cusPhone nvarchar(150) , @cusStaus int
as
Begin
	IF (@cusPassword = '' And @cusStaus = '' )
		Begin
			update tblCustomer set cusFullname = @cusFullName , cusAddress = @cusAddress , cusBirthDay = @cusBirthDay , cusPhone = @cusPhone 
			where cusEmail = @cusEmail
		end
	Else if (@cusPassword = '')
		begin 
			update tblCustomer set cusAddress = @cusAddress , cusBirthDay = @cusBirthDay , cusFullname = @cusFullName , cusPhone = @cusPhone , cusStatus = @cusStaus
			where cusEmail = @cusEmail
		end
	else 
		begin
			update tblCustomer set cusAddress = @cusAddress , cusBirthDay = @cusBirthDay , cusFullname = @cusFullName , cusPassword = @cusPassword , cusPhone = @cusPhone , cusStatus = @cusStaus
			where cusEmail = @cusEmail 
		end			
End
--------------------------------- Het Proc tren bang Customer ----------------------------------------------

--------------------------------- Bat Dau proc tren bang Oder-----------------------------------------------
go

create proc pc_selectAllOrder
as
select * from tblOrder

go

create proc pc_selectOrderByID @orderID int
as
select * from tblOrder where orderID = @orderID

go

create proc pc_selectOrderByCusEmail @cusEmail nvarchar(150)
as
select * from tblOrder where cusEmail = @cusEmail

go 

create proc pc_selectOrderByStatus @orderStatus int
as
select * from tblOrder where orderStatus = @orderStatus

go

create proc pc_InsertOrder @cusEmail nvarchar(150), @cusAccountBank nvarchar(150)
as
insert into tblOrder values(@cusEmail,@cusAccountBank,'')

go

create proc pc_UpdateOrder @orderID int , @cusAccountBank nvarchar(150) , @orderStatus int
as
Begin
	if(@cusAccountBank ='')
	begin
		update tblOrder set orderStatus = @orderStatus
		where orderID = @orderID
	end
	else if (@orderStatus = '')
	begin
		update tblOrder set cusAccountBank = @cusAccountBank
		where orderID = @orderID
	end
	else
	begin
		update tblOrder set cusAccountBank = @cusAccountBank, orderStatus = @orderStatus
		where orderID = @orderID
	end
End
-----------------------------------Ket Thuc Proc lam viec tren bang order -------------------


----------------------------Bat dau proc lam viec tren bang orderDetail----------------------
go

create proc pc_SelectAllOrderDetail
as
select * from tblOrderDetail

go 

create proc pc_SelectOrderDetailByID @orderDetailID int
as
select * from tblOrderDetail where orderDetailID =  @orderDetailID

go

create proc pc_selectOrderDetailByOrderID @orderID int
as
select * from tblOrderDetail where orderID = @orderID

go

create proc pc_selectOrderDetailByProID @proID nvarchar(150)
as
select * from tblOrderDetail where proID = @proID

go

create proc pc_selectOrderDetailByOrderDetailCate @orderDetailCate int
as
select * from tblOrderDetail where orderDetailCate = @orderDetailCate

go

create proc pc_selectOrderDetailBetweenDateRent @dateBegin datetime, @dateEnd datetime
as
select * from tblOrderDetail where dateRent between @dateBegin and @dateEnd

go

create proc pc_selectOrderDetailBetweenDateRelease @dateBegin datetime, @dateEnd datetime
as
select * from tblOrderDetail where dateRelease between @dateBegin and @dateEnd

go

create proc pc_selectOrderDetailByStatus @status int
as
select * from tblOrderDetail where orderDetailStatus = @status

go

create proc pc_insertOrderDetail @orderID int, @proID nvarchar(150),@orderDetailCate int , @amount int , @dateRent datetime, @dateRelease datetime,@oderDetailPrice money, @status int
as
insert into tblOrderDetail values(@orderID,@proID,@orderDetailCate,@amount,@dateRent,@dateRelease,@oderDetailPrice,@status)

go

create proc pc_updateOrderDetail @orderDetailID int, @dateRelease datetime,@orderDetailStatus int
as
Begin
	If (@dateRelease = '')
	Begin
		update tblOrderDetail set orderDetailStatus = @orderDetailStatus
		where orderDetailID = @orderDetailID
	End
	Else IF (@orderDetailStatus = '')
	Begin
		update tblOrderDetail set dateRelease = @dateRelease
		where orderDetailID = @orderDetailID
	End
	Else 
	Begin
		update tblOrderDetail set dateRelease = @dateRelease , orderDetailStatus = @orderDetailStatus
		where orderDetailID = @orderDetailID
	End
End

--------------------- Het Proc lam viec voi bang orderDetail-----------------------------------

-------------------- Proc lam viec voi bang Product --------------------------------------------

go

create proc pc_selectAllProduct 
as
select * from tblProduct

go

create proc pc_selectProductByID @proID nvarchar(150)
as
select * from tblProduct where proID = @proID

go

create proc pc_selectProductByCateCollection @cateName nvarchar(150)
as
select * from tblProduct where cateCollection like '%'+@cateName+'%'

go

create proc pc_selectProductByProCateID @proCateID nvarchar(150)
as
select * from tblProduct where proCateID = @proCateID

go

create proc pc_selectProductByProName @proName nvarchar(150)
as
select * from tblProduct where proName like '%' +@proName+'%'

go

create proc pc_selectProductByPublishDate @publishDate datetime
as
select * from tblProduct where proPublish = @publishDate


go

create proc pc_selectProductByProAmount @amount int
as
select * from tblProduct where proAmountAvailable = @amount

go

create proc pc_selectProductByBetweenPrice @priceBegin money, @priceEnd money
as
select * from tblProduct where proPrice between @priceBegin and @priceEnd

go

create proc pc_selectProductByBetweenPriceRent @priceBegin money , @priceEnd money
as
select * from tblProduct where proPriceRent between @priceBegin and @priceEnd

go

create proc pc_selectProductByStatus @proStatus int
as
select * from tblProduct where proStatus = @proStatus

go

create proc pc_InsertProduct @proID nvarchar(150), @cateCollection nvarchar(150), @proCateID nvarchar(150) , @proName nvarchar(150), @proDetail nvarchar(max), @proImage nvarchar(150), @proPublish datetime , @proAmount int, @proPrice money , @proPriceRent money
as
insert into tblProduct values(@proID,@cateCollection,@proCateID,@proName,@proDetail,@proImage,@proPublish,@proAmount,@proPrice,@proPriceRent,'')

go

create proc pc_UpdateProduct @proID nvarchar(150) , @cateCollection nvarchar(150), @proCateID nvarchar(150) , @proName nvarchar(150), @proDetail nvarchar(max), @proImage nvarchar(150), @proPublish datetime, @proAmount int,@proPrice money , @proPriceRent money, @proStatus int
as
update tblProduct set cateCollection = @cateCollection , proCateID = @proCateID , proName = @proName , proDetail = @proDetail , proImage = @proImage , proPublish = @proPublish , proAmountAvailable =@proAmount, proPrice =@proPrice , proPriceRent = @proPriceRent , proStatus = @proStatus
where proID = @proID

--------------------------- Xong proc lam viec voi bang product -------------------------------------------------------------------------
--------------------------- Proc lam viec voi bang Product Category---------------------------------------------------------------------

go

create proc pc_selectAllProductCategory 
as
select * from tblProductCategory

go

create proc pc_selectProductCateGoryByStatus @proCategoryStatus int
as
select * from tblProductCategory where proCateStatus = @proCategoryStatus

go

create proc pc_selectProductCategoryByProductCateID @proCateID nvarchar(150)
as
select * from tblProductCategory where proCateID = @proCateID

go

create proc pc_selectProductCategoryByProductCateName @proCateName nvarchar(150)
as
select * from tblProductCategory where proCateName like '%' + @proCateName + '%'

go

create proc pc_InsertProductCategory @proCateID nvarchar(150) , @proCateName nvarchar(150) , @proCateDescription nvarchar(max)
as
insert into tblProductCategory values(@proCateID,@proCateName,@proCateDescription,'')

go

create proc pc_UpdateProductCategory @proCateID nvarchar(150) , @proCateName nvarchar(150) , @proCateDescription nvarchar(max) , @proCateStatus int
as
update tblProductCategory set proCateName = @proCateName , proCateDescription = @proCateDescription , proCateStatus = @proCateStatus
where proCateID = @proCateID