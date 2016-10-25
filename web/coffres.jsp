<%@ page import="java.util.ArrayList" %>
<%@ page import="javacesi.AgenceXML" %>
<%@ page import="javacesi.OperationXML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:simple_layout>
<jsp:body>
  <div>
      <h1>${title}</h1>

      <c:forEach items="${requestScope.agences}" var="agence">
          <div class="Agence">
              <p>Adresse : ${agence.adresseEtab}</p>
              <p>Coffres</p>
              <c:forEach items="${agence.CoffresXML}" var="agence">
                  <div class="Coffre">

                  </div>
              </c:forEach>
          </div>
      </c:forEach>
  </div>

</jsp:body>

</t:simple_layout>


