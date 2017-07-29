package cn.rabbithouse.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rabbithouse.domain.BlogContent;
import cn.rabbithouse.service.impl.BlogClassServicesImpl;

/**
 * Servlet implementation class ShowArticleByOneLevelClass
 */
@WebServlet("/servlet/showArticleByOneLevelClass")
public class ShowArticleByOneLevelClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArticleByOneLevelClass() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String olc = request.getParameter("olc");
		BlogClassServicesImpl bcsi = new BlogClassServicesImpl();
		BlogContent bc = new BlogContent();
		bc.setOneLevelClass(olc);
		ArrayList<BlogContent> list = null;
		try {
			list = bcsi.getArticleByOneClass(bc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("articles", list);
		request.getRequestDispatcher("/pages/showArticleByOneClass.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
