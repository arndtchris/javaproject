<%--
  Created by IntelliJ IDEA.
  User: Mickaël Cimbaluria
  Date: 25/10/2016
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:simple_layout>
    <jsp:body>
        <p><h1>Se connecter</h1></p>
        <table>
            <tr>
                <td>Nom :</td>
                <td><input name="nom"/></td>
            </tr>
            <tr>
                <td>Prénom :</td>
                <td><input name="prenom"/></td>
            </tr>
        </table>
        <br />
        <button onclick="function checkLogin () {


        }">S'identifier</button>
    </jsp:body>
</t:simple_layout>