<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 25/10/2016
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:simple_layout>
    <jsp:attribute name="title">
      Gestion des frais
    </jsp:attribute>

<jsp:body>
    <p>La page des frais</p>

    <d:forEach items="${operations}" var="op">
        <tr>
            <td>Type Coffre: <d:out value="${op.TypeCoffre}"/></td>
            <td>Période: <d:out value="${op.PeriodeLocation}"/></td>
        </tr>
    </d:forEach>
</jsp:body>
</t:simple_layout>