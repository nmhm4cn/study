<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI・基礎代謝量判定</title>
</head>
<body>
	<h1>BMI・基礎代謝量判定</h1>
	<form action="/bmichecker/HealthCheck" method="post">
		身長：<input type="text" name="height">(cm)<br>
		体重：<input type="text" name="weight">(kg)<br>
		年齢：<input type="text" name="age">(歳)<br>
		性別：男性<input type="radio" name="gender" value="M">
		女性<input type="radio" name="gender" value="F"><br>
		<input type="submit" value="診断">
	</form>
</body>
</html>