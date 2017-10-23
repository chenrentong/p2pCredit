package test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platenco.p2pCredit.dao.FirstInstanceChangeHistoryDao;
import com.platenco.p2pCredit.dao.FirstInstanceRecordDao;
import com.platenco.p2pCredit.model.FirstInstanceChangeHistory;
import com.platenco.p2pCredit.model.FirstInstanceRecord;
import com.platenco.p2pCredit.util.SerialNumber;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class FirstInstanceTest {
	
	@Resource(name="firstInstanceRecordDao") 
	private FirstInstanceRecordDao firstInstanceRecordDao;
	
	@Resource(name="firstInstanceChangeHistoryDao") 
	private FirstInstanceChangeHistoryDao firstInstanceChangeHistoryDao;
	
	@Test
	public void save() throws Exception{
		FirstInstanceRecord firstInstanceRecord = new FirstInstanceRecord();
		//firstInstanceRecord.setCreateDate(new Timestamp(new Date().getTime()));
		firstInstanceRecord.setOpinionMsg("信息保存完整");
		firstInstanceRecord.setRecordId((long)1);
		firstInstanceRecord.setRemarkMsg("认真看一下");
		firstInstanceRecord.setStatus(1);
		//firstInstanceRecord.setUpdateDate(firstInstanceRecord.getCreateDate());
		firstInstanceRecord.setUserId(123);
		firstInstanceRecordDao.save(firstInstanceRecord);
		
		FirstInstanceChangeHistory firstInstanceChangeHistory = new FirstInstanceChangeHistory();
		firstInstanceChangeHistory.setChangeContent("status=2");
		//firstInstanceChangeHistory.setCreateDate(new Timestamp(new Date().getTime()));
		firstInstanceChangeHistory.setEventId(1);
		firstInstanceChangeHistory.setFirId(firstInstanceRecord.getFirId());
		firstInstanceChangeHistory.setRecordId(firstInstanceRecord.getRecordId());
		firstInstanceChangeHistory.setUserId(firstInstanceRecord.getUserId());
		firstInstanceChangeHistoryDao.save(firstInstanceChangeHistory);
		
	}
	
	@Test
	public void sn(){
		System.out.println(SerialNumber.getSerialNum());
		System.out.println(SerialNumber.getSerialNum());
		System.out.println(SerialNumber.getSerialNum());
		System.out.println(SerialNumber.getSerialNum());
		System.out.println(SerialNumber.getSerialNum());
		System.out.println(SerialNumber.getSerialNum());
		System.out.println(SerialNumber.getSerialNum());
		System.out.println(SerialNumber.getSerialNum());
	}

}
