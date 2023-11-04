<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <body>
        <jsp:include page="navbar.jsp"/>
        <h2>Your shopping cart</h2>
        <c:forEach var ="item" items = "${cartItems}">
            <p>${item.makeModel}</p>
            <p>${item.price}</p>
            <a href="/cart/remove/${item.id}">Remove</a>
        </c:forEach>
        <a href = "/checkout ">Proceed to Checkout</a>
    </body>
</html>