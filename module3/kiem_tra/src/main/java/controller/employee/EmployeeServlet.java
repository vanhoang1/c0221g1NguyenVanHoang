package controller.employee;

import model.bean.exam.Employee;
import model.service.impl.IEmployeeService;

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

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new IEmployeeService();

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
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void delEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check= employeeService.remove(id);
        if (check) request.setAttribute("message", "Delete successfully");
        else {
            request.setAttribute("message", "Delete fail");
            request.setAttribute("err", true);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);
        try {
            request.getRequestDispatcher("view/employee/employee-edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/employee/employee-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> list = employeeService.findAll();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/employee/employee-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date birthDay = null;
        try {
            birthDay = formatter.parse(request.getParameter("birthDay"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Employee employee = new Employee(id, name, birthDay);
        List<String> errList = employeeService.update(id, employee);
        request.setAttribute("employee", employee);
        if (errList.size() == 0) {
            request.setAttribute("message", "Create successfully");
        } else {
            request.setAttribute("errList", errList);
        }
        try {
            request.getRequestDispatcher("view/employee/employee-edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        String name = request.getParameter("name");
        Date birthDay = null;
        try {
            birthDay = formatter.parse(request.getParameter("birthDay"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Employee employee = new Employee( name, birthDay);
        List<String> errList = employeeService.save(employee);
        request.setAttribute("employee", employee);
        if (errList.size() == 0) {
            request.setAttribute("message", "Edit successfully");
        } else {
            request.setAttribute("errList", errList);
        }
        try {
            request.getRequestDispatcher("view/employee/employee-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
