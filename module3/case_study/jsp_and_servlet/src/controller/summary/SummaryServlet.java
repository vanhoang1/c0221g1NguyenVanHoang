package controller.summary;

import model.bean.Summary;
import model.service.impl.ISummaryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SummaryServlet" ,urlPatterns = "/summary")
public class SummaryServlet extends HttpServlet {
    ISummaryService summaryService = new ISummaryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Summary> list = summaryService.findAll();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/summary/summary-customer-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
