CREATE DATABASE Vetash

drop table "Image"
 
--Image
CREATE TABLE "Image"
(ImageId int PRIMARY KEY IDENTITY,
ImageName nvarchar(30),
"ImageDate" datetime,
"ImagePath" nvarchar(1024),
ImgCategoryId int references ImgCategory (ImgCategoryId)
);
INSERT INTO "Image" VALUES ('浩克','2015-09-04','http://graph.facebook.com/TheIncredibleHulkFilm/picture','1');
INSERT INTO "Image" VALUES ('鋼鐵人','2014-08-01','http://graph.facebook.com/IronMan2/picture','2');
INSERT INTO "Image" VALUES ('雷神索爾','2014-08-01','http://graph.facebook.com/ThorMovie/picture','3');
INSERT INTO "Image" VALUES ('美國隊長','2014-08-01','http://graph.facebook.com/CaptainAmericaMovie/picture','4');
INSERT INTO "Image" VALUES ('蜘蛛人','2014-08-01','http://graph.facebook.com/theamazingspiderman/picture','5');

--測試

INSERT INTO "Image" VALUES ('2014-08-01','蜘蛛人','http://graph.facebook.com/theamazingspiderman/picture','5');

select top 1 ImageId from "Image" order by ImageId desc
