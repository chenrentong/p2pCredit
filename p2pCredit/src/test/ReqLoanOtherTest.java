package test;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platenco.p2pCredit.dao.ReqLoanOtherDao;
import com.platenco.p2pCredit.model.ReqLoanOther;
import com.platenco.p2pCredit.util.HttpSend;
import com.platenco.p2pCredit.util.JsonTransform;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class ReqLoanOtherTest {
	
	@Resource(name="reqLoanOtherDao")
	private ReqLoanOtherDao reqLoanOtherDao;
	
	@SuppressWarnings("deprecation")
	@Test
	public void save() throws Exception{
		ReqLoanOther reqLoanOther = new ReqLoanOther();
		reqLoanOther.setInBorrowingRates("24");
		reqLoanOther.setInExpiryDate(new Timestamp(118, 3, 21, 11, 59, 0, 0));
		reqLoanOther.setInLoanAmount((long)50000);
		reqLoanOther.setInNoFurtherAmount((long)40000);
		reqLoanOther.setInstitutionName("投资");
		reqLoanOther.setRecordId((long)2);
		reqLoanOtherDao.save(reqLoanOther);
	}

	@Test
	public void savePost() throws Exception{
		String URL = "http://localhost:8088/p2pCredit/saveReqLoanOther";
		ReqLoanOther[] reqLoanOthers = new ReqLoanOther[3];
		ReqLoanOther reqLoanOther = reqLoanOtherDao.get((long)5);
		reqLoanOthers[0] = reqLoanOther;
		reqLoanOthers[1] = reqLoanOther;
		reqLoanOthers[2] = reqLoanOther;
		String jsonString = JsonTransform.modelToJsonString(reqLoanOthers);
		HttpSend.sendPost(URL, jsonString);
	}
	
	@Test
	public void getPost() throws Exception{
		String URL = "http://localhost:8088/p2pCredit/getReqLoanOther";
		ReqLoanOther[] reqLoanOthers = new ReqLoanOther[3];
		ReqLoanOther reqLoanOther = reqLoanOtherDao.get((long)5);
		reqLoanOthers[0] = reqLoanOther;
		String jsonString = JsonTransform.modelToJsonString(reqLoanOthers);
		HttpSend.sendPost(URL, jsonString);
	}
	
	@Test
	public void updatePost() throws Exception{
		String URL = "http://localhost:8088/p2pCredit/updateReqLoanOther";
		ReqLoanOther reqLoanOther = reqLoanOtherDao.get((long)5);
		reqLoanOther.setRecordId((long)1);
		String jsonString = JsonTransform.modelToJsonString(reqLoanOther);
		HttpSend.sendPost(URL, jsonString);
	}
}
