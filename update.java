package com.highradius.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import com.google.gson.Gson;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HashMap<Object,Object> Response=new HashMap<Object,Object>();
			
             int sl_no=Integer.parseInt(request.getParameter("sl_no"));
             String business_code =request.getParameter("business_code");
             long cust_number =Long.parseLong(request.getParameter("cust_number"));
             String clear_date =request.getParameter("clear_date");
             int buisness_year=Integer.parseInt(request.getParameter("buisness_year"));
             int doc_id=Integer.parseInt(request.getParameter("doc_id"));
             String posting_date=request.getParameter("posting_date");
             String document_create_date =request.getParameter("document_create_date");
             String document_create_date1=request.getParameter("document_create_date1");
             String due_in_date=request.getParameter("due_in_date");
             String invoice_currency =request.getParameter("invoice_currency");
             String document_type=request.getParameter("document_type");
             int posting_id =Integer.parseInt(request.getParameter("posting_id"));
             String area_business=request.getParameter("area_business");
             int total_open_amount=Integer.parseInt(request.getParameter("total_open_amount"));
             String baseline_create_date=request.getParameter("baseline_create_date");
             String cust_payment_terms=request.getParameter("cust_payment_terms");
             int invoice_id=Integer.parseInt(request.getParameter("invoice_id"));
             int isOpen=Integer.parseInt(request.getParameter("isOpen"));
             String aging_bucket=request.getParameter("aging_bucket");
             int is_deleted=Integer.parseInt(request.getParameter("is_deleted"));
             
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","root");
			String sql="UPDATE winter_internship set business_code=?, cust_number=?, clear_date=?,buisness_year=?,doc_id=?,posting_date=?,document_create_date=?,document_create_date1=?,due_in_date=?,invoice_currency=?,document_type=?,posting_id=?,area_business=?,total_open_amount=?, baseline_create_date=?,cust_payment_terms=?,invoice_id=?,isOpen=?,aging_bucket=?,is_deleted=? where sl_no=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			   preparedStatement.setInt(1,sl_no);
		       preparedStatement.setString(2,business_code);
		       preparedStatement.setLong(3, cust_number);
		       preparedStatement.setString(4, clear_date);
		       preparedStatement.setInt(5, buisness_year);
		       preparedStatement.setLong(6, doc_id);
		       preparedStatement.setString(7, posting_date);
		       preparedStatement.setString(8, document_create_date);
		       preparedStatement.setString(9, document_create_date1);
		       preparedStatement.setString(10, due_in_date);
		       preparedStatement.setString(11, invoice_currency);
		       preparedStatement.setString(12, document_type);
		       preparedStatement.setInt(13, posting_id);
		       preparedStatement.setString(14, area_business);
		       preparedStatement.setDouble(15,total_open_amount);
		       preparedStatement.setString(16, baseline_create_date);
		       preparedStatement.setString(17, cust_payment_terms);
		       preparedStatement.setLong(18, invoice_id);
		       preparedStatement.setInt(19, isOpen);
			   preparedStatement.setString(20, aging_bucket);
			  preparedStatement.setInt(21, is_deleted);
			if(preparedStatement.executeUpdate()>0) {
				Response.put("update", true);
			}else {
				Response.put("update", false);
			}
			Gson gson=new Gson();
			response.setHeader("Access-Control-Allow-Origin", "*");
			String Responsejson=gson.toJson(Response);
			response.getWriter().append(Responsejson);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
