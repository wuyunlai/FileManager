/**
 * @author wuyl
 *
 */
package com.wyl.common.util.file.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wyl.env.spring.SpringContext;
import com.wyl.file.dao.FileAttachList;
import com.wyl.file.dao.FileAttachListDAO;

public class FileManager extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		String transactionType = request.getParameter("transactionType");
		String transactionId = request.getParameter("transactionId");
		String pid = request.getParameter("pid");
		String unitid = request.getParameter("unitid");
		String userid = request.getParameter("userid");
		String compress = request.getParameter("compress");
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart) {
				String tmp = this.getServletContext().getRealPath("/temporary files");//临时目录
				String up = this.getServletContext().getRealPath("/UploadFiles");//上传目录
				//检查创建临时目录
				File f1 = new File(tmp);
				if(!f1.exists()) {
					f1.mkdirs();
				}
				//检查创建上传目录
				File f2 = new File(up);
				if(!f2.exists()) {
					f2.mkdirs();
				}
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(10*2014);
				factory.setRepository(new File(tmp));
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("utf-8");//防止文件名中文乱码
				List items = upload.parseRequest(request);
				Iterator it = items.iterator();
				String html = "";
				//遍历处理表单属性，是文件则上传到服务器
				while (it.hasNext()) {
					FileItem item=(FileItem)it.next();//每一个item就代表一个表单输出项
					
					if(item.isFormField()){//判断input是否为普通表单输入项
						String name=item.getFieldName();//input的名称
						String value= item.getString();//input的值
						System.out.print(name+":"+value);
					}else{//文件输入项
						//得到上传文件的名称,并截取
						String filename=getFileNameFromFileItem(item);
						
						if(!filename.equals("") && item.getSize()!=0){
							//得到上传文件要写入的目录
							String path=up;
							//根据目录和文件创建输出流
							
							String uids = java.util.UUID.randomUUID().toString();
//							FileOutputStream out=new FileOutputStream(path+"/"+filename);
							FileOutputStream out=new FileOutputStream(path+"/"+uids);
							GZIPOutputStream gout = new GZIPOutputStream(out);
							
							//读取文件流并输出
							InputStream in = item.getInputStream();
							byte buffer[] = new byte[1024];
							int len = 0;
							BigDecimal fileSize = new BigDecimal(0);
							while((len=in.read(buffer))>0){
								gout.write(buffer,0,len);
								fileSize = fileSize.add(new BigDecimal(len));
							}
							gout.finish();
							//关闭文件流
							gout.close();
							in.close();
							out.close();
							
							FileAttachList fal = new FileAttachList();
							fal.setUids(java.util.UUID.randomUUID().toString());
							fal.setFileLsh(uids);
							fal.setFileName(filename);
							fal.setFileSize(fileSize.longValue());
							fal.setIsCompress(compress);
							fal.setFileType("1");
							fal.setTransactionType("1");
							fal.setTransactionId("1");
							fal.setFilesource("file");
							fal.setBlobTable(up);
							fal.setDeptId("1");
							fal.setPid("1");
							fal.setUnitId("1");
							fal.setUserid("1");
							FileAttachListDAO falDAO = (FileAttachListDAO)SpringContext.getBean("FileAttachListDAO");
							falDAO.save(fal);
						}
					}
				}
/*				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.write("<meta http-equiv='content-type' content='text/html; charset=UTF-8'>" +
						"<a href='/FileManager'>文件上传成功</a>");
				out.write(html);
				out.write("<script>");
				out.write("try{parent.loadFileGrid();parent.closeUploadWin();}catch(ex){}");
				out.write("</script>");
				out.close();*/
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		doGet(request, response);
	}
	
	/**
	 * @author wuyl
	 * 获取FileItem的文件名
	 */
	private String getFileNameFromFileItem(FileItem p_item) {
		String filename = null;
		try {
			File f = new File(p_item.getName());
			filename = f.getName();
//			System.out.println(filename);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return filename;
	}
}
