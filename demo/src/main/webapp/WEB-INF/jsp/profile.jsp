<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <h1>Profile</h1>
        <c:if test="${not empty sessionScope.user}">
            <h2> ${user.name} </h2>
            <h2> ${user.email} </h2>
            <h2> ${user.phoneNumber} </h2>
        </c:if>
    </body>
</html>