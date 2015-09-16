drop table Customer;
create table Customer(

CustomerName	nvarchar(20),
CustomerTel		varchar (15),
CustomerLine	varchar(20),
CustomerFb		varchar(30),
CustomerMail	varchar(50),
CustomerAddr	nvarchar(50),
CustomerNote	nvarchar(300),
 constraint Customer_CustomerTel_pk primary key (CustomerTel));

insert into customer values ('何承哲','0910103842' ,'youngalexha','youngalexha@yahoo.com','youngalexha@gmail.com','台北市大安路一段365號','買過3隻搖桿,是常客');
insert into customer values ('何承哲a','0910103842a' ,'youngalexhaa','youngalexha@yahoo.coma','youngalexha@gmail.coma','台北市大安路一段365號a','買過3隻搖桿,是常客a');
insert into customer values ('陳家輝','0910253568' ,'lovebabe','lovebabe@yahoo.com','lovebabe@gmail.com','台北市忠孝東路二段段73號','尚可');
insert into customer values ('張志明','0910454210' ,'luckyfun','luckyfun@yahoo.com','luckyfun@gmail.com','台北市復興南路二段104號','尚可');
insert into customer values ('朱字雲','0919584523' ,'dodonio','dodonio@yahoo.com','dodonio@gmail.com','台北市敦化南路二段91號','尚可');
insert into customer values ('陳綠雲','0921444853' ,'jointoy','jointoy@yahoo.com','jointoy@gmail.com','台北市仁愛路四段103號','三天後再跟他詢問搖桿是否還有問題');
insert into customer values ('李清華','0921447586' ,'reddisk','reddisk@yahoo.com','reddisk@gmail.com','新北市文化路一段113號','尚可');
insert into customer values ('李信良','0928544875' ,'tutleap','tutleap@yahoo.com','tutleap@gmail.com','台北市復興南路一段30號','尚可');
insert into customer values ('董韋庭','0930147552' ,'shawn79979','shawn79979@yahoo.com','shawn79979@gmail.com','台北市忠孝東路三段171號','普通');
insert into customer values ('巫家偉','0933451102' ,'javirs30','javirs30@yahoo.com','javirs30@gmail.com','台北市永和區中正路一段19號','買過1支搖桿,人不錯');
insert into customer values ('連俊德','0987542102' ,'happyendig','happyendig@yahoo.com','happyendig@gmail.com','新北市中山路二段101號','購買量大');