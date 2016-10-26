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
            <label for="Piece" class="col-lg-6">Pièce</label>
            <input id="Piece" type="text" class="col-lg-6" name="Piece">
            <div class="clr"></div>
        </div>

        <div class="row">
            <label for="Contenu" class="col-lg-6">Contenu</label>
            <input id="Contenu" type="text" class="col-lg-6" name="Contenu">
            <div class="clr"></div>
        </div>

        <div class="row">
            <label for="Debut" class="col-lg-6">Début de réservation</label>
            <input id="Debut" type="text" class="col-lg-6" name="Debut">
            <div class="clr"></div>
        </div>

        <div class="row">
            <label for="Fin" class="col-lg-6">Fin de réservation</label>
            <input id="Fin" type="text" class="col-lg-6" name="Fin">
            <div class="clr"></div>
        </div>

        <input type="hidden" name="id_client" value="${id_client}">

        <input type="submit" value="Ajouter">
        <a class="retour" href="${pageContext.request.contextPath}/afficheAgences">Retour</a>
    </form>

</jsp:body>

</t:simple_layout>