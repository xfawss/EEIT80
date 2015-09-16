CREATE DATABASE Vetash

drop table ImgCategory;

--ImgCategory
CREATE TABLE ImgCategory
(ImgCategoryId int PRIMARY KEY IDENTITY,
ImgCategoryName nvarchar(15)
);
INSERT INTO ImgCategory VALUES('面版圖');
INSERT INTO ImgCategory VALUES('搖桿圖');
INSERT INTO ImgCategory VALUES('過去作品集');
INSERT INTO ImgCategory VALUES('首頁輪播圖');
INSERT INTO ImgCategory VALUES('按鈕圖');

--測試
insert into ImgCategory (ImgCategoryName) values ('美女圖')

select * from ImgCategory where ImgCategoryName like '%版%'

select * from ImgCategory where ImgCategoryId=5

insert into ImgCategory (ImgCategoryName) values ('公館大頭照')