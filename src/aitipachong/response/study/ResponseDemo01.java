package aitipachong.response.study;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo01
 */
@WebServlet("/ResponseDemo01")
public class ResponseDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.outputChineseByOutputStream(response);
		//this.outputChineseByPrintWriter(response);
		//this.outputOneByOutputStream(response);
		this.outputOneByPrintWriter(response);
	}

	/**
	 * ʹ��OutputStream���������
	 * @param response
	 * @throws IOException 
	 */
	public void outputChineseByOutputStream(HttpServletResponse response) throws IOException {
		/**
		 * ʹ��OutputStream�������ע�����⣺
		 * �ڷ������ˣ����������ĸ��������ģ���ô��Ҫ���ƿͻ������������Ӧ�����򿪣�
		 * ���磺outputStream.write("�й�".getBytes("UTF-8"));	//ʹ��OutputStream����ͻ��������������ģ���UTF-8�ı���������
		 * ��ʱ��Ҫ���ƿͻ����������UTF-8�ı���򿪣�������ʾ��ʱ��ͻ�����������룬��ô�ڷ���������ο��ƿͻ����������UTF-8�ı�����ʾ�����أ�
		 * ����ͨ��������Ӧͷ�������������Ϊ�����磺
		 * response.setHeader("content-type", "text/html;charset=UTF-8");	//ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ����
		 */
		String data = "�й�";
		OutputStream outputStream = response.getOutputStream();	//��ȡOutputStream����
		response.setHeader("content-type",  "text/html;charset=utf-8");
		/**
		 * data.getBytes()��һ�����ַ�ת�����ֽ�����Ĺ��̣����������һ����ȥ�����
		 * ��������ĵĲ���ϵͳ������Ĭ�Ͼ��ǲ���GB2312�����
		 * ���ַ�ת�����ֽ�����Ĺ��̾��ǽ������ַ�ת����GB2312������϶�Ӧ������
		 * ���磺���С���GB2312������϶�Ӧ��������98
		 * 		��������GB2312������϶�Ӧ��������99
		 * 
		 * getBytes()�������������������ô�ͻ���ݲ���ϵͳ�����Ի�����ѡ��ת�������������Ĳ���ϵͳ����ô�ͻ�ʹ��GB2312�����
		 */
		byte[] dataByteArr = data.getBytes("UTF-8");
		outputStream.write(dataByteArr);
	}

	public void outputChineseByPrintWriter(HttpServletResponse response) throws IOException {
		String data = "�й�";
		
		//ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ���ݣ����������仰����ô�������ʾ�Ľ�������
		//response.setHeader("content-type", "text/html;charset=UTF-8");
		
		//���ý��ַ��ԡ�utf-8������������ͻ��������
		response.setCharacterEncoding("UTF-8");
		
		/**
		 * PrintWriter out = response.getWriter();������������response.setCharacterEncoding("UTF-8");֮��
		 * ����response.setCharacterEncoding("UTF-8")���д�������ý���Ч���������ʾ��ʱ��������
		 */
		//��ȡPrintWriter�����
		PrintWriter out = response.getWriter();
		
		/**
         * ��ѧһ�У�ʹ��HTML���������<meta>��ǩ�������������Ϊ��ģ��ͨ��������Ӧͷ�����������Ϊ
         * out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
         * ��ͬ��response.setHeader("content-type", "text/html;charset=UTF-8"); 
		 */
		out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		//ʹ��PrintWriter����ͻ�������ַ�
		out.write(data);
	}
	
	/**
	 * ʹ��OutputStream���������1
	 * @param response
	 * @throws IOException
	 */
	public void outputOneByOutputStream(HttpServletResponse response) throws IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write("ʹ��OutputStream���������1��".getBytes("UTF-8"));
		//outputStream.write(1);
		outputStream.write((1+"").getBytes());
	}

	
	public void outputOneByPrintWriter(HttpServletResponse response) throws IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write("ʹ��PrintWriter���������1��");
		out.write(1+"");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
