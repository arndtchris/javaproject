<%--
  Created by IntelliJ IDEA.
  User: Mickaël Cimbaluria
  Date: 26/10/2016
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:simple_layout>
    <jsp:body>
<c:if test="${!empty sessionScope.sessionUtilisateur}">
    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
    <p class="succes"> <h1>Bonjour ${sessionScope.sessionUtilisateur.nom} ${sessionScope.sessionUtilisateur.prenom}</h1></p>
    <%-- ${sessionScope.sessionUtilisateur.idClient} --%>
</c:if>
    </jsp:body>
</t:simple_layout>