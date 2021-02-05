package controller;


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
