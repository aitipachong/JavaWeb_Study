package aitipachong.xdp.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo01
 */
@WebServlet("/CookieDemo01")
public class CookieDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���÷���������UTF-8����������
		response.setCharacterEncoding("UTF-8");
		//�����������UTF-8������н��գ���������������� 
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		//��ȡ��������ʷ�����ʱ���ݹ�����cookie����
		Cookie[] cookies = request.getCookies();
		//����û��ǵ�һ�η��ʣ���ô�õ���cookies����null
		if(null != cookies) {
			out.write("���ϴη��ʵ�ʱ���ǣ�");
			for(int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("lastAccessTime")) {
					Long lastAccessTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastAccessTime);
					out.write(date.toLocaleString());
				}
			}
		} else {
			out.write("��������һ�η��ʱ�վ��");
		}
		
		//�û����ʹ�֮�����������û��ķ���ʱ�䣬�洢��cookie�У�Ȼ���͵��ͻ��������
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");	//����һ��Cookie��cookie��������lastAccessTime
		//����Cookie��Ч��Ϊ1��
		cookie.setMaxAge(24 * 60 * 60);
		//��cookie������ӵ�response�����У����������������response�����е�����ʱ�ͻ��cookieҲ������ͻ��������
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
