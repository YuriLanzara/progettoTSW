<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Login Admin - EcommerceAdvanced</title>
    <link rel="stylesheet" href="../styles/style.css">
</head>
<body>
    <div class="header">
        <h2>Login Amministratore</h2>
    </div>
    <div class="content">
        <form action="../AdminLoginServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <button type="submit">Accedi</button>
        </form>
        <c:if test="${not empty param.error}">
            <p class="error">${param.error}</p>
        </c:if>
    </div>
    <div class="footer">
        <p>&copy; 2025 EcommerceAdvanced</p>
    </div>
</body>
</html>
