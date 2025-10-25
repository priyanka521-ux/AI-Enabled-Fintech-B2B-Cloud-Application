package com.servlets;

import java.sql.PreparedStatement; 

import com.highradius.JDBC; 
 
import java.sql.Connection; 
import java.io.IOException; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
@WebServlet({ "/EditInvoice" }) 
public class Edit extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException { 
        response.getWriter().append("Served at: ").append(request.getContextPath()); 
} 
     
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException { 
        try { 
            final String fieldValue = request.getParameter("sno"); 
            final int field = Integer.parseInt(fieldValue); 
            final String inv_currency = request.getParameter("inv_currency"); 
            final String customer_payment = request.getParameter("customer_payment"); 
            Connection con = JDBC.initializeDatabase(); 
            final String query = "UPDATE winter_internship SET invoice_currency = ?, cust_payment_terms = ? WHERE sno = ?"; 
            final PreparedStatement st = con.prepareStatement(query); 
            st.setString(1, inv_currency); 
            st.setString(2, customer_payment); 
            st.executeUpdate(); 
            con.close(); 
        } 
        catch (Exception ex) {} 
    } 
}



