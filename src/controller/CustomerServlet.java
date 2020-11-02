package controller;

import model.Customer;
import service.CustomerServiceImpl;
import service.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    ICustomerService service=new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null)
            action="";
        switch (action){
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                break;
            default:
                
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");

        String address = request.getParameter("address");
        int id = (int)(Math.random() * 10000);

        Customer customer = new Customer(id, name, address);
        this.service.save(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null)
            action="";
        switch (action){
            case "create":
                showFormCeate(request,response);
                break;
            case "edit":
                break;
            default:
                listCustomer(request,response);
                break;
        }

    }

    private void showFormCeate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers=service.findAll();
        request.setAttribute("customers",customers);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
