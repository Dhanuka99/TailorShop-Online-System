package com.customer;

import com.customer.crudUtil.Crud;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/customerSave")
public class CustomerSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String number = req.getParameter("phoneNumber");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        try {
            boolean b = Crud.saveCustomer(new Customer(name, address, email, number, userName, password));
            if(b==true) {
                RequestDispatcher dis = req.getRequestDispatcher("success.jsp");
                dis.forward(req, resp);
            }else{
                RequestDispatcher dis = req.getRequestDispatcher("unsuccess.jsp");
                dis.forward(req, resp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
