<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Car</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <h1>Add Car</h1>
<form action="/addcar" method="POST">
    
    <label for="manufacturerName">Manufacturer Name:</label>
    <input type="text" id="manufacturerName" name="manufacturerName" required><br>
    
    <label for="dateOfPurchase">Date of Purchase:</label>
    <input type="date" id="dateOfPurchase" name="dateOfPurchase" required><br>
    
    <label for="price">Price:</label>
    <input type="text" id="price" name="price" pattern="\d+(\.\d{2})?" required><br>
    
    <label for="mileage">Mileage:</label>
    <input type="number" id="mileage" name="mileage" required><br>
    
    <label for="makeModel">Make & Model:</label>
    <input type="text" id="makeModel" name="makeModel" required><br>
    
    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br>
    
    <label for="pictureUrl">Picture URL:</label>
    <input type="url" id="pictureUrl" name="pictureUrl" required><br>
    
    <label for="sold">Sold:</label>
    <input type="checkbox" id="sold" name="sold"><br>
    
    <label for="bidPrice">Bid Price:</label>
    <input type="text" id="bidPrice" name="bidPrice" pattern="\d+(\.\d{2})?" required><br>
    
    <label for="year">Year:</label>
    <input type="number" id="year" name="year" required><br>
    
    <button type="submit">Submit</button>

</form>

</body>
</html>
