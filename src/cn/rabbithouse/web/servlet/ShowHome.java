package cn.rabbithouse.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rabbithouse.domain.ArticleOneLevelClass;
import cn.rabbithouse.domain.ArticleTwoLevelClass;
import cn.rabbithouse.domain.BlogContent;
import cn.rabbithouse.service.impl.BlogClassServicesImpl;
import cn.rabbithouse.service.impl.BlogServiceImpl;

/**
 * 显示主页中的文章详情和一二级标分类的信息
 * Servlet implementation class ShowArticleByTotalClass
 */
@WebServlet("/servlet/showHome")
public class ShowHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHome() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BlogClassServicesImpl bcsi = new BlogClassServicesImpl();
		BlogServiceImpl bsi = new BlogServiceImpl();
		ArrayList<ArticleOneLevelClass> oneLevelClass = null;
		ArrayList<ArticleTwoLevelClass> twoLevelClass = null;
		//ArrayList<BlogContent> blogs = null;
		try {
			oneLevelClass =  bcsi.getOneLevelClass();
			twoLevelClass =  bcsi.getTwoLevelClass();
			//blogs = bsi.selectAllBlogContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("twoLevelClass", twoLevelClass);
		request.getSession().setAttribute("oneLevelClass", oneLevelClass);
		//request.setAttribute("totalpage", blogs.size());
		//request.setAttribute("articles", blogs);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
