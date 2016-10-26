<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:simple_layout>
    <jsp:body>
        <div id="AgenceContainer" class="row">
            <h1>${title}</h1>

            <div class="Agence row">
                <c:forEach items="${requestScope.coffres}" var="coffre">
                    <div class="col-lg-3">
                        <div class="Coffre">
                            <h3>${coffre.typeCoffre}</h3>
                            <p>Contenu : ${coffre.contenu}</p>
                            <p>Localisation : ${coffre.piece}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </jsp:body>

</t:simple_layout>


