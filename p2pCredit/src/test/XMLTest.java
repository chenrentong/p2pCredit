package test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platenco.p2pCredit.util.ExcelUtil;
import com.platenco.p2pCredit.util.HttpSend;
import com.platenco.p2pCredit.util.Logg;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class XMLTest {
	
	@Test
	public void getXml(){
		String urlString = "http://localhost:8088/p2pCredit/file/upXML";
		String fileString="D:/全国门店BI.xlsx";
		try{
			String resultString = HttpSend.upload(urlString, fileString);
			System.out.println(resultString);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
