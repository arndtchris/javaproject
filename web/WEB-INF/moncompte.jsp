<%--
  Created by IntelliJ IDEA.
  User: Mickaël Cimbaluria
  Date: 26/10/2016
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
    <c:if test="${!empty sessionScope.sessionUtilisateur}">
        <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
        <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.nom} + ${sessionScope.sessionUtilisateur.prenom}</p>
    </c:if>
</body>
</html>
