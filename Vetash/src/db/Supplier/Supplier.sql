CREATE DATABASE Vetash

drop table Supplier

--Supplier
CREATE TABLE Supplier
(SupplierId int PRIMARY KEY IDENTITY,
SupplierName nvarchar(30),
SupplierTax varchar (15),
SupplierContact nvarchar (15),
SupplierTel varchar (15),
SupplierAddr nvarchar (50),
SupplierAcct varchar (25),
SupplierDate date,
SupplierNote nvarchar (300)
);
INSERT INTO Supplier VALUES('台灣碩網SONET網路娛樂股份有限公司','46954856','詹小堂','0987542412','臺北市羅斯福路二段9號4樓之1','017-456552369875','2015-03-22','普通搖桿商');
INSERT INTO Supplier VALUES('香港KKBOX音樂娛樂股份有限公司','54785024','何小哲','0910147520','臺北市忠孝東路五段9號3樓之2','015-856552369802','2010-05-19','螺絲商');
INSERT INTO Supplier VALUES('台中搖桿娛樂股份有限公司','12765428','王大明','0955120174','臺北市大安路二段341號4樓之3','017-456552385024','2014-08-31','普通搖桿商');
INSERT INTO Supplier VALUES('中壢面板商股份有限公司','62224568','方小同','0974002547','臺北市基隆路145號12樓之4','017-316552356302','2013-10-22','面板商');
INSERT INTO Supplier VALUES('三重按扭股份有限公司','72023504','江大樹','0933685100','臺北市華岡路一段99號1樓之5','017-146552372589','2012-05-01','按鈕商');


--測試
select * from Supplier where SupplierTel = '0974002547'

select * from Supplier where SupplierName like '%中%'




