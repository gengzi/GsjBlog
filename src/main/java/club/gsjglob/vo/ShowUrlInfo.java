package club.gsjglob.vo;

import java.io.Serializable;


/**
 * 收藏网址列表的出参
 * @author gengzi
 * @time 2018年3月31日12:38:10
 *
 */
public class ShowUrlInfo implements Serializable{
	
	//主键id
	private Integer id;
	//父id
	private String parentname;
	//网站的名称
	private String name;
	
	//状态
	private Integer state;
	//更新时间
	private String createtime;
	//当前数量
	private Integer urlnum;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getUrlnum() {
		return urlnum;
	}
	public void setUrlnum(Integer urlnum) {
		this.urlnum = urlnum;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	

}
