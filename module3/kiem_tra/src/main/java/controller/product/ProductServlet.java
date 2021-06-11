package controller.product;

import model.bean.customer.Customer;
import model.bean.exam.Category;
import model.bean.exam.Product;
import model.repository.product.CategogyRepository;
import model.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService= new ProductService();
    CategogyRepository categogyRepository = new CategogyRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;

            default:
                listProduct(request, response);
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount =Integer.parseInt(request.getParameter("amount"));
        String color =request.getParameter("color");
        String description =request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Category category = categogyRepository.get(idCategory);
        Product product = new Product(name,price,amount,color,description,category);
        List<String> errList =productService.update(id,product);
        if (errList.size() == 0) {
            request.setAttribute("message", "Edit successfully");
            try {
                response.sendRedirect("/home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("errList", errList);
            try {
                request.getRequestDispatcher("view/product/product-edit.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount =Integer.parseInt(request.getParameter("amount"));
        String color =request.getParameter("color");
        String description =request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
         Category category = categogyRepository.get(idCategory);
         Product product = new Product(name,price,amount,color,description,category);
         List<String> errList =productService.save(product);
        if (errList.size() == 0) {
            request.setAttribute("message", "Create successfully");
            try {
                response.sendRedirect("/home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("errList", errList);
            try {
                request.getRequestDispatcher("view/product/product-create.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                delProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = productService.findAll();
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("view/product/product-list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Product> list = productService.findByName(search);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("view/product/product-list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void delProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check= productService.remove(id);
        if (check) request.setAttribute("message", "Delete successfully");
        else {
            request.setAttribute("message", "Delete fail");
            request.setAttribute("err", true);
        }
        try {
            response.sendRedirect("/home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        try {
            request.getRequestDispatcher("view/product/product-edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
            List<Category> categoryList=categogyRepository.getAll();
            request.setAttribute("categoryList",categoryList);
        try {
            request.getRequestDispatcher("view/product/product-create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
