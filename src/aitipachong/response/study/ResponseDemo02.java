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
	 * �����ļ���ͨ��OutputStream��
	 * @param response
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void downloadFileByOutputStream(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		//1.��ȡҪ���ص��ļ��ľ���·��
		String realPath = this.getServletContext().getRealPath("/download/1.jpg");
		//2.��ȡҪ���ص��ļ���
		String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
		//3.����content-disposition��Ӧͷ��������������ص���ʽ���ļ�
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		//4.��ȡҪ���ص��ļ�������
		InputStream in = new FileInputStream(realPath);
		int len = 0;
		//5.�������ݻ�����
		byte[] buffer = new byte[1024];
		//6.ͨ��response�����ȡOutputStream��
		OutputStream out = response.getOutputStream();
		//7.��FileInputStream��д�뵽buffer������
		while((len= in.read(buffer)) > 0) {
			//8.ʹ��OutputStream��������������������ͻ��������
			out.write(buffer, 0, len); 
		}
		in.close();
	}
	
	/**
	 * ���������ļ��������ļ�����ʱ���ļ���Ҫ����URL���룬���������ļ�������
	 * @param response
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void downloadChineseFileByOutputStream(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		String realPath = this.getServletContext().getRealPath("/download/�żҽ����ɭ�ֹ�԰.jpg");
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
