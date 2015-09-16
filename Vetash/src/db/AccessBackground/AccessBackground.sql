USE [Vetash]
GO

/****** Object:  Table [dbo].[AccessBackground]    Script Date: 2015/9/16 下午 04:41:17 ******/
DROP TABLE [dbo].[AccessBackground]
GO

/****** Object:  Table [dbo].[AccessBackground]    Script Date: 2015/9/16 下午 04:41:17 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[AccessBackground](
	[BigWave] [varchar](10) NOT NULL,
	[PassKey] [varbinary](50) NOT NULL,
 CONSTRAINT [PK_AcessBackground] PRIMARY KEY CLUSTERED 
(
	[BigWave] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

