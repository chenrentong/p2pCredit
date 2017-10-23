package com.platenco.p2pCredit.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * 流水号生成
   * @author tsh
   * 2016年10月10日 下午3:15:42
 */
public class SerialNumber {
	
	private static String timeFormat="yyyyMMddhhmmss";
	private static Long frontSN = (long)0;
	
	public static synchronized Long getSerialNum(){
		Long timeLong = getTime();
		if(frontSN != 0 && frontSN/1000 == timeLong){
			frontSN += 1;
		}else{
			Random random = new Random();
			frontSN = timeLong*1000 + random.nextInt(100);
		}
		return frontSN;
	}
	
	private static Long getTime(){
		SimpleDateFormat format=new SimpleDateFormat(timeFormat);  
        Date date=new Date();  
        String timeString = format.format(date);  
        return Long.parseLong(timeString);
	}

}
