USE [Vetash]
GO

/****** Object:  Table [dbo].[Coupons]    Script Date: 2015/9/16 下午 02:49:07 ******/
DROP TABLE [dbo].[Coupons]
GO

/****** Object:  Table [dbo].[Coupons]    Script Date: 2015/9/16 下午 02:49:07 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Coupons](
	[coupon] [varchar](8) NOT NULL,
	[discount] [int] NOT NULL,
	[deadline] [date] NULL,
	[times] [int] NULL,
	[notes] [nvarchar](50) NULL,
 CONSTRAINT [PK_Coupons] PRIMARY KEY CLUSTERED 
(
	[coupon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

