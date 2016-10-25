package Controllers;
import javacesi.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Amanite on 24/10/2016.
 */
public class CoffreController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws IOException,ServletException{
        this.processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException,ServletException{
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/afficheCoffres":
                this.afficheCoffre(req, resp);
                break;
            case "/ajoutCoffre":
                this.vueAjoutCoffre(req, resp);
                break;
            default:
                req.setAttribute("message", "Affiche autre");
                req.getRequestDispatcher("coffres.jsp").forward(req, resp);
                break;
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

    public void vueAjoutCoffre(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setAttribute("title", "Ajouter un coffre");
        req.getRequestDispatcher("addCoffre.jsp").forward(req, resp);
    }
}
