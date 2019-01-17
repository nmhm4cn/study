<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Health" %>

<%
//リクエストスコープに保存されたインスタインスを取得
Health health = (Health)request.getAttribute("health");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果｜BMI・基礎代謝量判定</title>
</head>
<body>
<h1>BMI・基礎代謝量判定の結果</h1>
<p>
身長：<%= health.getHeight() %>cm<br>
体重：<%= health.getWeight() %>kg<br>
性別：<%= health.getGender() %><br>
BMI：<%= health.getBmi() %><br>
体型：<%= health.getBodyType() %><br>
基礎代謝料：<%= health.getBmr() %>kcal
</p>
<a href="/bmichecker/HealthCheck">戻る</a>
</body>
</html>