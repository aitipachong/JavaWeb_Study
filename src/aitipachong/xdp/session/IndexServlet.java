package aitipachong.xdp.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建Session
		request.getSession();
		out.write("本网站有如下数：<br/>");
		Set<Map.Entry<String, Book>> set = DB.getAll().entrySet();
		for(Map.Entry<String, Book> me : set) {
			Book book = me.getValue();
			String url = request.getContextPath() + "/BuyServlet?id=" + book.getId();
			//response.encodeURL(java.lang.String url)用于对表单action和超链接的url地址进行重写
			url = response.encodeUrl(url);		//将超链接的url地址进行重写
			out.println(book.getName() + "  <a href='" + url + "'>购买</a><br/>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}