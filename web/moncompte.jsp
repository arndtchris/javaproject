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
    <p class="succes"> <h1>Bienvenue sur votre espace, ${sessionScope.sessionUtilisateur.nom} ${sessionScope.sessionUtilisateur.prenom}</h1></p>
    <%-- ${sessionScope.sessionUtilisateur.idClient} --%>
    <table align="center">

        <tr>
            <td>
                    <a href="/mesCoffres"><img src="images/coffre.jpg" width="350" height="250"/> <br />
                    > Vous pouvez consulter vos coffres</a><br/>
            </td>

            <td>
                    <a href="/afficheAgences"><img src="images/bank.jpg" width="350" height="250"/> <br />
                        > Vous pouvez consulter les agences</a><br/>
            </td>

            <td>
                    <a href="/frais"><img src="images/tirelire.jpg" width="350" height="250"/> <br />
                        > Vous pouvez consulter vos frais</a>
            </td>
        </tr>

    </table>


</c:if>
    </jsp:body>
</t:simple_layout>