package com.servlets;

import java.io.IOException; 

import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.util.Date; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import com.highradius.JDBC; 
 
@WebServlet("/index") 
public class Add extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
  protected void doPost(HttpServletRequest request,  
    HttpServletResponse response) 
            throws ServletException, IOException 
        { 
            try { 
       
                 
                Connection con = JDBC.initializeDatabase(); 
       
                PreparedStatement st = con 
                       .prepareStatement("insert into winter_internship values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
       
                // For the first parameter, 
                // get the data using request object 
                // sets the data to st pointer 
                st.setString(1, request.getParameter("business_code")); 
       
                // Same for second parameter 
                st.setString(2, request.getParameter("doc_id")); 
                st.setString(3, request.getParameter("invoice_currency")); 
                st.setDate(4, java.sql.Date.valueOf(request.getParameter("baseline_create_date"))); 
                st.setInt(5,Integer.valueOf(request.getParameter("cust_number"))); 
                st.setDate(6, java.sql.Date.valueOf(request.getParameter("posting_date"))); 
                st.setString(7, request.getParameter("document_type")); 
                st.setString(8, request.getParameter("cust_payment_terms")); 
                st.setDate(9, java.sql.Date.valueOf(request.getParameter("clear_date"))); 
                st.setDate(10, java.sql.Date.valueOf(request.getParameter("document_create_date"))); 
                st.setInt(11, Integer.valueOf(request.getParameter("posting_id"))); 
                st.setInt(12, Integer.valueOf(request.getParameter("invoice_id"))); 
                st.setInt(13, Integer.valueOf(request.getParameter("buisness_year"))); 
                st.setDate(14, java.sql.Date.valueOf(request.getParameter("Due_in_date"))); 
                st.setInt(15, Integer.valueOf(request.getParameter("total_open_amount"))); 
                 
       
                // Execute the insert command using executeUpdate() 
                // to make changes in database 
                int l = st.executeUpdate(); 
       
                // Close all the connections 
                st.close(); 
                con.close(); 
       
                // Get a writer pointer  
                // to display the successful result 
                System.out.println(l); 
                PrintWriter out = response.getWriter(); 
                out.println("<html><body><b>Successfully Inserted" 
                            + "</b></body></html>"); 
            } 
            catch (Exception e) { 
                e.printStackTrace(); 
            } 
          
        } 
     
   
 
  
 
 
 
 }