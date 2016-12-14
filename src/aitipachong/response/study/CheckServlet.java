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
		//接收客户端浏览器提交上来的验证码
		String clientCheckCode = request.getParameter("validateCode");
		//从服务器端的session中取出验证码
		String serverCheckCode = (String)request.getSession().getAttribute("checkcode");
		//将客户端验证码与服务器端验证码比较，如果相等，则验证通过
		if(clientCheckCode.equalsIgnoreCase(serverCheckCode)) {
			System.out.println("验证码验证通过！");
		} else {
			System.out.println("验证码验证失败！");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
