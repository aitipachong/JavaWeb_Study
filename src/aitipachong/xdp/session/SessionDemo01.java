package aitipachong.xdp.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo01
 */
@WebServlet("/SessionDemo01")
public class SessionDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//ʹ��request�����getSession()��ȡsession�����session�������򴴽�һ��
		HttpSession session = request.getSession();
		//�����ݴ洢��session��
		session.setAttribute("data", "��������");
		//���session��id
		String sessionId = session.getId();
		//�ж�session�Ƿ����½�
		if(session.isNew()) {
			response.getWriter().println("session�����ɹ���session��id�ǣ�" + sessionId);
		} else {
			response.getWriter().println("�������Ѿ����ڸ�session�ˣ�session��id�ǣ�" + sessionId);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
