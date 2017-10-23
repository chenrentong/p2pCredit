package com.platenco.p2pCredit.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



/**
 * http消息发送
   * @author tsh
   * 2016年9月28日 下午2:20:06
 */

public class HttpSend {
	
	public static void sendPost(String URL, String jsonString){
		try{  
            //创建连接  
            URL url = new URL(URL);  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setRequestMethod("POST");  
            connection.setUseCaches(false);  
            connection.setInstanceFollowRedirects(true);  
              
            //connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
            connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");         
              
            connection.connect();  
  
            //POST请求  
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());  
            out.write(jsonString.getBytes("UTF-8"));//这样可以处理中文乱码问题  
            out.flush();  
            out.close();  
              
            //读取响应  
            BufferedReader reader = new BufferedReader(new InputStreamReader(  
                    connection.getInputStream()));  
            String lines;  
            StringBuffer sb = new StringBuffer("");  
            while ((lines = reader.readLine()) != null) {  
                lines = new String(lines.getBytes(), "utf-8");  
                sb.append(lines);  
            }  
            System.out.println(sb);  
            reader.close();  
            // 断开连接  
            connection.disconnect();  
        } catch (MalformedURLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
    }  
	
	//上传文件
	public static String upload(String actionUrl, String FileName) throws IOException {
		// 产生随机分隔内容
		String BOUNDARY = java.util.UUID.randomUUID().toString();
		String PREFFIX = "--", LINEND = "\r\n";
		String MULTIPART_FROM_DATA = "multipart/form-data";
		String CHARSET = "UTF-8";
		// 定义URL实例
		URL uri = new URL(actionUrl);
		HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
		// 设置从主机读取数据超时
		conn.setReadTimeout(10 * 1000);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		// 维持长连接
		conn.setRequestProperty("connection", "keep-alive");
		conn.setRequestProperty("Charset", "UTF-8");
		// 设置文件类型
		conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA
			+ ";boundary=" + BOUNDARY);
		// 创建一个新的数据输出流，将数据写入指定基础输出流
		DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
		// 发送文件数据
		if (FileName != null) {
			// 构建发送字符串数据
			StringBuilder sb1 = new StringBuilder();
			sb1.append(PREFFIX);
			sb1.append(BOUNDARY);
			sb1.append(LINEND);
			sb1.append("Content-Disposition: form-data; name=\"file\"; filename=\""
			+ FileName + "\"" + LINEND);
			sb1.append("Content-Type: application/octet-stream;chartset="
			+ CHARSET + LINEND);
			sb1.append(LINEND);
			// 写入到输出流中
			outStream.write(sb1.toString().getBytes());
			// 将文件读入输入流中
			InputStream is = new FileInputStream(FileName);
			byte[] buffer = new byte[1024];
			int len = 0;
			// 写入输出流
			while ((len = is.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			is.close();
			// 添加换行标志
			outStream.write(LINEND.getBytes());
		}
		// 请求结束标志
		byte[] end_data = (PREFFIX + BOUNDARY + PREFFIX + LINEND).getBytes();
		outStream.write(end_data);
		// 刷新发送数据
		outStream.flush();
		// 得到响应码
		int res = conn.getResponseCode();


		InputStream in = null;
		// 上传成功返回200
		if (res == 200) {
			in = conn.getInputStream();
			int ch;
			StringBuilder sb2 = new StringBuilder();
			// 保存数据
			while ((ch = in.read()) != -1) {
				sb2.append((char) ch);
			}
		}
		// 如果数据不为空，则以字符串方式返回数据，否则返回null
		return in == null ? null : in.toString();
	}

}

