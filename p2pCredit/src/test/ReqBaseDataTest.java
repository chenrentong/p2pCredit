package test;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platenco.p2pCredit.dao.ReqBaseDataDao;
import com.platenco.p2pCredit.model.CustInfo;
import com.platenco.p2pCredit.model.ReqBaseData;
import com.platenco.p2pCredit.util.HttpSend;
import com.platenco.p2pCredit.util.JsonTransform;
import com.platenco.p2pCredit.util.SerialNumber;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class ReqBaseDataTest {
	
	@Resource(name="reqBaseDataDao") 
	private ReqBaseDataDao reqBaseDataDao;
	
	@Test
	public void save() throws Exception{
		ReqBaseData reqBaseData = new ReqBaseData();
		reqBaseData.setActualControlPerson("张三");
		reqBaseData.setCompanyAdress("海珠区");
		reqBaseData.setCompanyName("七天");
		reqBaseData.setContactInformation("电话联系吧");
		reqBaseData.setCorporateName("李四");
		reqBaseData.setCreateDate(new Timestamp(new Date().getTime()));
		reqBaseData.setCustId(1);
		reqBaseData.setEmployeeNum(251);
		reqBaseData.setFundsUse("投资");
		reqBaseData.setIdCardBackName("我是背面.jpg");
		reqBaseData.setIdCardFrontName("我是正面.jpg");
		reqBaseData.setIdCardPhotoPath("/照片目录/");
		reqBaseData.setLoanTerm("24个月");
		reqBaseData.setMonthlyRent((long)20000);
		reqBaseData.setMonthlyUtilities((long)300000);
		reqBaseData.setPurchaseFee((long)25000);
		reqBaseData.setReqLoanAmount((long)1000000);
		reqBaseData.setStatus(1);
		reqBaseData.setStoreId(12);
		reqBaseData.setUpdateDate(new Timestamp(new Date().getTime()));
		reqBaseData.setUseDate("2016-12-10");
		reqBaseData.setWages(8200);
		reqBaseData.setReqSerialNumber(SerialNumber.getSerialNum());
		reqBaseDataDao.save(reqBaseData);
	}
	
	@Test
	public void savePost(){
		String URL = "http://localhost:8088/p2pCredit/saveReqBaseData";
		ReqBaseData reqBaseData = new ReqBaseData();
		reqBaseData.setActualControlPerson("张三");
		reqBaseData.setCompanyAdress("海珠区");
		reqBaseData.setCompanyName("七天");
		reqBaseData.setContactInformation("电话联系吧");
		reqBaseData.setCorporateName("李四");
		reqBaseData.setCreateDate(new Timestamp(new Date().getTime()));
		reqBaseData.setCustId(999);
		reqBaseData.setEmployeeNum(251);
		reqBaseData.setFundsUse("投资");
		reqBaseData.setIdCardBackName("我是背面.jpg");
		reqBaseData.setIdCardFrontName("我是正面.jpg");
		reqBaseData.setIdCardPhotoPath("/照片目录/");
		reqBaseData.setLoanTerm("24个月");
		reqBaseData.setMonthlyRent((long)20000);
		reqBaseData.setMonthlyUtilities((long)300000);
		reqBaseData.setPurchaseFee((long)25000);
		reqBaseData.setReqLoanAmount((long)1000000);
		reqBaseData.setStatus(-1);
		reqBaseData.setStoreId(12);
		reqBaseData.setUpdateDate(new Timestamp(new Date().getTime()));
		reqBaseData.setUseDate("2016-12-10");
		reqBaseData.setWages(8200);
		reqBaseData.setReqSerialNumber(SerialNumber.getSerialNum());
		
		String jsonString = JsonTransform.modelToJsonString(reqBaseData);
		HttpSend.sendPost(URL, jsonString);
	}
	
	@Test
	public void getPost(){
		//String URL = "http://localhost:8088/p2pCredit/getReqBaseData";
		String URL = "http://115.29.174.77:8088/p2pCredit/getReqBaseData";
		ReqBaseData reqBaseData = new ReqBaseData();
		reqBaseData.setRecordId(1);
		reqBaseData.setCustId(11);
		String jsonString = JsonTransform.modelToJsonString(reqBaseData);
		HttpSend.sendPost(URL, jsonString);
	}
	
	@Test
	public void updatePost() throws Exception{
		String URL = "http://localhost:8088/p2pCredit/updateReqBaseData";
		ReqBaseData reqBaseData = new ReqBaseData();
		reqBaseData = reqBaseDataDao.get(3);
		reqBaseData.setStatus(2);
		String jsonString = JsonTransform.modelToJsonString(reqBaseData);
		HttpSend.sendPost(URL, jsonString);
		
	}


}
