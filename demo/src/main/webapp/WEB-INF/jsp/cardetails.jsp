<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Details</title>

    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <p>${car.price}</p>
        <p> Description: ${car.description}</p>
        <p> Year: ${car.year}</p>
        <p>Mileage: ${car.mileage}</p>
        <p> Date of Purchase: ${car.dateOfPurchase}</p>
        <a href = "/cart/add/${car.id}">Add to Cart</a>
    </body>
</html>