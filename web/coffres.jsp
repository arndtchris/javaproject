<%@ page import="java.util.ArrayList" %>
<%@ page import="javacesi.AgenceXML" %>
<%@ page import="javacesi.OperationXML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:simple_layout>
<jsp:body>
  <div>
      <h1>Bienvenue cher client !</h1>

      <p>${requestScope.message}</p>
      <c:forEach items="${requestScope.agences}" var="agence">
      Adresse : ${agence.adresseEtab}
      </c:forEach>
  </div>

</jsp:body>

</t:simple_layout>


