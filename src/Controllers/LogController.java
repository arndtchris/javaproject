package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mickaël Cimbaluria on 24/10/2016.
 */
public class LogController extends HttpServlet {

    private String paramNom;
    private String paramPrenom;

    public void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.paramNom = "zero";
        this.paramPrenom = "zero";
        // Do required initialization
        request.setAttribute("message", "Se connecter");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws IOException,ServletException{
        this.init(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException,ServletException{
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        RequestDispatcher dispatcher = null;


        if(this.paramNom.equalsIgnoreCase(nom) && this.paramPrenom.equalsIgnoreCase(prenom)){
            dispatcher = request.getRequestDispatcher("/coffres.jsp");
        }else{
            dispatcher = request.getRequestDispatcher("/index.jsp");
        }
        dispatcher.forward(request, response);

    }
}
