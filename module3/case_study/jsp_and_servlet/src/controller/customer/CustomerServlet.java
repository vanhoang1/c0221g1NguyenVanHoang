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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new ICustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                delCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
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
    //- do post

    private void delCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
         int id = Integer.parseInt(request.getParameter("id"));
         String nameCustomer =request.getParameter("name");
        Date dateOfBirth = null;
        try {
            dateOfBirth = formatter.parse(request.getParameter("birthDay"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String soCMND =request.getParameter("soCMND");
         String soDT =request.getParameter("phone");
         String address=request.getParameter("address");
         String email =request.getParameter("email");
         int typeOfCustomer = Integer.parseInt(request.getParameter("typeOfCustomer"));
         Customer customer = new Customer(id,nameCustomer,dateOfBirth,soCMND,soDT,address,email,typeOfCustomer);
         boolean check= customerService.update(id,customer);
         if(check) request.setAttribute("message","Cập nhật thành công"); else request.setAttribute("message","Cập nhật thất bại");
        try {
            request.getRequestDispatcher("view/customer/customer-edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
    }
}
