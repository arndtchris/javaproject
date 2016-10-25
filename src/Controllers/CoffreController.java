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
    private static final String SERLVET = "/afficheCoffres";
    private static final String SERLVET_ONE = "/afficheAutre";
    private static final String SERLVET_TWO = "HelloServletTwo";

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
            case SERLVET:
                String relativeWebPath = "outputs/banque.xml";
                String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
                ArrayList<Agence> ag = new Parse().parseAgence(absoluteDiskPath);
                req.setAttribute("agences", ag);
                req.setAttribute("title", "Liste des coffres");
                req.getRequestDispatcher("coffres.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("message", "Affiche autre");
                req.getRequestDispatcher("coffres.jsp").forward(req, resp);
                break;
        }
    }
}
