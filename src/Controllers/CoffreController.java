package Controllers;
import javacesi.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Amanite on 24/10/2016.
 */
public class CoffreController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException {
        this.processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
        String path = req.getServletPath();
        switch (path) {
            case "/enregistreCoffre":
                this.enregistreCoffre(req, resp, Integer.parseInt(req.getParameter("id_client")));
                break;
            default:
                req.getRequestDispatcher("coffres.jsp").forward(req, resp);
                break;
        }
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if(Objects.equals(path, "/afficheCoffres")) {
            this.afficheCoffre(req, resp);
        }
        if( path.toLowerCase().contains("/ajoutCoffre".toLowerCase()) ){
            this.vueAjoutCoffre(req, resp);
        }
    }

    public void afficheCoffre(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String relativeWebPath = "outputs/banque.xml";
        String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        ArrayList<Agence> ag = new Parse().parseAgence(absoluteDiskPath);
        req.setAttribute("agences", ag);
        req.setAttribute("title", "Liste des coffres");
        req.getRequestDispatcher("coffres.jsp").forward(req, resp);
    }

    public void vueAjoutCoffre(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Ajouter un coffre");
        RequestDispatcher RequetsDispatcherObj = req.getRequestDispatcher("addCoffre.jsp");
        RequetsDispatcherObj.forward(req, resp);
    }

    public void enregistreCoffre(HttpServletRequest req, HttpServletResponse resp, int id_client) throws ServletException, IOException {
        String relativeWebPath = "outputs/banque.xml";
        String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        ArrayList<Agence> ag = new Parse().parseAgence(absoluteDiskPath);

        for (Agence agence : ag) {
            for (ClientBanque client : agence.getClients()) {
                if(client.getIdClient() == id_client)
                {
                    Coffre c = new Coffre();
                    c.setTypeCoffre(req.getParameter("TypeCoffre"));
                    c.setLocalisation(req.getParameter("Localisation"));
                    c.setTypeSecurite(req.getParameter("TypeSecurite"));
                    req.getParameter("Default");
                    client.addCoffre(c);
                }
            }
        }
        req.setAttribute("agences", ag);
        req.setAttribute("title", "Liste des coffres");
        req.getRequestDispatcher("coffres.jsp").forward(req, resp);
    }
}
