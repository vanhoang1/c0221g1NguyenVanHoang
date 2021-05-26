import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet " , urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String productDescription =request.getParameter("productDescription");
            double listPrice= Double.parseDouble(request.getParameter("listPrice"));
            double discountPercent= Double.parseDouble(request.getParameter("discountPercent"));
            double amount= listPrice * discountPercent * 0.01;
            listPrice = listPrice- amount;
            request.setAttribute("productDescription",productDescription);
            request.setAttribute("amount",amount);
            request.setAttribute("dPrice",listPrice);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
            requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
