<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <link href="<c:url value='/css/availablecars.css'/>" rel="stylesheet">
    </head>
        <body>
            <jsp:include page="navbar.jsp"/>

            <form action="/searchCar" method="get">
                <input type="text" name="makeModel" placeholder="Enter car model" />
                <button type="submit">Search</button>
            </form>

            <h1>Available Cars</h1>
            <div class="car-list">
                <c:forEach var="car" items="${cars}">
                    <a href="/${car.id}">
                    <div class = "car-item" >
                       
                        <img src="${car.pictureUrl}" alt="Car Photo"/>
                   
                       
                        <p>${car.manufacturerName} - ${car.makeModel} - ${car.year}</p>
                        
                      
   
                    </div>
                </a>
                </c:forEach>
            </div>
        </body>
    
</html>