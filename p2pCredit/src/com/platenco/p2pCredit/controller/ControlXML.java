package com.platenco.p2pCredit.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.platenco.p2pCredit.common.ResultCode;
import com.platenco.p2pCredit.dao.NationWideStoresDao;
import com.platenco.p2pCredit.dao.StoreBusinessDataDao;
import com.platenco.p2pCredit.model.NationWideStores;
import com.platenco.p2pCredit.model.StoreBusinessData;
import com.platenco.p2pCredit.util.ExcelUtil;
import com.platenco.p2pCredit.util.Logg;


/**
 * xml操作相关
   * @author tsh
   * 2016年10月10日 上午10:10:24
 */
@Controller
@RequestMapping(value="/file")
public class ControlXML implements ResultCode {
	
	@Resource(name="nationWideStoresDao") 
	private NationWideStoresDao nationWideStoresDao;
	
	@Resource(name="storeBusinessDataDao") 
	private StoreBusinessDataDao storeBusinessDataDao;
	
	private String newXMLFileName = "全国门店BI数据.xlsx"; 
	private String Errormsg = "";
	private Boolean result = true;
	private Integer code = SUCCESS;
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/upXML",method={RequestMethod.POST,RequestMethod.GET}) 
	public @ResponseBody ApiResult<String> upXML(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String LocalPath = request.getServletContext().getRealPath("");
		Logg.writeDebugLog("项目路径:"+LocalPath);
		try{
			//创建一个通用的多部分解析器  
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
			//判断 request 是否有文件上传,即多部分请求  
			if(multipartResolver.isMultipart(request)){  
				//转换成多部分request    
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
				//取得request中的所有文件名  
				Iterator<String> iter = multiRequest.getFileNames();  
				while(iter.hasNext()){  
					//记录上传过程起始时的时间，用来计算上传时间  
					int pre = (int) System.currentTimeMillis();  
					//取得上传文件  
					MultipartFile file = multiRequest.getFile(iter.next());  
					if(file != null){  
						//取得当前上传文件的文件名称  
						String myFileName = file.getOriginalFilename();  
						//如果名称不为“”,说明该文件存在，否则说明该文件不存在  
						if(myFileName.trim() !=""){  
							//System.out.println("当前上传文件名:"+myFileName);  
							Logg.writeDebugLog("当前上传文件名:"+myFileName);
							//重命名上传后的文件名  
							String newFileString = LocalPath+newXMLFileName;
							File localFile = new File(newFileString);  
							if(localFile.exists()){
								Logg.writeInfoLog("文件"+newFileString+"已经存在,对文件进行覆盖");
								file.transferTo(localFile);  
							
							}else{
								file.transferTo(localFile);  
							
							}
							Logg.writeInfoLog("开始解析的文件为:"+newFileString);
							result = true;
							Runnable r = new BackstageRun(newFileString, nationWideStoresDao, storeBusinessDataDao);
							Thread t = new Thread(r);
							t.start();
							
						}else{
							Logg.writeErrorLog("上传文件不存在");
							result = false;
						}
					}  
					//记录上传该文件后的时间  
					int finaltime = (int) System.currentTimeMillis();  
					Logg.writeDebugLog("上传所花时间:"+(finaltime - pre));  
				}  
          
			}  
			if(result == false){
				Errormsg = "上传xml文件失败";
				code = UPLOAD_FILE_ERROR;
			}else{
				Errormsg = "";
				code = SUCCESS;
			}
  
		}catch(Exception e){
			Logg.writeException(e);
			Errormsg = "上传xml文件出现异常";
			code = UPLOAD_FILE_ERROR;
			result = false;
		}finally{
			ApiResult<String> apiResult = new ApiResult<String>("", code, Errormsg, result);
			return apiResult;
		}
		
	}

	
	
	/*
	private String getDataCycle(int blockId){
		if(blockId<0 || blockId>=totalDataBlock){
			Logg.writeErrorLog("blockId("+blockId+")不正确");
			return null;
		}else{
			int year = startYear + blockId/13;
			int month = (blockId!=(totalDataBlock-1))?(blockId+1)%13:0;
			return (year + String.format("%02d", month));
		}
	}
	*/
}

class BackstageRun implements Runnable{
	
	private String newFileString;
	private int totalDataBlock;
	private int startYear;
	
	private NationWideStoresDao nationWideStoresDao;
	private StoreBusinessDataDao storeBusinessDataDao;
	
	BackstageRun(String newFileString, NationWideStoresDao nationWideStoresDao, StoreBusinessDataDao storeBusinessDataDao){
		this.newFileString = newFileString;
		this.nationWideStoresDao = nationWideStoresDao;
		this.storeBusinessDataDao = storeBusinessDataDao;
	}
	
	@Override
	public void run(){
		try{
			parseXMLFile(newFileString);
		}catch(Exception e){
			Logg.writeException(e);
		}
	}
	
	private Boolean parseXMLFile(String fileName) throws Exception{
		ExcelUtil eu = new ExcelUtil();		
		//从第一行开始读取
		eu.setStartReadPos(1);
		//设置不在终端打印日志
		eu.setPrintMsg(false);
		List<Row> rowList;
		try {
			rowList = eu.readExcel(fileName);
			for(int i=0; i<rowList.size(); i++){
			//for(int i=0; i<4; i++){
				Row row = rowList.get(i);
				// 获取每一单元格的值
				String rowString = new String();
				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					//全部用字符串形式处理
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String value = eu.getCellValue(cell);
					if (!value.equals("")) {
						rowString += value + "|";
					}else{
						rowString += "-" + "|";
					}
				}
				//Logg.writeDebugLog("第"+i+"行:"+rowString);
				parseRowString(i, rowString);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 解析每一行数据
	 * @param rowId
	 * @param rowString
	 */
	private void parseRowString(int rowId, String rowString) throws Exception{
		if(rowId == 0){
			String[] fields = rowString.split("\\|");
			startYear = Integer.parseInt(fields[4]);
			totalDataBlock = (fields.length - 4)/5;
			storeBusinessDataDao.getAll();
		}else if(rowId >= 3){
			Logg.writeDebugLog("行数:"+rowId);
			String[] fields = rowString.split("\\|");
			if("-".equals(fields[1]))return;
			NationWideStores nationWideStores = new NationWideStores();
			nationWideStores.setStoreName(fields[0]);
			nationWideStores.setStoreCode(fields[1]);
			nationWideStores.setOpenDate(fields[2]);
			nationWideStores.setCity(fields[3]);
			nationWideStoresDao.load(nationWideStores);
			Logg.writeDebugLog("分店处理完毕");
			storeBusinessDataDao.batchLoad(totalDataBlock, startYear, nationWideStores.getStoreId(), fields);
			
		}
	}
}
