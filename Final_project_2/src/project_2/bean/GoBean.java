package project_2.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/finder/")
public class GoBean {
	
	@RequestMapping("main.do")
	public String main() {
		return "/finder/main";
	}
	@RequestMapping("map.do")
	public String map() {
		return "/finder/map";
	}
	@RequestMapping("cluster.do")
	public String cluster() {
		return "/finder/cluster";
	}

}
