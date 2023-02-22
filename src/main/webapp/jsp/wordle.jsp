<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wordle JavierBurillo</title>
<style>

	.rounded-button {
		background-color: #4CAF50; /* Green */
		border: none;
		color: white;
		padding: 15px 32px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 2px;
		cursor: pointer;
		border-radius: 25px;
		cursor: pointer;
	  }
	  h1 {
		  font-size: 100px;
		  font-weight: bold;
		  color: #333;
		  text-align: center;
		  margin-top: 20px;
		  margin-bottom: 50px;
		 padding-left: 5%;
		}
		h2 {
			font-size: 100px;
			font-weight: bold;
			color: #333;
			text-align: center;
			margin-top: 20px;
			margin-bottom: 50px;
		  }
		input[type="text"] {
		  width: 33%;
		  padding: 12px 20px;
		  margin: 8px 0;
		  box-sizing: border-box;
		  border: 2px solid #ccc;
		  border-radius: 25px;
		  background-color: #f8f8f8;
		  font-size: 16px;
		  color: #333;
		}
		#history-div {
			background: #000;
			color: #fff;
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			padding: 20px;
			width: 100%;
		}
  </style>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="background-color: #F5F5F5; font-family: Arial, sans-serif;">
	<br>
	<a style=" text-align: right; font-size: 18px; color: blue; margin-left: 10px;">  Intentos restantes: ${Attempts}</a>
	<h1 style="font-size: 90px; text-align: center; margin-top: 50px; margin-bottom: 50px;">Wordle</h1>
	<c:if test="${Attempts > 0}">
		<form style="text-align: center;" action="/check" method="post">
			<input placeholder="Introduce tu intento" type="text" name="word" id="word" style="padding: 10px; border-radius: 5px; border: none; margin-right: 10px; width: 300px; font-size: 18px;">
		
			<input type="submit" class="rounded-button" value="Comprobar" >
		</form>
	</c:if>
	<c:if test="${Attempts <= 0}">
		<h2 style="color: red; text-align: center; text-align: center; margin-top: 50px; margin-bottom: 50px; font-size: 24px;">No tienes más intentos</h2>
	</c:if>
	<div id="history-div" style="background-color: #000; padding: 20px; margin-top: 50px; margin-bottom: 50px;">
		<c:forEach var="history" items="${history}">
			<h2 class="font-weight-bold" style="color: white; font-size: 24px; margin-bottom: 10px;">${history}</h2>
		</c:forEach>
		<div style="display: flex; flex-wrap: wrap;">
			<c:forEach var="word" items="${word}">
				<c:if test="${word.correcto}">
					<c:if test="${word.posicion == word.posicionCorrecta}">
						<h2 style="text-align: center; color: green; font-weight: bold; font-size: 36px; margin-right: 10px; margin-bottom: 10px;">${word.palabraPorLetras}</h2>
					</c:if>
					<c:if test="${word.posicion != word.posicionCorrecta}">
						<h2 style="text-align: center; color: yellow; font-weight: bold; font-size: 36px; margin-right: 10px; margin-bottom: 10px;">${word.palabraPorLetras}</h2>
					</c:if>
				</c:if>
				<c:if test="${word.correcto == false}">
					<h2 style="text-align: center; color: red; font-weight: bold; font-size: 36px; margin-right: 10px; margin-bottom: 10px;">${word.palabraPorLetras}</h2>
				</c:if>
			</c:forEach>
		</div>
	</div>
	
</body>

</html>