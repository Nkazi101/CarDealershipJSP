<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
   <head>
    <link href="<c:url value='/css/navbar.css'/>" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
   </head>
   <body>

 <div class="navbar">

    <a href="/">Home</a>
    <a href="/cars">Cars</a>

    <c:if test="${empty sessionScope.user}">
        <a href="/sign-in">Sign In</a>
        <a href="/sign-up">Sign Up</a>
</c:if>
 
<c:choose>
    <c:when test="${sessionScope.userType == 'Buyer'}">
        <!-- <a href="/cars">Cars</a> -->
        <a href="/transactions">My Transactions</a>
        <a href="/profile/{id}">Profile</a>
        <a href="/cart">Cart</a>
        
    </c:when>
    <c:when test="${sessionScope.userType == 'Seller'}">
        <a href="/addcar">Add a Car</a>
        <a href="/transactions">View Transactions</a>
        <a href="/updatecar">Update a Car</a>
    </c:when>
</c:choose>
<c:if test="${not empty sessionScope.user}">
    <a href="/logout">Logout</a>
</c:if>
 </div>
   </body>
</html>