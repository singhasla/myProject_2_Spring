package controller;

import java.util.ArrayList;
import java.util.List;

import model.SuCartBean;

public class Cart {

	private List<SuCartBean> itemlist = new ArrayList<SuCartBean>();
	
	public List<SuCartBean> getItemlist(){
		return itemlist;
	}
	
	//기존에 상품이 담겨있다면 수량만 증가, 상품이 담겨있지 않으면 상품을 추가
	public void push(SuCartBean cartbean){
		
		boolean alreadysutool=false;
		
		for(SuCartBean suCartBean : itemlist){
			if(cartbean.getSuno() == suCartBean.getSuno()){
				suCartBean.setSuqty(suCartBean.getSuqty() + cartbean.getSuqty());
				
				alreadysutool = true;
				break;
			}
		}
		
		if(alreadysutool == false){
			itemlist.add(cartbean);
		}
	}

	public void deleteCart(int suno) {

		for(SuCartBean suCartBean : itemlist){
			if(suCartBean.getSuno() == suno){
				itemlist.remove(suCartBean);
				break;
			}
		}
	}
}
