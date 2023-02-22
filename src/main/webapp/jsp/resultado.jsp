<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib uri="http://www.springframework.org/tags/form"
prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Resultado</title>
    <link
      href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
      rel="stylesheet"
    />
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
      }

      h1 {
        font-size: 36px;
        color: #2c3e50;
        margin-top: 50px;
        text-align: center;
      }
      h4{
        font-size: 36px;
        color: #2c3e50;
        margin-top: 50px;
        text-align: center;
      }

      .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
      }
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
    </style>
  </head>
  <body>
    <div class="container">
      <h1>felicidades has encontrado la palabra con ${Attempts} intentos restantes</h1>
    <form style="justify-content: center;" action="/search" method="post">
      <input type="number" placeholder="Search" name="number", id="number">
      <input type="submit" class="rounded-button" value="Buscar" >
      
  </form>
<br>
  <c:if test="${pos != null}">
      <h4>en el intento ${pos} introdujiste la palabra:</h4> <h2>${word}</h2>
  </c:if>
    </div>
  </body>
</html>
