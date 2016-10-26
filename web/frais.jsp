<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 25/10/2016
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:simple_layout>
    <jsp:attribute name="title">
      Gestion des frais
    </jsp:attribute>

<jsp:body>
    <h1>Catalogue des frais</h1>

    <form action="frais" method="post">
        <input type="hidden" name="idFrais" value=${fraisToEdit.idFrais}>
        Type de coffre : <input type="text" name="typecoffre" value=${fraisToEdit.typecoffre}> <br/>
        Période de location : <input type="text" name="periodeLocation" value=${fraisToEdit.periodeLocation}> <br/>
        Tarif de la période : <input type="text" name="prixPeriode" value=${fraisToEdit.prixPeriode}> <br/>
        Devise : <input type="text" name="devise" value=${fraisToEdit.devise}> <br/>
        <input type="submit" />
    </form>

    <div id="AgenceContainer" class="row">
            <d:forEach items="${requestScope.lesfrais}" var="f">
                <div class="col-lg-3">
                    <div class="Client">
                        <h3>${f.typecoffre}</h3>
                        <p>${f.periodeLocation} : ${f.prixPeriode} ${f.devise} </p>
                        <p>id : ${f.idFrais} </p>
                        <div>
                            <c:set var="editURL">
                                <c:url value="frais">
                                    <c:param name="fraisID" value="${f.idFrais}"/>
                                </c:url>
                            </c:set>
                            <a class="btn btn-warning fa fa-pencil" href="${editURL}" role="button">Modifier</a>
                        </div>
                    </div>

                </div>
            </d:forEach>
    </div>
</jsp:body>
</t:simple_layout>