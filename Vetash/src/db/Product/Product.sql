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


