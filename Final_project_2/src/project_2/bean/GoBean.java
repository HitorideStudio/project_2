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
	
=======
	@RequestMapping("map.do")
	public String map() {
		return "/finder/map";
	}
	@RequestMapping("cluster.do")
	public ModelAndView cluster() {
		ModelAndView model = new ModelAndView();
		
		List<PlaceList> list = sql.selectList("placelistdb.selectplacelist");
		model.addObject("list",list);
		
		model.setViewName("/finder/cluster");
		return model;
		
	}
	

>>>>>>> branch 'master' of https://github.com/HitorideStudio/project_2.git

}
