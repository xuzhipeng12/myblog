package cn.rabbithouse.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rabbithouse.domain.BlogContent;
import cn.rabbithouse.service.impl.BlogServiceImpl;

/**
 * Servlet implementation class ListArticles
 */
@WebServlet("/servlet/listArticles")
public class ListArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListArticles() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int currentpage = 1;
		int num = 5;
		int size = 0 ;
		try{
			currentpage = Integer.valueOf(page) - 1;
		}catch(Exception e){}
		BlogServiceImpl bsi = new BlogServiceImpl();
		ArrayList<BlogContent> list = null;
		try {
			 list = bsi.getArticleByPage(currentpage , num);
			 size = bsi.getTotalArticlNum();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("articles", list);
		request.setAttribute("totalpages", (int)Math.ceil(size/(num+0.0)));
		request.setAttribute("currentpage", page);
		request.getRequestDispatcher("/servlet/showHome").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
