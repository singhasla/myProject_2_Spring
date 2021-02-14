package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import model.MemberBean;
import model.ShoppingDAO;
import model.SuBean;
import model.SuCartBean;

public class ShoppingController {

	ShoppingDAO shoppingDao;

	public void setShoppingDao(ShoppingDAO shoppingDao) {
		this.shoppingDao = shoppingDao;
	}

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
	
	@RequestMapping("/joinform.do")
	public ModelAndView joinForm(){
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("center","JoinForm.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");
		
		return mav;
	}
	
	@RequestMapping("/joinproc.do")
	public ModelAndView joinProc(MemberBean mbean, HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		
		int result = shoppingDao.getLogin(mbean);
		
		if(result==1){//아이디 중복일 경우
			mav.addObject("result","1");
			mav.addObject("center","JoinForm.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
			
		} else {//아이디 중복하지 않을 경우
			//비밀번호 두개 일치할 경우
			if(mbean.getMempasswd1().equals(mbean.getMempasswd2())){
				shoppingDao.insertMember(mbean);
				session.setAttribute("mbean", mbean);
				session.setMaxInactiveInterval(60*30);//세션유지 30분
				
				return new ModelAndView(new RedirectView("index.do"));
			
			} else {////비밀번호 두개 일치하지 않을 경우
				mav.addObject("result","2");
				mav.addObject("center","JoinForm.jsp");
				mav.addObject("left","SujakLeft.jsp");
				mav.setViewName("ShoppingMain");
			}
		}
		
		return mav;
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(){
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("center","LoginForm.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");
		
		return mav;
	}
	
	@RequestMapping("/loginproc.do")
	public ModelAndView loginProc(MemberBean mbean, HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		
		int result = shoppingDao.getLoginProc(mbean);
		
		if(result == 1){//회원이 존재할 경우
			session.setAttribute("mbean", mbean);
			session.setMaxInactiveInterval(60*30);//세션유지 30분
			
			return new ModelAndView(new RedirectView("index.do"));
		
		} else {//로그인 할 수 없다면 LoginForm.jsp페이지로 이동해서 1전달
			mav.addObject("login","1");
			mav.addObject("center","LoginForm.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
			return mav;
		}
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session){
		
		MemberBean mbean = (MemberBean)session.getAttribute("mbean");
		
		//session.invalidate();
		session.setAttribute("mbean", null);
		
		return new ModelAndView(new RedirectView("index.do"));
	}
	
	@RequestMapping("/sujak.do")
	public ModelAndView sujak(String num){
		
		ModelAndView mav = new ModelAndView();

		if(num==null){
			List<SuBean> list = shoppingDao.getAllSutool();
			mav.addObject("list",list);
		} else {
			List<SuBean> list = shoppingDao.getSelectSutool(num);
			mav.addObject("list",list);
		}
		
		mav.addObject("center","SujakCenter.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");
		
		return mav;
	}
	
	@RequestMapping("/suinfo.do")
	public ModelAndView suinfo(int suno){
		
		SuBean sbean = shoppingDao.getOneSutool(suno);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("sbean", sbean);
		mav.addObject("center","SujakInfo.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");
		
		return mav;
	}
	
	@RequestMapping("/sutoolcart.do")
	public ModelAndView sutoolCart(SuCartBean cartbean, HttpSession session){
		
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart==null){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		cart.push(cartbean);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", cartbean.getSuname() + "의 상품 " 
							+ cartbean.getSuqty() + "개를 카트에 추가했습니다.");
		mav.addObject("center","SuCartResult.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");
		
		return mav;
	}
	
	@RequestMapping("/sucartdel.do")
	public ModelAndView sucartDel(int suno, HttpSession session){
		
		Cart cart = (Cart)session.getAttribute("cart");
		
		cart.deleteCart(suno);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("cart",cart);
		mav.addObject("center","SuCartResult.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");
		
		return mav;
	}
	
	//상품 바로구매
	@RequestMapping("/sutoolbuy.do")
	public ModelAndView sutoolBuy(SuCartBean subean, HttpSession session){
		
		ModelAndView mav = new ModelAndView();

		MemberBean mbean = (MemberBean)session.getAttribute("mbean");
		
		if(mbean==null){
			mav.addObject("center","LoginForm.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
		} else {
			mav.addObject("subean",subean);
			mav.addObject("center","SutoolBuy.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
		}
		
		return mav;
	}
	
	//카트에 담긴 상품 구매
	@RequestMapping("/sucartbuy.do")
	public ModelAndView sucartBuy(SuCartBean subean, HttpSession session){
		
		ModelAndView mav = new ModelAndView();

		MemberBean mbean = (MemberBean)session.getAttribute("mbean");
		
		if(mbean==null){
			mav.addObject("center","LoginForm.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
		} else {
			
			Cart cart = (Cart)session.getAttribute("cart");
			
			mav.addObject("cart",cart);
			mav.addObject("subean",subean);
			mav.addObject("center","SuCartBuy.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
		}
		
		return mav;
	}
		
	//카트 물품 비우기
	@RequestMapping("/cartalldel.do")
	public ModelAndView cartallDel(HttpSession session){
		
		Cart cart = (Cart)session.getAttribute("cart");
		cart.clearCart();
		
		return new ModelAndView(new RedirectView("index.do"));
	}
}