package club.gsjglob.vo;

import java.io.Serializable;
import java.util.List;

import club.gsjglob.domain.GsjArticle;
import club.gsjglob.domain.GsjTags;
/**
 *  文章详情内容vo
 * @author gengzi
 * @time 2018年3月21日10:31:43
 *
 */
public class ArticleContent implements Serializable {

	// 文章详情
	private GsjArticle gsjArticle;
	// 文章的评论
	// 文章的标签
	private List<GsjTags> gsjTagslist;
	
	public List<GsjTags> getGsjTagslist() {
		return gsjTagslist;
	}

	public void setGsjTagslist(List<GsjTags> gsjTagslist) {
		this.gsjTagslist = gsjTagslist;
	}

	public GsjArticle getGsjArticle() {
		return gsjArticle;
	}

	public void setGsjArticle(GsjArticle gsjArticle) {
		this.gsjArticle = gsjArticle;
	}

	

}
