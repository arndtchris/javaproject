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

<t:simple_layout>
    <jsp:attribute name="title">
      Gestion des frais
    </jsp:attribute>

<jsp:body>
    <h1>Catalogue des frais</h1>

    <form action="frais" method="post">
        Type de coffre : <input type="text" name="typecoffre"> <br/>
        Période de location : <input type="text" name="periodeLocation"> <br/>
        Tarif de la période : <input type="text" name="prixPeriode"> <br/>
        Devise : <input type="text" name="devise"> <br/>
        <input type="submit" />
    </form>

    <div id="AgenceContainer" class="row">
            <d:forEach items="${requestScope.lesfrais}" var="f">
                <div class="col-lg-3">
                    <div class="Client">
                        <h3>${f.typecoffre}</h3>
                        <p>${f.periodeLocation} : ${f.prixPeriode} ${f.devise} </p>
                    </div>
                </div>
            </d:forEach>
    </div>
</jsp:body>
</t:simple_layout>