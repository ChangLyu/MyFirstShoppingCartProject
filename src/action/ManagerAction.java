package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;

import dao.ManagerDao;
import model.Manager;

public class ManagerAction implements ModelDriven, SessionAware {
	private Manager manager=new Manager();
	private ManagerDao managerDao=new ManagerDao();
	private Map<String,Object> sessionMap;
    private String result="";
	
	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String login(){
		
		result=managerDao.login(manager,sessionMap);
		return result;
		
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return manager;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
		
	}
}
