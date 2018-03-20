package club.gsjglob.vo;

import java.io.Serializable;


/**
 * 标签实体，出参的参数
 * @author Administrator
 *
 */
public class TagsAll implements Serializable{
	
	//标签名字
	private String tagName;
	//标签名字对应的个数
	private Integer tagNameNum;
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Integer getTagNameNum() {
		return tagNameNum;
	}
	public void setTagNameNum(Integer tagNameNum) {
		this.tagNameNum = tagNameNum;
	}
}
