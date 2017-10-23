package test;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platenco.p2pCredit.dao.CustInfoDao;
import com.platenco.p2pCredit.model.CustInfo;
import com.platenco.p2pCredit.util.HttpSend;
import com.platenco.p2pCredit.util.JsonTransform;
import com.platenco.p2pCredit.util.Logg;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CustInfoTest {
	
	@Resource(name="custInfoDao") 
	private CustInfoDao custInfoDao;
	
	@Test
	public void saveCustInfo() throws Exception{
		CustInfo custInfo = new CustInfo();
		custInfo.setUserId("0");
		custInfo.setCustName("test");
		custInfo.setIdCardNo("34132413241324132412341234");
		custInfo.setPhoneNo("13512787795");
		custInfo.setCreateDate(new Timestamp(new Date().getTime()));
		custInfoDao.save(custInfo);
	}

	@Test
	public void update() throws Exception{
		CustInfo custInfo = new CustInfo();
		custInfo.setCustId(1);
		custInfo.setUserId("2");
		custInfo.setCustName("test1");
		custInfo.setIdCardNo("2421341erwqr43");
		custInfo.setPhoneNo("1431234132412");
		custInfo.setCreateDate(new Timestamp(new Date().getTime()));
		custInfoDao.update(custInfo);
	}
	
	@Test 
	public void get() throws Exception{

			CustInfo custInfo = custInfoDao.get(1);
			String jsonString = JsonTransform.modelToJsonString(custInfo);
			System.out.println(jsonString);
			
	}
	
	@Test
	public void delete() throws Exception{
		saveCustInfo();
		custInfoDao.delete(2);
	}
	
	@Test
	public void sendSave() throws Exception{
		String URL = "http://localhost:8088/p2pCredit/saveCustInfo";
		CustInfo custInfo = custInfoDao.get(1);
		custInfo.setIdCardNo("2312311");
		custInfo.setPhoneNo("34124231312311");
		String jsonString = JsonTransform.modelToJsonString(custInfo);
		HttpSend.sendPost(URL, jsonString);
	}
	
	@Test
	public void getInfo(){
		//String URL = "http://localhost:8088/p2pCredit/getCustInfo";
		String URL = "http://115.29.174.77:8088/p2pCredit/getCustInfo";
		CustInfo custInfo = new CustInfo();
		custInfo.setIdCardNo("3243423432");
		String jsonString = JsonTransform.modelToJsonString(custInfo);
		HttpSend.sendPost(URL, jsonString);
	}
	
	@Test
	public void updateInfo() throws Exception{
		String URL = "http://localhost:8088/p2pCredit/updateCustInfo";
		CustInfo custInfo = custInfoDao.get(1);
		custInfo.setCustName("李四");
		
		String jsonString = JsonTransform.modelToJsonString(custInfo);
		HttpSend.sendPost(URL, jsonString);
	}
}
