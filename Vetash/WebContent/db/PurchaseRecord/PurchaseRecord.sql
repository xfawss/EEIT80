USE [Vetash]
GO

/****** Object:  Table [dbo].[PurchaseRecord]    Script Date: 2015/9/17 上午 11:20:57 ******/
DROP TABLE [dbo].[PurchaseRecord]
GO

/****** Object:  Table [dbo].[PurchaseRecord]    Script Date: 2015/9/17 上午 11:20:57 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[PurchaseRecord](
	[RecordNo] [int] IDENTITY (1,1) NOT NULL,
	[Date] [date] NOT NULL,
	[Type] [varchar](20) NOT NULL,
	[Notes] [nvarchar](50) NULL,
	[ProductId] [varchar](20) NOT NULL,
	[Number] [int] NOT NULL,
	[Prize] [int] NOT NULL,
	[SupplierId] [int] NOT NULL,
 CONSTRAINT [PK_PurchaseRecord] PRIMARY KEY CLUSTERED 
(
	[RecordNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

