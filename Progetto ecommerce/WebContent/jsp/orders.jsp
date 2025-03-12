<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>I Miei Ordini - EcommerceAdvanced</title>
    <link rel="stylesheet" href="../styles/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp" %>
    <div class="content">
        <h2>Ordini Effettuati</h2>
        <c:if test="${empty orders}">
            <p>Non hai effettuato ordini.</p>
        </c:if>
        <c:if test="${not empty orders}">
            <table>
                <thead>
                    <tr>
                        <th>ID Ordine</th>
                        <th>Utente</th>
                        <th>Status</th>
                        <th>Dettagli</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.user}</td>
                            <td>${order.status}</td>
                            <td>
                                <a href="orderDetails.jsp?orderId=${order.id}">Visualizza</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
    <%@ include file="fragments/footer.jsp" %>
</body>
</html>
