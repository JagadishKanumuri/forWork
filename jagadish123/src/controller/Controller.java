package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Customer;
import service.Service;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Controller() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		Service service = new Service();
		if("view".equalsIgnoreCase(action))
		{
			ArrayList<Customer> alist = service.viewdetails();
			if(alist.size()!=0)
			{
				request.setAttribute("alist", alist);
				RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
				rd.forward(request, response);
			}
		}
		if("insert".equalsIgnoreCase(action))
		{
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			int phone = Integer.parseInt(request.getParameter("phone"));
			Customer c = new Customer(name, age, gender, phone);
			int i = service.insert(c);
			if(i>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
				rd.forward(request, response);
				
			}
			
		}
		if("delete".equalsIgnoreCase(action))
		{
			String name = request.getParameter("name");
			int i = service.delete(name);
		
			if(i>0)
			{
				RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd= request.getRequestDispatcher("fail.jsp");
				rd.forward(request, response);
			}
			
		}
		if("update".equalsIgnoreCase(action))
		{
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			int phone = Integer.parseInt(request.getParameter("phone"));
			Customer c = new Customer(name, age, gender, phone);
			int i = service.update(c);
			if(i>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
				rd.forward(request, response);
			}
		}
		if("search".equalsIgnoreCase(action))
		{
			String name = request.getParameter("name");
			ArrayList<Customer> customer = service.search(name);
			if(customer.size()!=0)
			{
				request.setAttribute("alist", customer);
				RequestDispatcher rd = request.getRequestDispatcher("viewsearch.jsp");
				rd.forward(request, response);
			}
		}
		
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
