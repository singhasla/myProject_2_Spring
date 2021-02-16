package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	public DownloadView() {
		setContentType("application/download; charset=utf-8");
	}
		
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		File file = (File) model.get("downloadFile");
		
		res.setContentType(getContentType());
		res.setContentLength((int)file.length());
		
		String userAgent = req.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;
		String filename = null;
		
		if(ie){
			filename = URLEncoder.encode(file.getName() , "utf-8");
		}else{
			filename = new String(file.getName().getBytes("utf-8") , "iso-8859-1");
		}
		
		res.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\";");
		res.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = res.getOutputStream();
		
		FileInputStream fis =null;
		
		try {
			fis = new FileInputStream(file);
			
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis !=null){
				try {
					fis.close();
				} catch (Exception e2) {
					
				}
			}
		}
		
		out.flush();
		
	}
	
}
