package test;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platenco.p2pCredit.common.StatusCode;
import com.platenco.p2pCredit.dao.LastInstanceChangeHistoryDao;
import com.platenco.p2pCredit.dao.LastInstanceRecordDao;
import com.platenco.p2pCredit.model.LastInstanceChangeHistory;
import com.platenco.p2pCredit.model.LastInstanceRecord;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class LastInstanceTest implements StatusCode{
	
	@Resource(name="lastInstanceRecordDao") 
	private LastInstanceRecordDao lastInstanceRecordDao;
	
	@Resource(name="lastInstanceChangeHistoryDao") 
	private LastInstanceChangeHistoryDao lastInstanceChangeHistoryDao;
	
	@Test
	public void save() throws Exception{
		LastInstanceRecord lastInstanceRecord = new LastInstanceRecord();
		lastInstanceRecord.setCreateDate(new Timestamp(new Date().getTime()));
		lastInstanceRecord.setLendingRates("5%");
		lastInstanceRecord.setLoanCreditAuto((long)100000);
		lastInstanceRecord.setLoanCreditFinal((long)200000);
		lastInstanceRecord.setOpinionMsg("比较可行");
		lastInstanceRecord.setPayBackType("分月返还");
		lastInstanceRecord.setRecordId((long)6);
		lastInstanceRecord.setStatus(IN_LAST_INSTANCE);
		lastInstanceRecord.setUpdateDate(new Timestamp(new Date().getTime()));
		lastInstanceRecord.setUserId(123);
		lastInstanceRecordDao.save(lastInstanceRecord);
		
		LastInstanceChangeHistory lastInstanceChangeHistory = new LastInstanceChangeHistory();
		lastInstanceChangeHistory.setChangeContent("status=4");
		lastInstanceChangeHistory.setCreateDate(new Timestamp(new Date().getTime()));
		lastInstanceChangeHistory.setEventId(1);
		lastInstanceChangeHistory.setLirId(lastInstanceRecord.getLirId());
		lastInstanceChangeHistory.setRecordId(lastInstanceRecord.getRecordId());
		lastInstanceChangeHistory.setUserId(lastInstanceRecord.getUserId());
		lastInstanceChangeHistoryDao.save(lastInstanceChangeHistory);
		
	}
}
