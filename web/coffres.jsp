<%@ page import="java.util.ArrayList" %>
<%@ page import="javacesi.AgenceXML" %>
<%@ page import="javacesi.OperationXML" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Amanite
  Date: 03/10/2016
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:simple_layout title="Accueil">
<jsp:body>

  <c:forEach items="${requestScope.agences}" var="agence">
      Adresse : ${agence.adresseEtab}
  </c:forEach>
  <div>

      ${requestScope.getAttribute("agences")}
      ${requestScope.message}
      <h1>Bienvenue cher client !</h1>
  </div>

</jsp:body>

</t:simple_layout>


