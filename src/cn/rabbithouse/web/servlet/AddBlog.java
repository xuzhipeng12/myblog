package cn.rabbithouse.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rabbithouse.domain.BlogContent;
import cn.rabbithouse.service.impl.BlogServiceImpl;

/**
 * Servlet implementation class AddBlog
 */
@WebServlet("/servlet/addBlog")
public class AddBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBlog() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//��ȡ������
		Date date = new Date();
		String id = date.getYear()+""+date.getMonth()+""+date.getDay()+""+date.getHours()+""+date.getMinutes();
		String author = "ĳͬѧ";
		try{
			author = (String) request.getSession().getAttribute("usrname");
		}catch(Exception e){}
		BlogContent bc = new BlogContent(
				id,
				request.getParameter("contextTotalType"), 
				request.getParameter("oneLevelClass"),
				request.getParameter("twoLevelClass"), 
				request.getParameter("contextHead"),
				request.getParameter("myckeditor"), 
				author, 
				date,
				request.getParameter("abstruct"),
				getImgUrl(request.getParameter("myckeditor"))
				);
		//����ҵ���߼�
		BlogServiceImpl bs = new BlogServiceImpl();
		try {
			bs.addBlog(bc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//�ַ�ת��
		response.getWriter().write("����ɹ���2���ת����ҳ��");
		response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//��ȡ�����м��ͼƬ��ַ
	public String getImgUrl(String str){
		String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
		String regEx_url = "src\\s*=\\s*\"?(.*?)(\"|>|\\s+)";
		Matcher mImg =	Pattern.compile(regEx_img).matcher(str);
		String url = "";
		if(mImg.find()){
			String img = mImg.group(0);
			Matcher mUrl = Pattern.compile(regEx_url).matcher(img);
			if(mUrl.find())
				url = mUrl.group(0);
		}
		return url;
	}
}
