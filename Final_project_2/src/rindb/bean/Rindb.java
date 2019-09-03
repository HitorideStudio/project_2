package rindb.bean;

import org.mybatis.spring.SqlSessionTemplate;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import project.list.vo.PlaceList;

@Controller
@RequestMapping("/rindb/")
public class Rindb {
	@Autowired
	private SqlSessionTemplate sql = null;
	
	@RequestMapping("insert.do")
	private String rindb() throws Exception{
		RConnection rc = new RConnection();
		
		//csv ������ �ҷ��´�
		RList list = rc.eval("x <- read.csv('D:/R/ȫ��ϼ���.csv',stringsAsFactors = F)").asList();
		
		//�÷�
		int cols = list.size();
		//��
		int rows = list.at(0).length();
		
		String [][]s = new String[rows][];
		
		for (int j = 0; j < cols; j++) {
            s[j] = list.at(j).asStrings();
        }
		
		
		for(int i=0; i<rows ; i++) {	
			PlaceList vo = new PlaceList();
			vo.setPlacename(s[0][i]);
			vo.setAddress(s[1][i]);
			vo.setTel(s[2][i]);
			vo.setLon(s[3][i]);
			vo.setLat(s[4][i]);
			vo.setPlace(s[5][i]);
			sql.insert("rindblist.rindbinsert",vo);
			}
	
		rc.close();
		
		return "/rindb/insert";
	}
}
