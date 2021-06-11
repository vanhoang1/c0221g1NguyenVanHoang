package controller.student.customer;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.repository.customer.CustomerTypeRepository;
import model.service.api.Service;
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
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private Service<Customer> customerService = new ICustomerService();
    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

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

            default:
                listCustomer(request, response);
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
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
                delCustomer(request, response);
                break;
            case "view":
                showInfomationForm(request, response);
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
        List<Customer> list = customerService.findAll();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/customer/customer-list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Customer> list = customerService.findByName(search);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/customer/customer-list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showInfomationForm(HttpServletRequest request, HttpServletResponse response) {
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        List<CustomerType> typeList = customerTypeRepository.getAll();
        request.setAttribute("typeList", typeList);
        request.setAttribute("customer", customer);
        try {
            request.getRequestDispatcher("view/customer/customer-edit.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> typeList = customerTypeRepository.getAll();
        request.setAttribute("typeList", typeList);
        try {
            request.getRequestDispatcher("view/customer/customer-create.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //- do post

    private void delCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = customerService.remove(id);
        if (check) request.setAttribute("message", "Xóa thành công");
        else {
            request.setAttribute("message", "Xóa thất bại");
            request.setAttribute("err", true);
        }
        listCustomer(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            int id = Integer.parseInt(request.getParameter("id"));
            String nameCustomer = request.getParameter("name");
            Date dateOfBirth = null;
            try {
                dateOfBirth = formatter.parse(request.getParameter("birthDay"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String soCMND = request.getParameter("soCMND");
            String soDT = request.getParameter("phone");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String maKhachHang = request.getParameter("maKhachHang");
            int typeOfCustomer = Integer.parseInt(request.getParameter("typeOfCustomer"));
            CustomerType customerType = customerTypeRepository.get(typeOfCustomer);
            int gender = Integer.parseInt(request.getParameter("gender"));
            Customer customer = new Customer(id, nameCustomer, dateOfBirth, soCMND, gender, soDT, maKhachHang, address, email, customerType);
            request.setAttribute("customer", customer);
            List<CustomerType> typeList = customerTypeRepository.getAll();
            request.setAttribute("typeList", typeList);
            List<String> list = customerService.update(id, customer);
            if (list.isEmpty()) request.setAttribute("message", "Tạo mới thành công");
            else {
                request.setAttribute("message",list);
            }
        } catch (Exception e) {
            request.setAttribute("err", true);
            request.setAttribute("message", e.getMessage());
        }

        try {
            request.getRequestDispatcher("view/customer/customer-edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            String nameCustomer = request.getParameter("name");
            Date dateOfBirth = formatter.parse(request.getParameter("birthDay"));
            int gender = Integer.parseInt(request.getParameter("gender"));
            String soCMND = request.getParameter("soCMND");
            String maKhachHang = request.getParameter("maKhachHang");
            String soDT = request.getParameter("phone");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            int typeOfCustomer = Integer.parseInt(request.getParameter("typeOfCustomer"));
            CustomerType customerType = customerTypeRepository.get(typeOfCustomer);
            Customer customer = new Customer(nameCustomer, dateOfBirth, soCMND, gender, soDT, maKhachHang, address, email, customerType);
            List<String> list = customerService.save(customer);
            List<CustomerType> typeList = customerTypeRepository.getAll();
            request.setAttribute("typeList", typeList);
            if (list.isEmpty()) request.setAttribute("message", "Tạo mới thành công");
            else {
                request.setAttribute("err", true);
                request.setAttribute("message",list);
            }
        } catch (Exception e) {
            request.setAttribute("err", true);
            request.setAttribute("message", e.getMessage());
        }

        try {
            request.getRequestDispatcher("view/customer/customer-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
