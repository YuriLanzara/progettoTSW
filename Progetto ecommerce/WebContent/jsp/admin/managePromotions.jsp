<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Gestione Promozioni - EcommerceAdvanced</title>
    <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
    <%@ include file="../fragments/header.jsp" %>
    <div class="content">
        <h2>Gestione Promozioni</h2>
        <c:if test="${not empty param.message}">
            <p class="message">${param.message}</p>
        </c:if>
        <h3>Aggiungi Nuova Promozione</h3>
        <form action="../../AdminPromotionServlet" method="post">
            <input type="hidden" name="action" value="addPromotion">
            <label for="title">Titolo:</label>
            <input type="text" id="title" name="title" required>
            <br>
            <label for="description">Descrizione:</label>
            <textarea id="description" name="description" required></textarea>
            <br>
            <label for="discount">Sconto (%):</label>
            <input type="number" step="0.01" id="discount" name="discount" required>
            <br>
            <button type="submit">Aggiungi Promozione</button>
        </form>
        <h3>Elenco Promozioni</h3>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Titolo</th>
                    <th>Descrizione</th>
                    <th>Sconto</th>
                    <th>Azioni</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="promo" items="${promotions}">
                    <tr>
                        <td>${promo.id}</td>
                        <td>${promo.title}</td>
                        <td>${promo.description}</td>
                        <td>${promo.discount}%</td>
                        <td>
                            <!-- Azioni per eventuale aggiornamento/eliminazione -->
                            <form action="../../AdminPromotionServlet" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="deletePromotion">
                                <input type="hidden" name="id" value="${promo.id}">
                                <button type="submit">Elimina</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="../fragments/footer.jsp" %>
</body>
</html>
