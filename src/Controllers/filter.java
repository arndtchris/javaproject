package Controllers;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Amanite on 26/10/2016.
 */
public class filter implements Filter {

    private ArrayList<String> urlList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String url = request.getServletPath();

        if( url.toLowerCase().contains("/ajoutCoffre".toLowerCase()) ){
            int id = Integer.parseInt(url.replace("/ajoutCoffre/",""));
            req.setAttribute("title", "Ajouter un coffre");
            req.setAttribute("id_client", id);
            RequestDispatcher RequetsDispatcherObj = req.getServletContext().getRequestDispatcher("/addCoffre.jsp");
            RequetsDispatcherObj.forward(request, response);
        }

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }

}
