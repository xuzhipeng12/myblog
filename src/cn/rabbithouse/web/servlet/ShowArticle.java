package cn.rabbithouse.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rabbithouse.domain.BlogContent;
import cn.rabbithouse.domain.LeaveSay;
import cn.rabbithouse.service.impl.BlogLeaveSayServiceImpl;
import cn.rabbithouse.service.impl.BlogServiceImpl;

/**
 * Servlet implementation class ShowArticle
 */
@WebServlet("/servlet/showArticle")
public class ShowArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArticle() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取传递过来的文章id
		String id = request.getParameter("id");
		BlogContent bc = new BlogContent();
		BlogServiceImpl bs = new BlogServiceImpl();
		BlogLeaveSayServiceImpl blss = new BlogLeaveSayServiceImpl();
		ArrayList<BlogContent> list = null;
		ArrayList<LeaveSay> leaveSays = null;
		bc.setArtId(id);
		try {
			//通过id查找文章 
			 list = bs.getArticleById(bc);
			 leaveSays = blss.getLeaveSayByArtId(bc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("article", list.get(0));
		request.setAttribute("leaveSay", leaveSays);
		request.getRequestDispatcher("/pages/showArticle.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
