package aitipachong.response.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo02
 */
@WebServlet("/ResponseDemo02")
public class ResponseDemo02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.downloadFileByOutputStream(response);
		this.downloadChineseFileByOutputStream(response);
	}

	/**
	 * 下载文件，通过OutputStream流
	 * @param response
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void downloadFileByOutputStream(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		//1.获取要下载的文件的绝对路径
		String realPath = this.getServletContext().getRealPath("/download/1.jpg");
		//2.获取要下载的文件名
		String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
		//3.设置content-disposition响应头控制浏览器以下载的形式打开文件
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		//4.获取要下载的文件输入流
		InputStream in = new FileInputStream(realPath);
		int len = 0;
		//5.创建数据缓冲区
		byte[] buffer = new byte[1024];
		//6.通过response对象获取OutputStream流
		OutputStream out = response.getOutputStream();
		//7.将FileInputStream流写入到buffer缓冲区
		while((len= in.read(buffer)) > 0) {
			//8.使用OutputStream将缓冲区的数据输出到客户端浏览器
			out.write(buffer, 0, len); 
		}
		in.close();
	}
	
	/**
	 * 下载中文文件，中文文件下载时，文件名要经过URL编码，否则会出现文件名乱码
	 * @param response
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void downloadChineseFileByOutputStream(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		String realPath = this.getServletContext().getRealPath("/download/张家界国家森林公园.jpg");
		String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		InputStream in = new FileInputStream(realPath);
		int len = 0;
		byte[] buffer = new byte[1024];
		OutputStream out = response.getOutputStream();
		while((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		in.close();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
