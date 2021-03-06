package controller.service;

import model.bean.service.RentType;
import model.bean.service.ServiceType;
import model.bean.service.Services;
import model.repository.service.RentTypeRepository;
import model.repository.service.ServiceTypeRepository;
import model.service.api.Service;
import model.service.common.PrintErr;
import model.service.impl.IServiceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    Service<Services> serviceManager = new IServiceManager();
    RentTypeRepository rentTypeRepository = new RentTypeRepository();
    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            case "edit":
                editService(request, response);
                break;

            default:
                listService(request, response);
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
                delService(request, response);
                break;
            case "view":
                showInfomationForm(request, response);
                break;
            case "search":
                searchService(request, response);
                break;
            default:
                listService(request, response);
                break;
        }
    }

    // do get
    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Services> list = serviceManager.findAll();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/service/service-list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Services> list = serviceManager.findByName(name);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/service/service-list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showInfomationForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = serviceManager.remove(id);
        if (check) request.setAttribute("message", "xóa thành công");
        else {
            request.setAttribute("message", "xóa thất bại");
            request.setAttribute("err", true);
        }
        listService(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = rentTypeRepository.getAll();
        List<ServiceType> serviceTypeList = serviceTypeRepository.getAll();

        int id = Integer.parseInt(request.getParameter("id"));
        Services services = serviceManager.findById(id);
        request.setAttribute("service", services);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        try {
            request.getRequestDispatcher("view/service/service-edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = rentTypeRepository.getAll();
        List<ServiceType> serviceTypeList = serviceTypeRepository.getAll();
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        try {
            request.getRequestDispatcher("view/service/service-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // do post
    private void createService(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            int areaOfUse = Integer.parseInt(request.getParameter("areaOfUse"));
            int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
            int maxNumOfPeople = Integer.parseInt(request.getParameter("maxNumOfPeople"));
            int rentalCosts = Integer.parseInt(request.getParameter("rentalCosts"));
            int idRentType = Integer.parseInt(request.getParameter("idRentType"));
            int idServiceType = Integer.parseInt(request.getParameter("idServiceType"));
            RentType rentType = rentTypeRepository.get(idRentType);
            ServiceType serviceType = serviceTypeRepository.get(idServiceType);
            String status = request.getParameter("status");
            String maDichVu = request.getParameter("maDichVu");
            Services services = new Services(name, areaOfUse, numberOfFloors, maxNumOfPeople, rentalCosts, rentType, serviceType, status, maDichVu);
            Map<String, String> map = serviceManager.save(services);

            request.setAttribute("service", services);
            if (map.isEmpty()) request.setAttribute("message", "Tạo mới thành công");
            else {
                throw new Exception(PrintErr.printErr(map));
            }
        } catch (Exception e) {
            request.setAttribute("err", true);
            request.setAttribute("message", e.getMessage());
        }
        try {
            request.getRequestDispatcher("view/service/service-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int areaOfUse = Integer.parseInt(request.getParameter("areaOfUse"));
            int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
            int maxNumOfPeople = Integer.parseInt(request.getParameter("maxNumOfPeople"));
            int rentalCosts = Integer.parseInt(request.getParameter("rentalCosts"));
            int idRentType = Integer.parseInt(request.getParameter("idRentType"));
            int idServiceType = Integer.parseInt(request.getParameter("idServiceType"));
            RentType rentType = rentTypeRepository.get(idRentType);
            ServiceType serviceType = serviceTypeRepository.get(idServiceType);
            String status = request.getParameter("status");
            String maDichVu = request.getParameter("maDichVu");
            Services services = new Services(name, areaOfUse, numberOfFloors, maxNumOfPeople, rentalCosts, rentType, serviceType, status, maDichVu);
            Map<String, String> map = serviceManager.update(id, services);

            request.setAttribute("service", services);
            if (map.isEmpty()) request.setAttribute("message", "Tạo mới thành công");
            else {
                throw new Exception(PrintErr.printErr(map));
            }
        } catch (Exception e) {
            request.setAttribute("err", true);
            request.setAttribute("message", e.getMessage());
        }
        try {
            request.getRequestDispatcher("view/service/service-edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

