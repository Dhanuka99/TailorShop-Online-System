package com.customer.crudUtil;

import com.customer.Customer;
import com.customer.db.DBConnection;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {
    public static boolean saveCustomer(Customer customer) throws SQLException {
        int customerId = customer.getCustomerId();
        String customerName = customer.getCustomerName();
        String customerAddress = customer.getCustomerAddress();
        String customerPhone = customer.getCustomerPhone();
        String customerEmail = customer.getCustomerEmail();
        String customerUserName = customer.getCustomerUserName();
        String customerPassword = customer.getCustomerPassword();


        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Customer VALUES (0,'"+customerId+"','"
                +customerName+"','"+customerAddress
                +"','"+customerPhone+"','"
                +customerEmail+"','"+customerUserName+"','"+customerPassword+"')";

        Statement stm = connection.createStatement();

        int i = stm.executeUpdate(sql);
        if(i>0)
            return true;
        else
            return false;
    }
}
