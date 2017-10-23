package test;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platenco.p2pCredit.dao.ReqImageDataDao;
import com.platenco.p2pCredit.model.ReqImageData;
import com.platenco.p2pCredit.util.HttpSend;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class UploadTest {
	
	@Resource(name="reqImageDataDao")  
	private ReqImageDataDao reqImageDataDao;
	
	@Test
	public void upFile() throws IOException{
		String urlString = "http://localhost:8088/p2pCredit/file/upload";
		String fileString = "D:/2_34_身份证.JPG";
		try{
			String resultString = HttpSend.upload(urlString, fileString);
			System.out.println(resultString);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void save() throws Exception{
		ReqImageData reqImageData = new ReqImageData();
		reqImageData.setImageName("测试");
		reqImageData.setImagePath("路径");
		reqImageData.setImageType(1);
		reqImageData.setRecordId((long)123);
		reqImageDataDao.save(reqImageData);
	}
}
