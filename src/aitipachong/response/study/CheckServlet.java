package aitipachong.response.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���տͻ���������ύ��������֤��
		String clientCheckCode = request.getParameter("validateCode");
		//�ӷ������˵�session��ȡ����֤��
		String serverCheckCode = (String)request.getSession().getAttribute("checkcode");
		//���ͻ�����֤�������������֤��Ƚϣ������ȣ�����֤ͨ��
		if(clientCheckCode.equalsIgnoreCase(serverCheckCode)) {
			System.out.println("��֤����֤ͨ����");
		} else {
			System.out.println("��֤����֤ʧ�ܣ�");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
