package project_2.bean;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.list.vo.PlaceList;

@Controller
@RequestMapping("/finder/")
public class GoBean {
	
	//my batis db
	@Autowired
	private SqlSessionTemplate sql = null;
	
	@RequestMapping("main.do")
	public String main() {
		return "/finder/main";
	}
<<<<<<< HEAD
	
	@RequestMapping("map.do")
	public String map() {
		return "/finder/map";
	}
	@RequestMapping("cluster.do")
	public ModelAndView cluster() {
=======
	
	@RequestMapping("welcome.do")
	public ModelAndView welcome() {
>>>>>>> branch 'master' of https://github.com/HitorideStudio/project_2.git
		ModelAndView model = new ModelAndView();
		
		List<PlaceList> list = sql.selectList("mapsql.selectplacelist");
		
		model.addObject("list",list);
		model.setViewName("welcome");
		
		return model;
<<<<<<< HEAD
		
	}


=======
	}
	
	
>>>>>>> branch 'master' of https://github.com/HitorideStudio/project_2.git

}
