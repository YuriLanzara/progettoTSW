<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
    <img src="../images/logo.png" alt="Logo">
    <nav>
        <a href="index.jsp">Home</a>
        <a href="cart.jsp">Carrello (<span id="cartCount">0</span>)</a>
        <a href="orders.jsp">I Miei Ordini</a>
        <c:if test="${not empty sessionScope.adminToken}">
            <a href="admin/manageProducts.jsp">Admin</a>
        </c:if>
    </nav>
</div>
