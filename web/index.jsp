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

        <form method="post" action="connexion">
            <fieldset>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <table>

                <tr>
                    <td>
                        <label for="nom">Nom <span class="requis">*</span></label>
                    </td>
                    <td>
                        <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
                    </td>
                <span class="erreur">${form.erreurs['nom']}</span>
                </tr>

                <tr>
                    <td>
                        <label for="prenom">Prénom <span class="requis">*</span></label>
                    </td>
                    <td>
                        <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                    </td>
                <span class="erreur">${form.erreurs['prenom']}</span>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Connexion" class="sansLabel" />
                    </td>
                </tr>
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
            </table>
        </form>

    </jsp:body>
</t:simple_layout>