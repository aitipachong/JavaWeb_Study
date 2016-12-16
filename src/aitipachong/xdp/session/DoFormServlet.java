package aitipachong.xdp.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoFormServlet
 */
@WebServlet("/DoFormServlet")
public class DoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		//�ͻ�������UTF-8���봫�����ݵ��������˵ģ�������Ҫ���÷���������UTF-8�ı�����н��գ���������������ݾͻ��������
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		*/
		try {
			//�õ�ǰ���߳�˯��3�룬ģ����·�ӳٶ����±��ظ��ύ������
			Thread.sleep(3 * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		/*
		System.out.println("�����ݿ��в������ݣ�" + userName);
		*/
		
		boolean b = isRepeatSubmit(request);
		if(b == true) {
			System.out.println("�벻Ҫ�ظ��ύ");
			return;
		}
		
		//�ύǰ�������������˵�Token
		request.getSession().removeAttribute("token");
		System.out.println("�����û��ύ���󣡣�");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * �жϿͻ����ύ���������ƺͷ����������ɵ������Ƿ�һ��
	 * @param reqeust
	 * @return
	 * 			true �û��ظ��ύ�˱�
	 * 			false �û�û���ظ��ύ��
	 */
	private boolean isRepeatSubmit(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		//����û��ύ�ı�������û��token�����û����ظ��ύ�˱�
		if(null == client_token) {
			return true;
		}
		
		//ȡ���洢��Session�е�token
		String server_token = (String) request.getSession().getAttribute("token");
		//�����ǰ�û���Session�в�����Token�����û��ظ��ύ�˱�
		if(null == server_token) {
			return true;
		}
		
		//�洢��Session�е�Token����ύ��Token��ͬ�����û����ظ��ύ�˱�
		if(!client_token.equals(server_token)) {
			return true;
		}
		
		return false;
	}
}