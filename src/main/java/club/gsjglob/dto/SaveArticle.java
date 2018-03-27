package club.gsjglob.dto;

import java.io.Serializable;

/**
 * 保存文章信息的入参实体
 * 
 * @author gengzi
 * @time 2018年3月21日17:50:02
 *
 */
public class SaveArticle implements Serializable {
	// 文章标题
	private String title;
	// 文章内容
	private String content;
	// 文章的类型 1， 原创 2，转载 ，3 翻译
	private Integer type;
	// 博客分类
	private Integer folderId;
	// 创建的作者
	private Integer createId;
	// 文章对应的标签 , 以逗号分割的标签
	private String articleTags;
	// 发布的用户
	private String publishUser;

	public String getPublishUser() {
		return publishUser;
	}

	public void setPublishUser(String publishUser) {
		this.publishUser = publishUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public String getArticleTags() {
		return articleTags;
	}

	public void setArticleTags(String articleTags) {
		this.articleTags = articleTags;
	}
}
