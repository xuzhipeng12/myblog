package cn.rabbithouse.domain;

import java.util.Date;
/**
 * 博客正文的实体类
 * @author xuzhi
 *
 */
public class BlogContent {
	private String artId;
	private String totalClass;
	private String oneLevelClass;
	private String twoLevelClass;
	private String blogHead;
	private String blogContent;
	private String blogAuthor;
	private Date writeDate;
	private String abstruct;
	private String imgUrl;
	public BlogContent(){}
	public BlogContent(String artId, String totalClass, String oneLevelClass, String twoLevelClass, String blogHead,
			String blogContent, String blogAuthor, Date writeDate,String abstruct,String imgUrl) {
		super();
		this.artId = artId;
		this.totalClass = totalClass;
		this.oneLevelClass = oneLevelClass;
		this.twoLevelClass = twoLevelClass;
		this.blogHead = blogHead;
		this.blogContent = blogContent;
		this.blogAuthor = blogAuthor;
		this.writeDate = writeDate;
		this.imgUrl = imgUrl;
		this.abstruct = abstruct;
	}
	public String getArtId() {
		return artId;
	}
	public void setArtId(String artId) {
		this.artId = artId;
	}
	public String getTotalClass() {
		return totalClass;
	}
	public void setTotalClass(String totalClass) {
		this.totalClass = totalClass;
	}
	public String getOneLevelClass() {
		return oneLevelClass;
	}
	public void setOneLevelClass(String oneLevelClass) {
		this.oneLevelClass = oneLevelClass;
	}
	public String getTwoLevelClass() {
		return twoLevelClass;
	}
	public void setTwoLevelClass(String twoLevelClass) {
		this.twoLevelClass = twoLevelClass;
	}
	public String getBlogHead() {
		return blogHead;
	}
	public void setBlogHead(String blogHead) {
		this.blogHead = blogHead;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public String getBlogAuthor() {
		return blogAuthor;
	}
	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getAbstruct() {
		return abstruct;
	}
	public void setAbstruct(String abstruct) {
		this.abstruct = abstruct;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
