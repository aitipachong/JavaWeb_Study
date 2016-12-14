package aitipachong.request.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo01
 */
@WebServlet("/RequestDemo01")
public class RequestDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.��ÿͻ�����Ϣ
		 */
		String requestUrl = request.getRequestURL().toString();		//��������URL��ַ
		String requestUri = request.getRequestURI();				//�õ��������Դ
		String queryString = request.getQueryString();				//�õ������URL��ַ�и����Ĳ���
		String remoteAddr = request.getRemoteAddr();				//�õ������ߵ�IP��ַ
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		String method = request.getMethod();						//�õ�����URL��ַʱʹ�õķ���
		String pathInfo = request.getPathInfo();
		String localAddr = request.getLocalAddr();					//���WEB��������IP��ַ
		String localName = request.getLocalName();					//���WEB��������������
		
		response.setCharacterEncoding("UTF-8");
		//ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ���ݣ����������仰����ô�������ʾ�Ľ�������
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	    out.write("��ȡ���Ŀͻ�����Ϣ���£�");
	    out.write("<hr/>");
	    out.write("�����URL��ַ��"+requestUrl);
	    out.write("<br/>");
	    out.write("�������Դ��"+requestUri);
	    out.write("<br/>");
	    out.write("�����URL��ַ�и����Ĳ�����"+queryString);
	    out.write("<br/>");
	    out.write("�����ߵ�IP��ַ��"+remoteAddr);
	    out.write("<br/>");
	    out.write("�����ߵ���������"+remoteHost);
	    out.write("<br/>");
	    out.write("ʹ�õĶ˿ںţ�"+remotePort);
	    out.write("<br/>");
	    out.write("remoteUser��"+remoteUser);
	    out.write("<br/>");
	    out.write("����ʹ�õķ�����"+method);
	    out.write("<br/>");
	    out.write("pathInfo��"+pathInfo);
	    out.write("<br/>");
	    out.write("localAddr��"+localAddr);
	    out.write("<br/>");
	    out.write("localName��"+localName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
