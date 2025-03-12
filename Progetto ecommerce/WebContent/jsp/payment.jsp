<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Pagamento - EcommerceAdvanced</title>
    <link rel="stylesheet" href="../styles/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp" %>
    <div class="content">
        <h2>Pagamento</h2>
        <c:if test="${not empty param.message}">
            <p class="message">${param.message}</p>
        </c:if>
        <c:if test="${not empty param.error}">
            <p class="error">${param.error}</p>
        </c:if>
        <p>Dettagli del pagamento verranno visualizzati qui.</p>
        <a href="orders.jsp">Visualizza i tuoi ordini</a>
    </div>
    <%@ include file="fragments/footer.jsp" %>
</body>
</html>
