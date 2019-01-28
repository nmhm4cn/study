<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ひとこと掲示板｜ログイン結果</title>
</head>
<body>
<h1>ログイン結果</h1>
<% if(loginUser != null) { %>
	<p>ログインに成功しました。<br>
	ようこそ、<%= loginUser.getName() %>さん。</p>
	<a href="/tsubuyaki/Main">つぶやき投稿画面へ</a>
<% } else { %>
	<p>ログインに失敗しました。</p>
	<a href="/tsubuyaki/">TOP画面へ</a>
<% } %>
<jsp:include page="footer.jsp" />
</body>
</html>