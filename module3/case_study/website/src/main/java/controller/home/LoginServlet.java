package controller.home;

import model.bean.account.User;
import model.bean.account.UserRole;
import model.repository.user.UserRepository;
import model.repository.user.UserRoleRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet" ,urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserRepository userRepository = new UserRepository();
    UserRoleRepository userRoleRepository = new UserRoleRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String remember = request.getParameter("remember");
                String username = request.getParameter("username");
                String password = request .getParameter("password");
               User user =  userRepository.login(username,password);
               if(user == null){request.setAttribute("message", "Login fail");
                                request.setAttribute("err", true);
                   request.getRequestDispatcher("/view/login/login.jsp").forward(request,response);
               }

               else {
                   request.setAttribute("message", "Đăng nhập thành công");
                   HttpSession session = request.getSession();
                   UserRole userRole = userRoleRepository.get(username);
                   session.setAttribute("acc",userRole);
                   //--cookie
                   Cookie u = new Cookie("user",username);
                   Cookie p = new Cookie("pass",password);
                   if(remember!=null){
                       u.setMaxAge(1200);
                       p.setMaxAge(1200);
                   }else {
                       u.setMaxAge(0);
                       p.setMaxAge(0);
                   }
                   response.addCookie(u);
                   response.addCookie(p);
                   response.sendRedirect("home");
               }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                showLoginForm(request, response);
                break;
            case "logout":
                logOut(request, response);
                break;
        }

    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        showLoginForm(request,response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] arrCookie = request.getCookies();
        for (Cookie c:
                arrCookie
        ) {
            if(c.getName().equals("user")){
                request.setAttribute("username",c.getValue());
            }
            if(c.getName().equals("pass")){
                request.setAttribute("password",c.getValue());
            }
        }
        try {
            request.getRequestDispatcher("/view/login/login.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
