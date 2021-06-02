package controller.employee;

import model.bean.Employee;
import model.service.api.EmployeeService;
import model.service.impl.IEmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet" ,urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new IEmployeeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;

            default:
                listEmployee(request, response);
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
                delEmployee(request, response);
                break;
            case "view":
                showInfomationForm(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }


    // do post
    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> list = employeeService.findAll();
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("view/employee/employee-list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
    }
    //do get
    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showInfomationForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
    }
}
