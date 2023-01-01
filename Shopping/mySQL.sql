
IF EXISTS (SELECT*FROM sys.databases WHERE name LIKE 'Vegetable')
DROP DATABASE Vegetable

CREATE DATABASE Vegetable
GO
USE Vegetable

--DANH MUC SAN PHAM
CREATE TABLE Catogory(
      idCato                INT IDENTITY(1,1) PRIMARY KEY,
      [nameCato]            NVARCHAR(100)
 )

 --BANG PRODUCT
 CREATE TABLE Product(
      idProduct            INT IDENTITY(100,1) PRIMARY KEY,   
	  idCato               INT FOREIGN KEY REFERENCES Catogory(idCato),
	  namePro              NVARCHAR(100),
	  price                FLOAT,
	  sale                 FLOAT,
	  Quantity             INT,
	  imgUrl               VARCHAR(200),
	  DescriptionN         VARCHAR(200),
	  DescriptionCT        NTEXT
 )

 -- THE LOAI NEWS
 CREATE TABLE TypeNews(
      idTypeNews           INT IDENTITY(1,1) PRIMARY KEY,
      [nameTypeNews]       NVARCHAR(100)
 )

 --Tin Tuc (Co the bo)
 CREATE TABLE News (
      idNews               INT IDENTITY(100,1) PRIMARY KEY,
	  TieuDe               VARCHAR(200),
	  date                 DATETIME,
	  imgUrl               VARCHAR(200),
	  DescriptionN         VARCHAR(200),
	  DescriptionCT        NTEXT,
	  Other                NVARCHAR(100),
	  idType               INT FOREIGN KEY REFERENCES TypeNews(idTypeNews)
)

  --Contact
CREATE TABLE Contact(
      idContact            INT IDENTITY(1,1) PRIMARY KEY,
	  Phone                VARCHAR(100),
	  [Address]            NVARCHAR(200),
	  OpenTime             NVARCHAR(200),
	  Email                VARCHAR(200)
)

   --Link social netword
CREATE TABLE Social(
      idSocial             INT IDENTITY(1,1) PRIMARY KEY,
	  UrlSocial            VARCHAR(100)
)

   --Tao bang User
CREATE TABLE Users(
      idUser               INT IDENTITY(100000,1) PRIMARY KEY,
	  UserName             NVARCHAR(100),
	  Pass                 VARCHAR(100),
	  Names                NVARCHAR(100),
	  Gerder               BIT,
	  Address              NVARCHAR(200),
	  Email                VARCHAR(200),
	  Phone                VARCHAR(100),
	  Role                 INT
)


------ Edit database
GO
USE Vegetable
GO

create table review 
(
	id int IDENTITY(1,1) primary key,
	product_id int not null foreign key references product(idProduct) on delete cascade,
	name nvarchar(50) not null,
	email nvarchar(50) not null,
	content nvarchar(4000) not null,
	created date ,
)

CREATE TABLE transactions
(
	id INT IDENTITY(1,1)  PRIMARY KEY,
	user_session          NVARCHAR(50)   not null,
	user_name             NVARCHAR(50)   not null,
	user_mail             NVARCHAR(50)   not null,
	user_phone            NVARCHAR(20)   not null,
	address               NVARCHAR(300)  not null,
	message               NVARCHAR(4000) not null,
	amount                NVARCHAR(20)   not null,
	payment               NVARCHAR(30)   not null,
	status                NVARCHAR(30),
	created               DATE not null
);

CREATE TABLE Orders(
     idOrder               INT IDENTITY(1000000,1) PRIMARY KEY,
	 idPro                 INT FOREIGN KEY REFERENCES Product(idProduct),
	 idTransac             INT FOREIGN KEY REFERENCES transactions(id),
     quantity              INT
)

ALTER TABLE Product
ALTER COLUMN DescriptionN nvarchar(max);
ALTER TABLE Product ADD Weigh INT;
ALTER TABLE Social ADD logo VARCHAR(100);
ALTER TABLE OrderDetail ADD Statu VARCHAR(100);
ALTER TABLE OrderDetail ADD payment VARCHAR(100);
ALTER TABLE Orders ADD idPro INT FOREIGN KEY REFERENCES Product(idProduct);
ALTER TABLE Orders ADD quality INT;



------- Test SQL Command
USE Vegetable
GO
SELECT * FROM Product
--get catogory
SELECT idCato,nameCato FROM Catogory
--get catogory by id
SELECT * FROM Catogory WHERE idCato = ?
--get all product by page
SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY idProduct ASC) AS rn,
			idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,Weigh
			FROM Product p INNER JOIN Catogory c ON p.idCato = c.idCato) AS x WHERE rn BETWEEN 2*8-(8-1) AND 2*8
	--count to page
SELECT COUNT(*) FROM Product
--get product by cato by page
SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY idProduct ASC) AS rn,
                 idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,Weigh,c.nameCato
                FROM Product p INNER JOIN Catogory c ON p.idCato = c.idCato WHERE c.idCato LIKE 2 ) AS x WHERE rn BETWEEN 1*3-2 AND 1*3 ;
				SELECT COUNT(*) FROM Product WHERE idCato LIKE 1
			
--- search product by namr 
SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY idProduct ASC) AS rn,
                 idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,Weigh
                FROM Product p INNER JOIN Catogory c ON p.idCato = c.idCato WHERE namePro LIKE '%bò%' ) AS x WHERE rn BETWEEN 1*8-7 AND 1*8 ;
SELECT COUNT(*) FROM Product p INNER JOIN Catogory c ON p.idCato = c.idCato WHERE namePro LIKE '%bò%'

			SELECT * FROM Product WHERE namePro LIKE 'o'
    SELECT * FROM Users
	INSERT INTO Users(idUser,UserName,Pass,Names,Gerder,Address,Email,Phone,Role)VALUES(?,?,?,?,?,?)
	
	SELECT * FROM Users WHERE idUser = 100029
	DELETE FROM Users WHERE idUser = ?
	UPDATE Users SET UserName=?,Pass=?,Names=?,Address=?,Email=?,Phone=?,Role=? WHERE idUser = ?
	
	DELETE FROM Catogory WHERE idCato = ?
	UPDATE Catogory SET nameCato = ? WHERE idCato = ?
	INSERT INTO Catogory(nameCato) VALUES('abc')
	SELECT idContact,Phone,Address,OpenTime,Email FROM Contact WHERE idContact = ?
	DELETE FROM Contact WHERE idContact = ?
	UPDATE Contact SET Phone = ? , Address = ? , OpenTime = ? , Email = ? WHERE idContact = ?
	INSERT INTO Contact(Phone,Address,OpenTime,Email) VALUES(?,?,?,?)
	SELECT idSocial,UrlSocial FROM Social WHERE idSocial = ? 
	DELETE FROM Social WHERE idSocial = ?
	UPDATE Social SET UrlSocial = ? WHERE idSocial = ?
	INSERT INTO Social(UrlSocial) VALUES(?)
	SELECT idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,Weigh,c.nameCato FROM Product p,Catogory c WHERE p.idCato = c.idCato AND p.idCato = 1
	DELETE FROM Product WHERE idProduct = ?
	UPDATE Product SET idCato =?,namePro =?,price=?,sale=?,Quantity=?,imgUrl=?,DescriptionN=?,DescriptionCT=?,Weigh =? WHERE idProduct = ?
	INSERT INTO Product(idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,Weigh)VALUES(?,?,?,?,?,?,?,?,?)
	SELECT idOrDe,o.idOrder,o.idUser,DateOrder,u.Names,u.Address,u.Phone,od.quantity,od.price,p.namePro,Statu,payment,o.totalmoney 
	FROM Orders o,OrderDetail od,Users u,Product p WHERE o.idOrder = od.oid AND o.idUser = u.idUser AND od.pid = p.idProduct
	SELECT idOrder,idUser,DateOrder,totalmoney FROM Orders
	SELECT oid,pid,p.namePro,od.quantity,od.price FROM OrderDetail od,Product p WHERE od.pid = p.idProduct
	SELECT idOrder,idUser,DateOrder,p.namePro,price,o.quality FROM Orders o,Product p WHERE o.idPro = p.idProduct;
	DELETE FROM OrderDetail WHERE idOrDe = 10006
	SELECT idOrDe,oid,payment,pid,quantity,Statu FROM OrderDetail WHERE idOrDe = ?
	UPDATE OrderDetail SET Statu =? , payment = ? WHERE idOrDe = ?
	INSERT INTO Orders(idPro, idTransac , quantity) VALUES (?, ?, ?)
	SELECT * FROM Orders
	SELECT id,user_session,user_name,user_mail,user_phone,address,message,amount,payment,status,created FROM transactions
	DELETE FROM transactions where id= 5
	SELECT * FROM transactions
	Update transactions set user_name =?, user_mail =?, user_phone =?, address= ?,message=?,amount=?,payment=?, status=? where id=?
	SELECT * FROM Users WHERE UserName = 'tao' AND Pass = 123
	SELECT idCato,nameCato FROM Catogory WHERE idCato NOT IN (1,2,3) 
	SELECT * FROM Product
	INSERT INTO review(product_id,  name, email, content, created) VALUES (?, ?, ?, ?, ?)
	SELECT * FROM review WHERE product_id=100
	DELETE FROM review where id=9
	SELECT COUNT(*) FROM Users WHERE UserName LIKE 'dao'
	INSERT INTO Users (UserName,Pass,Names,Gerder,Address,Email,Phone,Role) VALUES (?,?,?,?,?,?,?,?)