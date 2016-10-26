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
                  <h2>${agence.nomEtab} ${agence.idAgence}</h2>
                  <p>Adresse : ${agence.adresseEtab}</p>
              </div>
              <c:forEach items="${agence.clients}" var="client">
                  <div class="col-lg-3">
                      <div class="Client">
                          <h3>${client.prenom} ${client.nom}</h3>
                          <p>${client.adresse}</p>
                          <ul class="ClientCoffre">
                              <li> + <a href="${pageContext.request.contextPath}/ajoutCoffre/${client.idClient}">Ajouter un coffre</a></li>
                              <c:forEach items="${client.coffres}" var="coffre">
                                  <li>${coffre.typeCoffre}</li>
                              </c:forEach>
                          </ul>
                      </div>
                  </div>
              </c:forEach>
          </div>
      </c:forEach>
  </div>

</jsp:body>

</t:simple_layout>


