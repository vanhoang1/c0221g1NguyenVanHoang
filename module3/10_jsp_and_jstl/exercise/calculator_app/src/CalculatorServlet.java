import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet ", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double result = 0;
        try {
            double first = Double.parseDouble(request.getParameter("first"));
            double second = Double.parseDouble(request.getParameter("second"));
            String operator = request.getParameter("operation");
            switch (operator) {
                case "add": {
                    result = first + second;
                    break;
                }

                case "sub": {
                    result = first - second;

                    break;
                }

                case "multi": {
                    result = first * second;
                    break;
                }

                case "div": {
                    if (second == 0) throw new Exception("dividing by 0");
                    result = first / second;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
        } catch (Exception e) {
            request.setAttribute("result", " Error " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        request.setAttribute("result", "Kết quả " + result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
