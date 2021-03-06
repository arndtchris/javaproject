package Controllers;
import javacesi.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Amanite on 24/10/2016.
 */
public class CoffreController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException {
        String path = req.getServletPath();
        if(Objects.equals(path, "/afficheAgences")) {
            this.afficheAgences(req, resp);
        }
        if( path.toLowerCase().contains("/ajoutCoffre".toLowerCase()) ){
            this.vueAjoutCoffre(req, resp);
        }
        if( path.toLowerCase().contains("/mesCoffres".toLowerCase()) ){
            this.mesCoffres(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
        String path = req.getServletPath();
        switch (path) {
            case "/enregistreCoffre":
                this.enregistreCoffre(req, resp, req.getParameter("id_client"));
                break;
            default:
                req.getRequestDispatcher("agences.jsp").forward(req, resp);
                break;
        }
    }

    public void afficheAgences(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String relativeWebPath = "outputs/banque.xml";
        String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        ArrayList<Agence> ag = new Parse().parseAgence(absoluteDiskPath);
        req.setAttribute("agences", ag);
        req.setAttribute("title", "Agences");
        req.getRequestDispatcher("agences.jsp").forward(req, resp);
    }

    public void vueAjoutCoffre(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Ajouter un coffre");
        RequestDispatcher RequetsDispatcherObj = req.getRequestDispatcher("addCoffre.jsp");
        RequetsDispatcherObj.forward(req, resp);
    }

    public void enregistreCoffre(HttpServletRequest req, HttpServletResponse resp, String id_client) throws ServletException, IOException {
        CoffreXML c = new CoffreXML();
        c.typeCoffre = req.getParameter("TypeCoffre") ;
        c.piece = req.getParameter("Piece");
        c.contenu = req.getParameter("Contenu");
        c.dateOuverture = req.getParameter("Debut");
        c.dateFermeture = req.getParameter("Fin");

        String relativeWebPath = "outputs/banque.xml";
        String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        ArrayList<Agence> ag = new Parse().ajouteCoffreAClient(absoluteDiskPath,id_client,c);
        req.setAttribute("agences", ag);
        req.setAttribute("title", "Liste des coffres");
        req.getRequestDispatcher("agences.jsp").forward(req, resp);
    }

    public void mesCoffres(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        ClientBanque SessionClient = (ClientBanque)session.getAttribute("sessionUtilisateur");
        if(SessionClient == null){
            resp.sendRedirect("/connexion");
        }else{
            int id_client = SessionClient.getIdClient();
            String relativeWebPath = "outputs/banque.xml";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            ArrayList<Agence> ag = new Parse().parseAgence(absoluteDiskPath);
            List<Coffre> coffres = new ArrayList<Coffre>();

            for (Agence agence : ag) {
                for (ClientBanque cl : agence.getClients()) {
                    if(cl.getIdClient() == id_client)
                    {
                        coffres = cl.getCoffres();
                    }
                }
            }
            req.setAttribute("coffres", coffres);
            req.setAttribute("title", "Liste des coffres");
            req.getRequestDispatcher("coffres.jsp").forward(req, resp);
        }

    }
}
