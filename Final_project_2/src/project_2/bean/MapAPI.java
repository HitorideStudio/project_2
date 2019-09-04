package project_2.bean;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import eatoday.vo.restaurantVO;

@Controller
@RequestMapping("/finder/")
public class MapAPI {
	
	// �˻��� ������ ǥ�� - index�� �˻�â�� �Է��� ���
	@RequestMapping("map_kwd.do")
	public String map_kwd(HttpServletRequest request, String search) {
		request.setAttribute("kwd", search);
		return "/finder/map_kwd";
	}
	
	// ����ġ �ֺ� ī�װ��� ������ ǥ�� - restaurant ������
	@RequestMapping("map_gc.do")
	public String map_gc() {
		return "/finder/map_gc";
	}
	
	//������ġ + DB�� ��ϵ� �Ĵ���ġ ǥ��
	@RequestMapping("map_gn")
	public String map_gn(HttpServletRequest request, Model model) {
		try {
			request.setCharacterEncoding("UTF-8");
			//restaurantVO restVO = new restaurantVO();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/finder/map_gn";
	}

}
