package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import dao.CustomerDao;
import model.Customer;



public class CustomerAction extends ActionSupport implements ModelDriven, SessionAware{
	private Customer customer=new Customer();
	private CustomerDao customerdao=new CustomerDao();
	private Map<String, Object> sessionMap;
	//create a result string, so that we can use struts tag in the register page to figure if it is success.
	private String result="";

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerDao getCustomerdao() {
		return customerdao;
	}

	public void setCustomerdao(CustomerDao customerdao) {
		this.customerdao = customerdao;
	}

	public String register(){
		result="";   
	  result=customerdao.register(customer);
	   return result;	      
	}
	
	public String login(){
		result="";
	    result=customerdao.login(customer);
	    //if successfully login, put the customer into the session map. Then in the jsp, we can still see the status of custoerm.
	    if(result.equals("SUCCESSLOGIN")){
	    	sessionMap.put("username",customer.getUsername());
	    }
		return result;	      
		}
	
	@Override
	public Object getModel() {
		return customer;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}
	

}
