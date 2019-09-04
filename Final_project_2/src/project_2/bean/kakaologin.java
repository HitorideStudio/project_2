package project_2.bean;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log/")

public class kakaologin {
	
	@RequestMapping("login.do")
	public String login() {
		
		return "/log/login";
	}
	@RequestMapping("loginPro_k.do")
	public String loginPro_k(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		return "/log/loginPro_k";
	}
	

		  
}
