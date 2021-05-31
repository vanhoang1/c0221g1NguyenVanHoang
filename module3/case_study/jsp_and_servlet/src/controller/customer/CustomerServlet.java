package controller.customer;

import model.bean.Customer;
import model.service.api.CustomerService;
import model.service.impl.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new ICustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String search = request.getParameter("search");
        if(search!=null) action="search";
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showInfomationForm(request,response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }
//do-get
    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
     List<Customer> list= customerService.findAll();
     request.setAttribute("list",list);
     try {
         request.getRequestDispatcher("view/customer/customer-list.jsp").forward(request,response);
     }catch (Exception e){
         e.printStackTrace();
     }

    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showInfomationForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
       int id= Integer.parseInt( request.getParameter("id"));
       Customer customer= customerService.findById(id);
       request.setAttribute("customer",customer);
    try {
        request.getRequestDispatcher("view/customer/customer-edit.jsp").forward(request,response);
    }catch (Exception e){
        e.printStackTrace();
    }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {

    }
}
