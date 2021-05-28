import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "")
public class CustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list = new ArrayList<>();
        list.add( new Customer("Mai Văn Hoàng","1983-08-30","Hà Nội", "img/1.jpg"));
        list.add( new Customer("Nguyễn Văn Nam","1983-08-30","đà nẵng", "img/2.jpg"));
        list.add( new Customer("Nguyễn Thái Hòa","1983-08-30","Bắc Giang", "img/3.jpg"));
        list.add( new Customer("Trần Đăng Khoa","1983-08-30","đà nẵng", "img/4.jpg"));
        request.setAttribute("listCustomer",list);
        try {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException i){
            i.printStackTrace();
        }

    }
}
