<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>EcommerceAdvanced - Home</title>
    <link rel="stylesheet" href="../styles/style.css">
    <script src="../scripts/ajaxCart.js"></script>
</head>
<body>
    <%@ include file="fragments/header.jsp" %>
    <div class="content">
        <h1>Benvenuto in EcommerceAdvanced</h1>
        <div class="product-list">
            <!-- Generazione dinamica tramite JSTL; l'attributo 'products' va impostato dal controller -->
            <c:forEach var="product" items="${products}">
                <div class="product">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <p>Prezzo: €${product.price}</p>
                    <button class="add-to-cart" data-product-id="${product.id}">Aggiungi al Carrello</button>
                </div>
            </c:forEach>
        </div>
    </div>
    <%@ include file="fragments/footer.jsp" %>
</body>
</html>
