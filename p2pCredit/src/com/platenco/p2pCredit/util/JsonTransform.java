package com.platenco.p2pCredit.util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * json与model的转换
   * @author tsh
   * 2016年9月28日 下午2:20:31
 */

public class JsonTransform {
	
	/** 
     * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。 
     * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。 
     * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。 
     * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。 
     * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。 
     * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。 
     */
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static  String modelToJsonString(Object object){
		String jsonString = "";
		try{
			jsonString = mapper.writeValueAsString(object); 
	    	//System.out.println(jsonString);
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		return jsonString;
	}
	
	public static  Object jsonStringToModel(String jsonString, Class clazz){	
		try{
			Object object = clazz.newInstance();
			object = mapper.readValue(jsonString, clazz); 
			return object;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static  String listToJsonString(List list){
		String jsonString = "";
		try{
			jsonString = mapper.writeValueAsString(list); 
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		return jsonString;
	}
	
	public static  <T> T jsonStringToArray(String jsonString, Class<T> objclass){
		try{
			return mapper.readValue(jsonString, objclass);  
		}
		catch(Exception e){
			e.printStackTrace();
	    }
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static  <T> List<T> jsonStringToList(String jsonString, Class<T> clazz)
        throws JsonParseException, JsonMappingException, IOException {
        T[] inst = (T[]) Array.newInstance(clazz, 0);
        T[] models = (T[]) mapper.readValue(jsonString, inst.getClass());
        return Arrays.asList(models);
    }
}
