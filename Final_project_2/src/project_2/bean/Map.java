package project_2.bean;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.list.vo.PlaceList;

@Controller
@RequestMapping("/map/")
public class Map {
	
	//my batis db
		@Autowired
		private SqlSessionTemplate sql = null;
	
	//테스트용맵 do
	@RequestMapping("map.do")
	public String map() {
		return "/finder/map";
	}
	
	
	//클러스터적용 do
	@RequestMapping("cluster.do")
	public ModelAndView cluster() {
		ModelAndView model = new ModelAndView();
		
		List<PlaceList> list = sql.selectList("mapsql.selectplacelist");
		model.addObject("list",list);
		
		model.setViewName("/finder/cluster");
		return model;
		
	}
}
