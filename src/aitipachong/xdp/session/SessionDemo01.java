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
		
		//使用request对象的getSession()获取session，如果session不存在则创建一个
		HttpSession session = request.getSession();
		//将数据存储到session中
		session.setAttribute("data", "挨踢爬虫");
		//获得session的id
		String sessionId = session.getId();
		//判断session是否是新建
		if(session.isNew()) {
			response.getWriter().println("session创建成功，session的id是：" + sessionId);
		} else {
			response.getWriter().println("服务器已经存在该session了，session的id是：" + sessionId);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
