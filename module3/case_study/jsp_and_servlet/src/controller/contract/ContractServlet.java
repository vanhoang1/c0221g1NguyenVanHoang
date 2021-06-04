package controller.contract;

import model.bean.Contract;
import model.bean.Customer;
import model.bean.Employee;
import model.bean.Services;
import model.service.impl.IContractService;

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

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    private IContractService contractService = new IContractService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request, response);
                break;
            case "edit":
                editContract(request, response);
                break;

            default:
                listContract(request, response);
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
                delContract(request, response);
                break;
            case "view":
                showInfomationForm(request, response);
                break;

            default:
                listContract(request, response);
                break;
        }
    }

    // do - get

    private void showInfomationForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = contractService.remove(id);
        if (check) request.setAttribute("message", "Xóa thành công");
        else {
            request.setAttribute("message", "Xóa thất bại");
            request.setAttribute("err", true);
        }
        listContract(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractService.findById(id);
        List<Employee> employeeList = contractService.employeeRepository().getAll();
        List<Customer> customerList = contractService.customerRepository().getAll();
        List<Services> servicesList = contractService.serviceRepository().getAll();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("servicesList",servicesList);
        request.setAttribute("contract", contract);
        try {
            request.getRequestDispatcher("view/contract/contract-edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = contractService.employeeRepository().getAll();
        List<Customer> customerList = contractService.customerRepository().getAll();
        List<Services> servicesList = contractService.serviceRepository().getAll();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("servicesList",servicesList);
        try {
            request.getRequestDispatcher("view/contract/contract-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // do -post
    private void listContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> list = contractService.findAll();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/contract/contract-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editContract(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        int id = Integer.parseInt(request.getParameter("id"));
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = formatter.parse(request.getParameter("startDate"));
            endDate = formatter.parse(request.getParameter("endDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        Employee employee= contractService.employeeRepository().get(idEmployee);
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        Customer customer = contractService.customerRepository().get(idCustomer);
        int idService = Integer.parseInt(request.getParameter("idService"));
        Services services  = contractService.serviceRepository().get(idService);
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        Contract contract = new Contract(startDate, endDate, deposit, totalMoney, employee, customer, services);
        boolean check = contractService.update(id, contract);
        List<Employee> employeeList = contractService.employeeRepository().getAll();
        List<Customer> customerList = contractService.customerRepository().getAll();
        List<Services> servicesList = contractService.serviceRepository().getAll();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("servicesList",servicesList);
        request.setAttribute("contract", contract);
        if (check) request.setAttribute("message", "Cập nhật thành công");
        else {
            request.setAttribute("message", "Cập nhật thất bại");
            request.setAttribute("err", true);
        }
        try {
            request.getRequestDispatcher("view/contract/contract-edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = formatter.parse(request.getParameter("startDate"));
            endDate = formatter.parse(request.getParameter("endDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        Employee employee= contractService.employeeRepository().get(idEmployee);
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        Customer customer = contractService.customerRepository().get(idCustomer);
        int idService = Integer.parseInt(request.getParameter("idService"));
        Services services  = contractService.serviceRepository().get(idService);
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        Contract contract = new Contract(startDate, endDate, deposit, totalMoney, employee, customer, services);
        boolean check = contractService.save(contract);
        List<Employee> employeeList = contractService.employeeRepository().getAll();
        List<Customer> customerList = contractService.customerRepository().getAll();
        List<Services> servicesList = contractService.serviceRepository().getAll();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("servicesList",servicesList);
        request.setAttribute("contract", contract);
        if (check) request.setAttribute("message", "Tạo mới thành công");
        else {
            request.setAttribute("message", "Tạo mới thất bại");
            request.setAttribute("err", true);
        }
        try {
            request.getRequestDispatcher("view/contract/contract-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
