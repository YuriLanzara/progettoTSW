<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Dettagli Ordine - EcommerceAdvanced</title>
    <link rel="stylesheet" href="../styles/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp" %>
    <div class="content">
        <h2>Dettagli Ordine</h2>
        <c:if test="${empty order}">
            <p>Ordine non trovato.</p>
        </c:if>
        <c:if test="${not empty order}">
            <p><strong>ID Ordine:</strong> ${order.id}</p>
            <p><strong>Utente:</strong> ${order.user}</p>
            <p><strong>Status:</strong> ${order.status}</p>
            <h3>Prodotti Ordinati:</h3>
            <table>
                <thead>
                    <tr>
                        <th>Prodotto</th>
                        <th>Prezzo (al momento dell'acquisto)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${order.products}">
                        <tr>
                            <td>${product.name}</td>
                            <td>€${product.price}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <a href="orders.jsp">Torna agli ordini</a>
    </div>
    <%@ include file="fragments/footer.jsp" %>
</body>
</html>
