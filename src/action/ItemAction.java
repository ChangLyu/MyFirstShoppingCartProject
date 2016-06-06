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
	List<SalesItems> itemList=new ArrayList<SalesItems>();
	int itemId;
	int numberofitems;
    private String result="";


	public String listall(){
		itemList=salesItemsdao.listall(itemList);
		if(!itemList.isEmpty()){
		System.out.println(itemList.get(0).getItemName());}
        result="SUCCESSLISTALL";
        return result;
	}

	public String showdetail(){
		itemList=salesItemsdao.showdetail(itemId);
		if(!itemList.isEmpty()){
		System.out.println(itemList.get(0).getItemName());}
		result="SUCCESSSHOWDETAIL";
		return result;
	}
	
    public String decreasequantity(){
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



	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
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
