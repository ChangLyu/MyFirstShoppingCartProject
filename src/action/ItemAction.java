package action;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.INTERNAL;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.SalesItemsDao;
import model.SalesItems;

public class ItemAction extends ActionSupport implements ModelDriven{
	SalesItemsDao salesItemsdao=new SalesItemsDao();
	SalesItems salesItems=new SalesItems();
	List<SalesItems> itemList=new ArrayList<SalesItems>();
	int itemId;//this does not need get and set method, because we always use get model to return the model, use the model.get method to get 
	int numberofitems;//this needs the get and set method, because it is not the property in the model
    private String result="";


	public String listall(){
		itemList=salesItemsdao.listall(itemList);
		if(!itemList.isEmpty()){
		System.out.println(itemList.get(0).getItemName());}
        result="SUCCESSLISTALL";
        return result;
	}

	public String showdetail(){
		itemId=salesItems.getItemId();
		itemList=salesItemsdao.showdetail(itemId);
		if(!itemList.isEmpty()){
		System.out.println(itemList.get(0).getItemName());}
		result="SUCCESSSHOWDETAIL";
		return result;
	}
	
	public String edit(){
        salesItemsdao.edit(salesItems);
		result="SUCCESSEDITITEM";
		return result;
	}
	public String add(){
        salesItemsdao.add(salesItems);
		result="SUCCESSADDITEM";
		return result;
	}
	public String delete(){
		
        salesItemsdao.delete(salesItems.getItemId());
		result="SUCCESSDELETEITEM";
		return result;
	}
	
    public String decreasequantity(){
		itemList=salesItemsdao.listall(itemList);
		
    	salesItemsdao.decreasequantity(itemId,numberofitems);
		 System.out.println("itemaction decreasequantity itemid is"+itemId);
		 System.out.println("numberofitems is"+numberofitems);
    	
    	result="SUCCESSDECREASE";
    	return result;
    	
    }
    
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getNumberofitems() {
		return numberofitems;
	}

	public void setNumberofitems(int numberofitems) {
		this.numberofitems = numberofitems;
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
	return salesItems;

	}

	public SalesItemsDao getSalesItemsdao() {
		return salesItemsdao;
	}

	public void setSalesItemsdao(SalesItemsDao salesItemsdao) {
		this.salesItemsdao = salesItemsdao;
	}

	public List<SalesItems> getItemList() {
		return itemList;
	}

	public void setItemList(List<SalesItems> itemList) {
		this.itemList = itemList;
	}


}
