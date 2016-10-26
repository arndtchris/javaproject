package Controllers;

import javacesi.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by chris on 25/10/2016.
 */
@WebServlet(name = "FraisController")
public class FraisController extends HttpServlet implements Filter {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typecoffre = request.getParameter("typecoffre");
        String periodeLocation = request.getParameter("periodeLocation");
        String prixPeriode = request.getParameter("prixPeriode");
        String devise = request.getParameter("devise");
        String idFrais = request.getParameter("idFrais");

        String relativeWebPath = "outputs/Cataloguefrais2016.xml";
        String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);

        FraisXML fr = new FraisXML(typecoffre,periodeLocation,prixPeriode,devise);

        if(idFrais != null && idFrais != null)
        {
            fr.IdOperation = idFrais;
        }

        ArrayList<FraisXML> lesFraisXML = new Parse().insertFrais(absoluteDiskPath,fr);
        ArrayList<Frais> lesFrais = new ArrayList<Frais>();

        for (FraisXML f : lesFraisXML)
        {
            lesFrais.add(new Frais(f));
        }

        request.setAttribute("lesfrais", lesFrais);

        request.getRequestDispatcher("frais.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fraisID = request.getParameter("fraisID");

        String relativeWebPath = "outputs/Cataloguefrais2016.xml";
        String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);

        ArrayList<FraisXML> lesFraisXML = new Parse().parseFrais(absoluteDiskPath);
        ArrayList<Frais> lesFrais = new ArrayList<Frais>();

        for (FraisXML f : lesFraisXML)
        {
            lesFrais.add(new Frais(f));
        }

        if(fraisID != null && fraisID != "")
        {
            Frais fraisToEdit = new Parse().fraisById(absoluteDiskPath,fraisID);
            request.setAttribute("fraisToEdit", fraisToEdit);
        }

        request.setAttribute("lesfrais", lesFrais);


        request.getRequestDispatcher("frais.jsp").forward(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getServletPath();
        String fraisID = "";

        String relativeWebPath = "outputs/Cataloguefrais2016.xml";
        String absoluteDiskPath = servletRequest.getServletContext().getRealPath(relativeWebPath);

        if( url.toLowerCase().contains("/supprimerFrais".toLowerCase()) ){
            fraisID = request.getParameter("fraisID");
        }

        new Parse().supprimeFrais(absoluteDiskPath,fraisID);

        response.sendRedirect("/frais");
    }
}
