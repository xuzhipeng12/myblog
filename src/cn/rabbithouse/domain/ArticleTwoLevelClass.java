package cn.rabbithouse.domain;

/**
 * 二级文章分类的实体
 * @author xuzhipeng
 *
 */
public class ArticleTwoLevelClass {
	private String oneLevelId;
	private String twoLevelId;
	private String twoLevelClass;
	private String clsText;
	public ArticleTwoLevelClass(){}
	public ArticleTwoLevelClass(String oneLevelId, String twoLevelId, String twoLevelClass, String clsText) {
		super();
		this.oneLevelId = oneLevelId;
		this.twoLevelId = twoLevelId;
		this.twoLevelClass = twoLevelClass;
		this.clsText = clsText;
	}
	public String getOneLevelId() {
		return oneLevelId;
	}
	public void setOneLevelId(String oneLevelId) {
		this.oneLevelId = oneLevelId;
	}
	public String getTwoLevelId() {
		return twoLevelId;
	}
	public void setTwoLevelId(String twoLevelId) {
		this.twoLevelId = twoLevelId;
	}
	public String getTwoLevelClass() {
		return twoLevelClass;
	}
	public void setTwoLevelClass(String twoLevelClass) {
		this.twoLevelClass = twoLevelClass;
	}
	public String getClsText() {
		return clsText;
	}
	public void setClsText(String clsText) {
		this.clsText = clsText;
	}
	
}
