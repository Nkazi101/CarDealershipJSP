<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Sign In</title>
        
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <form action="/sign-in" method="post">
            <input type="text" name="email" placeholder="Email" />
            <input type="password" name="password" placeholder="Password" />
            <button type="submit">Sign In</button>
        </form>
      
    </body>
</html>