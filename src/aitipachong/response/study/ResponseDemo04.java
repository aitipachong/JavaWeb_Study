package aitipachong.response.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo04
 */
@WebServlet("/ResponseDemo04")
public class ResponseDemo04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.����sendRedirect����ʵ�������ض���
		 * sendRedirect�����ڲ�������
		 * response.setHeader("Location", "/JavaWeb_Study/index.jsp");
		 * response.setStatus(HttpServletResponse.SC_FOUND);	//����302״̬�룬��ͬ��response.setStatus(302);
		 */
		response.sendRedirect("/JavaWeb_Study/index.jsp");
		
		//2.ʹ��response����302״̬�������location��Ӧͷʵ���ض���ʵ�������ض���
		//response.setHeader("Location", "/JavaWeb_HttpServletResponse_Study_20140615/index.jsp");
		//response.setStatus(HttpServletResponse.SC_FOUND);//����302״̬�룬��ͬ��response.setStatus(302);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
