package test;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platenco.p2pCredit.dao.NationWideStoresDao;
import com.platenco.p2pCredit.dao.StoreBusinessDataDao;
import com.platenco.p2pCredit.model.NationWideStores;
import com.platenco.p2pCredit.model.StoreBusinessData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class BIStoresTest {
	
	@Resource(name="nationWideStoresDao") 
	private NationWideStoresDao nationWideStoresDao;
	
	@Resource(name="storeBusinessDataDao") 
	private StoreBusinessDataDao storeBusinessDataDao;
	
	@Test
	public void save() throws Exception{
		NationWideStores nationWideStores = nationWideStoresDao.getForStoreCode("1");
		if(nationWideStores == null){
			nationWideStores = new NationWideStores();
			nationWideStores.setCity("广州");
			nationWideStores.setCreateDate(new Timestamp(new Date().getTime()));
			nationWideStores.setOpenDate("2016-01-01");
			nationWideStores.setStoreCode("1");
			nationWideStores.setStoreName("测试店");
			nationWideStoresDao.save(nationWideStores);
		}
		
		StoreBusinessData storeBusinessData = storeBusinessDataDao.getForStoreIdAndDataCycle(nationWideStores.getStoreId(), "201201");
		if(storeBusinessData == null){
			storeBusinessData = new StoreBusinessData();
			storeBusinessData.setCreateDate(new Timestamp(new Date().getTime()));
			storeBusinessData.setDataCycle("201201");
			storeBusinessData.setOpenRoomRate("0.48");
			storeBusinessData.setOpenRooms(120);
			storeBusinessData.setOperatingIncome((long)1300000);
			storeBusinessData.setRooms(300);
			storeBusinessData.setStoreId(nationWideStores.getStoreId());
			storeBusinessData.setTtv((long)1212);
			storeBusinessDataDao.save(storeBusinessData);
		}
		
		
	}

}
