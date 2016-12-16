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
		//客户端是以UTF-8编码传输数据到服务器端的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		*/
		try {
			//让当前的线程睡眠3秒，模拟网路延迟而导致表单重复提交的现象
			Thread.sleep(3 * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		/*
		System.out.println("向数据库中插入数据：" + userName);
		*/
		
		boolean b = isRepeatSubmit(request);
		if(b == true) {
			System.out.println("请不要重复提交");
			return;
		}
		
		//提交前或后，清楚服务器端的Token
		request.getSession().removeAttribute("token");
		System.out.println("处理用户提交请求！！");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
	 * @param reqeust
	 * @return
	 * 			true 用户重复提交了表单
	 * 			false 用户没有重复提交表单
	 */
	private boolean isRepeatSubmit(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		//如果用户提交的表单数据中没有token，则用户是重复提交了表单
		if(null == client_token) {
			return true;
		}
		
		//取出存储的Session中的token
		String server_token = (String) request.getSession().getAttribute("token");
		//如果当前用户的Session中不存在Token，则用户重复提交了表单
		if(null == server_token) {
			return true;
		}
		
		//存储在Session中的Token与表单提交的Token不同，则用户是重复提交了表单
		if(!client_token.equals(server_token)) {
			return true;
		}
		
		return false;
	}
}