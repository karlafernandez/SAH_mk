/*
package kachuelitos.struts;

import java.util.Map;

import kachuelitos.model.User;
import kachuelitos.model.UserDAO;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware  {
	
	private String dni;
	private String password;
	private  Map<String, Object> session;
	private User user;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String validateLogin() {

		System.out.println("salida" + dni +"-" +password);
		
		UserDAO userdao = new UserDAO();
		user = userdao.identificationUser(dni, password);

		if(user != null){
			
			//Se guarda la session
			session.put("user", user);
			return SUCCESS;
			
		}
		else{
			return ERROR;
		}	
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

* */