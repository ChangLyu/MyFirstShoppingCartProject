package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.SalesItemsDao;
import model.Customer;
import model.SalesItems;

public class ItemAction extends ActionSupport implements ModelDriven{
	SalesItemsDao salesItemsdao=new SalesItemsDao();
	List<SalesItems> itemList=new ArrayList<SalesItems>();

	public String listall(){
		itemList=salesItemsdao.listall(itemList);
		if(!itemList.isEmpty()){
		System.out.println(itemList.get(0).getItemName());}

        return "SUCCESSLISTALL";
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
