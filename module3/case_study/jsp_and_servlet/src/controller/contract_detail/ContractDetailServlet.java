package controller.contract_detail;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.service.impl.IContractDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet" ,urlPatterns = "/contract-detail")
public class ContractDetailServlet extends HttpServlet {
    IContractDetailService contractDetailService = new IContractDetailService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
                break;
            case "edit":
                editContractDetail(request, response);
                break;

            default:
                listContractDetail(request, response);
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
                delContractDetail(request, response);
                break;
            case "view":
                showInfomationForm(request, response);
                break;

            default:
                listContractDetail(request, response);
                break;
        }
    }

    private void showInfomationForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delContractDetail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ContractDetail contractDetail = contractDetailService.findById(id);
        request.setAttribute("contractDetail",contractDetail);
        List<Contract> contractList =contractDetailService.contractRepository().getAll();
        List<AttachService> attachServiceList = contractDetailService.attachServiceRepository().getAll();
        request.setAttribute("contractList",contractList);
        request.setAttribute("attachServiceList",attachServiceList);
        try {
            request.getRequestDispatcher("view/contract_detail/contract-detail-edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList =contractDetailService.contractRepository().getAll();
        List<AttachService> attachServiceList = contractDetailService.attachServiceRepository().getAll();
        request.setAttribute("contractList",contractList);
        request.setAttribute("attachServiceList",attachServiceList);
        try {
            request.getRequestDispatcher("view/contract_detail/contract-detail-create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listContractDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> list = contractDetailService.findAll();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/contract_detail/contract-detail-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //-do post
    private void editContractDetail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int idContract = Integer.parseInt(request.getParameter("idContract"));
        Contract contract = contractDetailService.contractRepository().get(idContract);
        int idAttachService =  Integer.parseInt(request.getParameter("idAttachService"));
        AttachService attachService = contractDetailService.attachServiceRepository().get(idAttachService);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(contract,attachService,quantity);
        boolean check = contractDetailService.save(contractDetail);
        List<Contract> contractList =contractDetailService.contractRepository().getAll();
        List<AttachService> attachServiceList = contractDetailService.attachServiceRepository().getAll();
        request.setAttribute("contractList",contractList);
        request.setAttribute("attachServiceList",attachServiceList);
        request.setAttribute("contractDetail",contractDetail);
        if (check) request.setAttribute("message", "Tạo mới thành công");
        else {request.setAttribute("message", "Tạo mới thất bại");request.setAttribute("err", true);}

        try {
            request.getRequestDispatcher("view/contract_detail/contract-detail-create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
