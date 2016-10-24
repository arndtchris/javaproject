package Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mickaël Cimbaluria on 24/10/2016.
 */
public class LogController extends HttpServlet {


    public void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }
}
