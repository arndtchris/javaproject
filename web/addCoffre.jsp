<%@ page import="java.util.ArrayList" %>
<%@ page import="javacesi.AgenceXML" %>
<%@ page import="javacesi.OperationXML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:simple_layout>
<jsp:body>

    <h1>${title}</h1>
    <form id="CoffreFormulaire" method="POST" action="${pageContext.request.contextPath}/enregistreCoffre">

        <div class="row">
            <label for="TypeCoffre" class="col-lg-6">Type de Coffre</label>
            <input id="TypeCoffre" type="text" class="col-lg-6" name="TypeCoffre">
            <div class="clr"></div>
        </div>

        <div class="row">
            <label for="Localisation" class="col-lg-6">Localisation</label>
            <input id="Localisation" type="text" class="col-lg-6" name="Localisation">
            <div class="clr"></div>
        </div>

        <div class="row">
            <label for="TypeSecurite" class="col-lg-6">Type de sécurité</label>
            <input id="TypeSecurite" type="text" class="col-lg-6" name="TypeSecurite">
            <div class="clr"></div>
        </div>

        <div class="row">
            <label for="Default" class="col-lg-6">Indiquer comme coffre par défaut</label>
            <input id="Default" type="checkbox" class="col-lg-6" name="Default">
            <div class="clr"></div>
        </div>

        <input type="hidden" name="id_client" value="${id_client}">

        <input type="submit" value="Ajouter">
        <a class="retour" href="${pageContext.request.contextPath}/afficheCoffres">Retour</a>
    </form>

</jsp:body>

</t:simple_layout>