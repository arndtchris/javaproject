<%@ page import="java.util.ArrayList" %>
<%@ page import="javacesi.AgenceXML" %>
<%@ page import="javacesi.OperationXML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:simple_layout>
<jsp:body>
  <div id="AgenceContainer" class="row">
      <h1>${title}</h1>

      <c:forEach items="${requestScope.agences}" var="agence">
          <div class="Agence row">
              <div class="col-lg-12">
                  <h2>Agence</h2>
                  <p>Adresse : ${agence.adresseEtab}</p>
              </div>
              <c:forEach items="${agence.clients}" var="client">
                  <div class="col-lg-3">
                      <div class="Client">
                          <h3>${client.prenom} ${client.nom}</h3>
                          <p>${client.adresse}</p>
                          <c:forEach items="${client.coffres}" var="coffre">
                              <ul class="ClientCoffre">
                              <li>${coffre.typeCoffre}</li>
                              <li> + <a>Ajouter un coffre</a></li>
                              </ul>
                          </c:forEach>
                      </div>
                  </div>
              </c:forEach>
          </div>
      </c:forEach>
  </div>

</jsp:body>

</t:simple_layout>


