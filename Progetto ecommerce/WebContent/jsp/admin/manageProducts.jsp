<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Gestione Prodotti - EcommerceAdvanced</title>
    <link rel="stylesheet" href="../../styles/style.css">
</head>
<body>
    <%@ include file="../fragments/header.jsp" %>
    <div class="content">
        <h2>Gestione Prodotti</h2>
        <c:if test="${not empty param.message}">
            <p class="message">${param.message}</p>
        </c:if>
        <h3>Aggiungi Nuovo Prodotto</h3>
        <form action="../../AdminServlet" method="post">
            <input type="hidden" name="action" value="addProduct">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" required>
            <br>
            <label for="price">Prezzo:</label>
            <input type="number" step="0.01" id="price" name="price" required>
            <br>
            <label for="description">Descrizione:</label>
            <textarea id="description" name="description" required></textarea>
            <br>
            <button type="submit">Aggiungi Prodotto</button>
        </form>
        <h3>Elenco Prodotti</h3>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Prezzo</th>
                    <th>Descrizione</th>
                    <th>Azioni</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>€${product.price}</td>
                        <td>${product.description}</td>
                        <td>
                            <form action="../../AdminServlet" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="updateProduct">
                                <input type="hidden" name="id" value="${product.id}">
                                <input type="text" name="name" value="${product.name}" required>
                                <input type="number" step="0.01" name="price" value="${product.price}" required>
                                <input type="text" name="description" value="${product.description}" required>
                                <button type="submit">Aggiorna</button>
                            </form>
                            <form action="../../AdminServlet" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="deleteProduct">
                                <input type="hidden" name="id" value="${product.id}">
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
