package project_2.bean;

import java.io.File;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.member.vo.memberVO;

@Controller
@RequestMapping("/signup/")
public class signup {
	
	@Autowired
	private SqlSessionTemplate sql = null;
	
	@RequestMapping("join.do")
	public String register() {
		System.out.println(sql);
		return "/signup/join";
	}
	
	@RequestMapping("joinPro.do")
	public String joinPro(MultipartHttpServletRequest request,String id, String pw, String name) {
	
		System.out.println(id);
		MultipartFile mf = request.getFile("img");
		String path = request.getRealPath("imgs");
		String org = mf.getOriginalFilename();
		String ext = org.substring(org.lastIndexOf("."));
		String img = id+ext;
		File f = new File(path+"//"+img);
		try {
			mf.transferTo(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		memberVO vo= new memberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setImg(img);
		//mybatis insert½ÇÇà
		System.out.println("======"+name);
		sql.insert("member2.insertMember",vo);
		
		return "/signup/joinPro";
	}
	@RequestMapping("confirmId.do")
	public String confirmId(){
		return "/signup/confirmId";
	}
	
	
}
