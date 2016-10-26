<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:simple_layout>
    <jsp:body>
        <div class="row">
            <h1>${title}</h1>
            <div class="Agence row">
                <div class="col-lg-3">
                    <div class="Coffre">
                        <h3>${coffre.typeCoffre}</h3>
                        <p>Contenu : ${coffre.contenu}</p>
                        <p>Localisation : ${coffre.piece}</p>
                        <p>Début de réservation : ${coffre.dateOuverture}</p>
                        <p>Fin de réservation : ${coffre.dateFermeture}</p>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>

</t:simple_layout>