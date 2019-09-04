package project_2.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log/")

public class kakaologin {
	
	@RequestMapping("login.do")
	public String log() {
		return "/log/login";
	}

}
