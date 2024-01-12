USE ONLINESHOPDB
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Sp_user_login]
	@email VARCHAR(150),
	@password VARCHAR(150)
AS
BEGIN 
	declare @count int
	declare @res bit
	select @count = COUNT(*) FROM [dbo].[user] WHERE email = @email AND password=@password
	if @count > 0
		set @res = 1
	else
		set @res = 0
END

