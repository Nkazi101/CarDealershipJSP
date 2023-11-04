<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
    </head>

    <body>
        <jsp:include page="navbar.jsp"/>
        <c:choose>
           <c:when test="${not empty sessionScope.user}">
        <h1> Welcome, ${user.name} </h1>
    </c:when>
<c:otherwise>
        <h1>Welcome Guest!</h1>

    </c:otherwise>

    </c:choose>
    </body>
</html>