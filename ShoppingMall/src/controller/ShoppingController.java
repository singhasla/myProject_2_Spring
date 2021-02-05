package controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.MemberBean;

public class ShoppingController {

	@RequestMapping("/index.do")
	public ModelAndView index(HttpSession session){
		
		ModelAndView mav = new ModelAndView();

		MemberBean mbean = (MemberBean)session.getAttribute("mbean");
		
		if(mbean==null){
			mav.addObject("mbean",null);
			mav.setViewName("ShoppingMain");
		} else {
			mav.addObject("mbean",mbean);
			mav.setViewName("ShoppingMain");
		}
		
		return mav;
	}
}
