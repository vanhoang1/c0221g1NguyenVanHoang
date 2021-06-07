package controller.employee;

import model.bean.employee.Division;
import model.bean.employee.Education;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.repository.employee.DivisionRepository;
import model.repository.employee.EducationRepository;
import model.repository.employee.PositionRepository;
import model.service.api.Service;
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
    Service<Employee> employeeService = new IEmployeeService();
    PositionRepository positionRepository = new PositionRepository();
    EducationRepository educationRepository = new EducationRepository();
    DivisionRepository divisionRepository = new DivisionRepository();

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
        String nameEmployee = request.getParameter("name");
        int idPosition = Integer.parseInt(request.getParameter("idPosition"));
        int idEducation = Integer.parseInt(request.getParameter("idEducation"));
        int idDivision = Integer.parseInt(request.getParameter("idDivision"));
        Date birthDay = null;
        try {
            birthDay = formatter.parse(request.getParameter("birthDay"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        Position position = positionRepository.get(idPosition);
        Education education = educationRepository.get(idEducation);
        Division division = divisionRepository.get(idDivision);
        Employee employee = new Employee(nameEmployee, position, education, division, birthDay, idCard, salary, phone, address, email, username);
        boolean check = employeeService.update(id, employee);
        request.setAttribute("employee", employee);
        List<Position> positionList = positionRepository.getAll();
        List<Education> educationList = educationRepository.getAll();
        List<Division> divisionList = divisionRepository.getAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationList", educationList);
        request.setAttribute("divisionList", divisionList);
        if (check) request.setAttribute("message", "Cập nhật thành công");
        else {
            request.setAttribute("message", "Cập nhật thất bại");
            request.setAttribute("err", true);
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
        String nameEmployee = request.getParameter("name");
        int idPosition = Integer.parseInt(request.getParameter("idPosition"));
        int idEducation = Integer.parseInt(request.getParameter("idEducation"));
        int idDivision = Integer.parseInt(request.getParameter("idDivision"));
        Date birthDay = null;
        try {
            birthDay = formatter.parse(request.getParameter("birthDay"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        Position position = positionRepository.get(idPosition);
        Education education = educationRepository.get(idEducation);
        Division division = divisionRepository.get(idDivision);
        Employee employee = new Employee(nameEmployee, position, education, division, birthDay, idCard, salary, phone, address, email, username);
        boolean check = false;
        try {
            check = employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("employee", employee);
        List<Position> positionList = positionRepository.getAll();
        List<Education> educationList = educationRepository.getAll();
        List<Division> divisionList = divisionRepository.getAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationList", educationList);
        request.setAttribute("divisionList", divisionList);
        if (check) request.setAttribute("message", "tạo thành công");
        else {
            request.setAttribute("message", "tạo thất bại");
            request.setAttribute("err", true);
        }
        try {
            request.getRequestDispatcher("view/employee/employee-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //do get
    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Employee> list = employeeService.findByName(search);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/employee/employee-list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showInfomationForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = employeeService.remove(id);
        if (check) request.setAttribute("message", "Xóa thành công");
        else {
            request.setAttribute("message", "Xóa thất bại");
            request.setAttribute("err", true);
        }
        listEmployee(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);

        request.setAttribute("employee", employee);
        List<Position> positionList = positionRepository.getAll();
        List<Education> educationList = educationRepository.getAll();
        List<Division> divisionList = divisionRepository.getAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationList", educationList);
        request.setAttribute("divisionList", divisionList);
        try {
            request.getRequestDispatcher("view/employee/employee-edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = positionRepository.getAll();
        List<Education> educationList = educationRepository.getAll();
        List<Division> divisionList = divisionRepository.getAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationList", educationList);
        request.setAttribute("divisionList", divisionList);
        try {
            request.getRequestDispatcher("view/employee/employee-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
