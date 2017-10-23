package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platenco.p2pCredit.dao.SDRoleDao;
import com.platenco.p2pCredit.model.SDRole;
import com.platenco.p2pCredit.util.JsonTransform;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class RoleTest {
	
	@Resource(name="roleDao")  
	private SDRoleDao roleDao;
	
	@Test
	public void getRole(){
		SDRole role = roleDao.get(12);
		System.out.println(role.toString());
		
	}
	
	//@Test
	public String modelToJson(){
		SDRole role = roleDao.get(12);
		System.out.println(role.toString());
		
	    ObjectMapper mapper = new ObjectMapper(); 
	    try{
	    	String json = mapper.writeValueAsString(role); 
	    	System.out.println(json);
	    	
	    	List<SDRole> roles = new ArrayList<SDRole>(); 
	 	    roles.add(role); 
	 	    String jsonlist = mapper.writeValueAsString(roles); 
	 	    System.out.println(jsonlist); 
	 	    
	 	   return jsonlist;
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	    return null;
	}
	
	@Test
	public void jsonToModel(){
		String json = modelToJson();
		if(json != null){
			ObjectMapper mapper = new ObjectMapper(); 
			try{
				SDRole role = mapper.readValue(json, SDRole.class); 
				System.out.println(role.toString()); 
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}
	
	@Test 
	public void mtj(){
		SDRole role = roleDao.get(12);
		System.out.println(role.toString());
		String jsonString = JsonTransform.modelToJsonString(role);
		System.out.println(jsonString);
	}
	
	@Test
	public void jtm(){
		String json = modelToJson();
		if(json != null){
			SDRole role = (SDRole)JsonTransform.jsonStringToModel(json, SDRole.class);
			System.out.println(role.toString());
		}
	}
	
	//@Test
	public String ltj(){
		SDRole role = roleDao.get(12);
		System.out.println(role.toString());
		List<SDRole> roles = new ArrayList<SDRole>(); 
 	    roles.add(role); 
 	    String jsonString = JsonTransform.listToJsonString(roles);
 	   System.out.println(jsonString);
 	   return jsonString;
	}
	
	@Test 
	public void jtl(){
		String jsonString = ltj();
		//SDRole[] arrayRoles = (SDRole[])JsonTransform.jsonStringToArray(jsonString, SDRole[].class);
		//List<SDRole> roles = Arrays.asList(arrayRoles);
		try{
			//roles = mapper.readValue(jsonString, new TypeReference<List<SDRole>>(){});
			List<SDRole> roles = (List<SDRole>)JsonTransform.jsonStringToList(jsonString, SDRole.class);
			System.out.println(roles);
		for(SDRole role : roles){
			System.out.println(role.toString());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		
	}
	
}
