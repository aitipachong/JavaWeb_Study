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
		//�ͻ�������UTF-8���봫�����ݵ��������˵ģ�������Ҫ���÷���������UTF-8�ı�����н��գ���������������ݾͻ��������
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		try {
			//�õ�ǰ���߳�˯��3�룬ģ����·�ӳٶ����±��ظ��ύ������
			Thread.sleep(3 * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("�����ݿ��в������ݣ�" + userName);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
