package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import managers.ManageUsers;
import models.User;

/**
 * Servlet implementation class FormController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   System.out.print("RegisterController: ");
	   User user = new User();
	   ManageUsers manager = new ManageUsers();
	   boolean cn = false;
	   boolean cm = false;
	
	   try {
	
		   BeanUtils.populate(user, request.getParameterMap());
		   
		   /*System.out.println("User: " + user.getUsername());
	       System.out.println("Mail: " + user.getMail());
	       System.out.println("Password: " + user.getPwd1());
	       System.out.println("Password: " + user.getPwd2());
	       System.out.println("Gender: " + user.getGenders());
	       System.out.println("PhoneNumber: " + user.getPhonenumber());
	       System.out.println("Experience: " + user.getExperience());
	       System.out.println("Languages: " + user.getLanguages());
	       System.out.println("Linkedin: " + user.getLinkedin());*/
		   
		   cn = manager.checkUser(user.getUsername());
		   cm = manager.checkMail(user.getMail());
		   
		   user.setError("username", cn);
		   user.setError("mail", cm);
		   
		   System.out.println("cn: " + cn);
		   System.out.println("cm: " + cm);
		   System.out.println("isComplete: " + manager.isComplete(user));
		   
		   if (manager.isComplete(user) && !cn && !cm) {
			   
			   manager.addUser(user);
			   manager.finalize();
			   System.out.println(" user registered, forwarding to ViewLoginForm.");
			   RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLoginForm.jsp");
			   dispatcher.forward(request, response);
		   
		   } 
		   
		   else  {
		
			   System.out.println(" some field is incorrect, forwarding to ViewRegisterForm.");
			   request.setAttribute("user",user);
			   RequestDispatcher dispatcher = request.getRequestDispatcher("ViewRegisterForm.jsp");
			   dispatcher.forward(request, response);
		   }
	   
	   } catch (IllegalAccessException | InvocationTargetException e) {
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
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
