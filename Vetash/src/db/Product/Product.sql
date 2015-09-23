USE [Vetash]
GO


DROP TABLE [dbo].[Product]
GO


SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Product](
	[ProductId] [varchar](20) NOT NULL,
	[ProductType] [varchar](20) NOT NULL,
	[ProductName] [nvarchar](20) NOT NULL,
	[ProductPrice] [int] NULL,
	[ProductCost] [int] NOT NULL,
	[ProductQty] [int] NOT NULL,
	[ProductImgPath] [varchar](1024) NULL,
	[ProductNote] [nvarchar](300) NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO



INSERT INTO Product VALUES('ID1','按鍵','三合靜音按鈕','100','50','200','','');
INSERT INTO Product VALUES('ID2','按鍵','清水按鈕','150','80','100','','');
INSERT INTO Product VALUES('ID3','搖桿','三合搖桿','300','200','50','','推薦');
INSERT INTO Product VALUES('ID4','搖桿','清水搖桿','400','200','50','','不推薦');
INSERT INTO Product VALUES('ID5','搖桿','三合光學搖桿','500','400','20','','');