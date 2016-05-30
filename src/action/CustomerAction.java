package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import dao.CustomerDao;
import model.Customer;



public class CustomerAction extends ActionSupport implements ModelDriven{
	private Customer customer=new Customer();
	private CustomerDao customerdao=new CustomerDao();
	//create a result string, so that we can use struts tag in the register page to figure if it is success.
	private String result="";

	
	public String register(){
		result="";   
	  result=customerdao.register(customer);
	   return result;	      
	}
	
	public String login(){
		result="";
	    result=customerdao.login(customer);
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
	

}
