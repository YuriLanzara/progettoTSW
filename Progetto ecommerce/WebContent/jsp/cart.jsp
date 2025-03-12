<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Carrello - EcommerceAdvanced</title>
    <link rel="stylesheet" href="../styles/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp" %>
    <div class="content">
        <h2>Il tuo Carrello</h2>
        <c:if test="${empty sessionScope.cart}">
            <p>Il carrello è vuoto.</p>
        </c:if>
        <c:if test="${not empty sessionScope.cart}">
            <table>
                <thead>
                    <tr>
                        <th>Prodotto</th>
                        <th>Prezzo</th>
                        <th>Azione</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${sessionScope.cart}">
                        <tr>
                            <td>${product.name}</td>
                            <td>€${product.price}</td>
                            <td>
                                <form action="../CartServlet" method="post">
                                    <input type="hidden" name="action" value="remove">
                                    <input type="hidden" name="productId" value="${product.id}">
                                    <button type="submit">Rimuovi</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="../CartServlet" method="post">
                <input type="hidden" name="action" value="empty">
                <button type="submit">Svuota Carrello</button>
            </form>
            <form action="../OrderServlet" method="post">
                <button type="submit">Conferma Ordine</button>
            </form>
        </c:if>
    </div>
    <%@ include file="fragments/footer.jsp" %>
</body>
</html>
