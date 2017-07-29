package cn.rabbithouse.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rabbithouse.domain.LeaveSay;
import cn.rabbithouse.service.impl.BlogLeaveSayServiceImpl;

/**
 * Servlet implementation class AddLeaveSay
 */
@WebServlet("/servlet/addLeaveSay")
public class AddLeaveSay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLeaveSay() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Date date = new Date();
		LeaveSay ls = new LeaveSay(
				request.getParameter("id"),
				request.getParameter("leaveSays"), 
				request.getParameter("whoLeave"), 
				date.toLocaleString());
		BlogLeaveSayServiceImpl blss = new BlogLeaveSayServiceImpl();
		try {
			blss.addLeaveSay(ls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print("留言成功！2后跳转回原文章");
		response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/showArticle?id="+request.getParameter("id"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
