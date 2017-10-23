package com.platenco.p2pCredit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.platenco.p2pCredit.common.ResultCode;
import com.platenco.p2pCredit.dao.ReqImageDataDao;
import com.platenco.p2pCredit.model.ReqImageData;
import com.platenco.p2pCredit.util.Logg;

/**
 * 文件上传下载
   * @author tsh
   * 2016年9月29日 下午5:08:53
 */

@Controller
@RequestMapping(value="/file")
public class ControlUpload implements ResultCode{
	
	@Resource(name="reqImageDataDao")
	private ReqImageDataDao reqImageDataDao;
	
	private String LocalPath = "";
	
	
	private String Errormsg = "";
	private Boolean result = true;
	private Integer code = SUCCESS;
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/upload",method={RequestMethod.POST,RequestMethod.GET}) 
	public @ResponseBody ApiResult<String> upload(HttpServletRequest request,HttpServletResponse response){
		try{
			LocalPath = request.getServletContext().getRealPath("");
			Logg.writeDebugLog("项目路径:"+LocalPath);
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
							//解析文件名确认存储目录
							ReqImageData reqImageData = reqImageDataDao.parseFileName(myFileName, LocalPath);
							if(reqImageData == null){
								result = false;
								break;
							}
							//重命名上传后的文件名  
							String newFileString = reqImageData.getImagePath() + reqImageData.getImageName();
							File localFile = new File(newFileString);  
							if(localFile.exists()){
								file.transferTo(localFile);  
								ReqImageData updateReqImageData = reqImageDataDao.getForInfo(reqImageData);
								result = reqImageDataDao.update(updateReqImageData);
							}else{
								file.transferTo(localFile);  
								reqImageDataDao.save(reqImageData);
							}
						}  
					}  
					//记录上传该文件后的时间  
					int finaltime = (int) System.currentTimeMillis();  
					Logg.writeDebugLog("上传所花时间:"+(finaltime - pre));  
				}  
              
			}  
			if(result == false){
				Errormsg = "上传文件失败";
				code = UPLOAD_FILE_ERROR;
			}else{
				Errormsg = "";
				code = SUCCESS;
			}
      
			}catch(Exception e){
				Logg.writeException(e);
				Errormsg = "上传文件出现异常";
				code = UPLOAD_FILE_ERROR;
				result = false;
			}finally{
				ApiResult<String> apiResult = new ApiResult<String>("", code, Errormsg, result);
				return apiResult;
			}
    } 
	
	@RequestMapping("/download")
	public String download(String fileName, HttpServletRequest request, HttpServletResponse response) {
		LocalPath = request.getServletContext().getRealPath("");
		Logg.writeDebugLog("项目路径:"+LocalPath);
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="+ fileName);
		
		long imageId = 6;

		try {
			ReqImageData reqImageData = reqImageDataDao.get(imageId);
			String pathString = reqImageData.getImagePath()+reqImageData.getImageName();
			InputStream inputStream = new FileInputStream(new File(pathString));
			/*
			String path = Thread.currentThread().getContextClassLoader()
					.getResource("").getPath() + "download";//这个download目录为啥建立在classes下的
			InputStream inputStream = new FileInputStream(new File(path
					+ File.separator + fileName));
			*/
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}

			 // 这里注意关闭。
			os.close();

			inputStream.close();
		} catch (FileNotFoundException e) {
			Logg.writeException(e);
		} catch (IOException e) {
			Logg.writeException(e);
		} catch (Exception e){
			Logg.writeException(e);
		}
            //  返回值要注意，要不然就出现下面这句错误！
            //java+getOutputStream() has already been called for this response
		return null;
	}

}
