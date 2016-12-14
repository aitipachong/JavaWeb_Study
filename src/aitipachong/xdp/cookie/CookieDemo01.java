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
		//设置服务器端以UTF-8编码进行输出
		response.setCharacterEncoding("UTF-8");
		//设置浏览器以UTF-8编码进行接收，解决中文乱码问题 
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		//获取浏览器访问服务器时传递过来的cookie数组
		Cookie[] cookies = request.getCookies();
		//如果用户是第一次访问，那么得到的cookies将是null
		if(null != cookies) {
			out.write("您上次访问的时间是：");
			for(int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("lastAccessTime")) {
					Long lastAccessTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastAccessTime);
					out.write(date.toLocaleString());
				}
			}
		} else {
			out.write("这是您第一次访问本站！");
		}
		
		//用户访问过之后，重新设置用户的访问时间，存储到cookie中，然后发送到客户端浏览器
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");	//创建一个Cookie，cookie的名字是lastAccessTime
		//设置Cookie有效期为1天
		cookie.setMaxAge(24 * 60 * 60);
		//将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时就会把cookie也输出到客户端浏览器
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
