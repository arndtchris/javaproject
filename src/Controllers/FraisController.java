package Controllers;

import javacesi.OperationXML;
import javacesi.Parse;

import javax.servlet.ServletException;
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
public class FraisController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<OperationXML> lesOperations = new Parse().parseOperation();

        request.getRequestDispatcher("/frais.jsp").forward(request, response);
    }
}
