<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Car</title>
</head>
<body>
    <h2>Edit Car</h2>
    <form action="<c:url value='/editcar' />" method="post">
        <input type="hidden" name="id" value="${car.id}"/>
        Manufacturer Name: <input type="text" name="manufacturerName" value="${car.manufacturerName}"/><br/>
        Make Model: <input type="text" name="makeModel" value="${car.makeModel}"/><br/>
        Date of Purchase: <input type="text" name="dateOfPurchase" value="${car.dateOfPurchase}"/><br/>
        Price: <input type="text" name="price" value="${car.price}"/><br/>
        Mileage: <input type="text" name="mileage" value="${car.mileage}"/><br/>
        Description: <textarea name="description">${car.description}</textarea><br/>
        Picture URL: <input type="text" name="pictureUrl" value="${car.pictureUrl}"/><br/>
        Year: <input type="number" name="year" value="${car.year}"/><br/>
        Bid Price: <input type="text" name="bidPrice" value="${car.bidPrice}"/><br/>
        <!-- <input type="checkbox" name="sold" ${car.sold ? 'checked' : ''}/> Sold<br/>
        <input type="checkbox" name="newUsed" ${car.newUsed ? 'checked' : ''}/> New Used<br/> -->
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
