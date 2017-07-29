package cn.rabbithouse.domain;

/**
 * 文章一级分类的实体类
 * @author xuzhipeng
 *
 */
public class ArticleOneLevelClass {
	private String oneLevelId;
	private String oneLevelClass;
	private String clsText;
	public ArticleOneLevelClass(){}
	public ArticleOneLevelClass(String oneLevelId, String oneLevelClass, String clsText) {
		super();
		this.oneLevelId = oneLevelId;
		this.oneLevelClass = oneLevelClass;
		this.clsText = clsText;
	}
	public String getOneLevelId() {
		return oneLevelId;
	}
	public void setOneLevelId(String oneLevelId) {
		this.oneLevelId = oneLevelId;
	}
	public String getOneLevelClass() {
		return oneLevelClass;
	}
	public void setOneLevelClass(String oneLevelClass) {
		this.oneLevelClass = oneLevelClass;
	}
	public String getClsText() {
		return clsText;
	}
	public void setClsText(String clsText) {
		this.clsText = clsText;
	}
}
