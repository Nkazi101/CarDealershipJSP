<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up</title>
        
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <form action="/sign-up" method="post">
            <input type="text" name="name" placeholder="Name" />
            <input type="text" name="email" placeholder="Email" />
            <input type="password" name="password" placeholder="Password" />
            <input type="number" name="phoneNumber" placeholder="Phone Number" />
            
            <button type="submit">Sign Up</button>
        </form>
    </body>
</html>