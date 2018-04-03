package club.gsjglob.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章的同居出参
 * 
 * @author gengzi
 * @time 2018年4月3日18:24:52
 *
 */
public class ArticleChar implements Serializable {
	// 统计图表2
	private String yd;
	private String numyd;

	// 目录名x轴
	private List ydl = new ArrayList<>();
	// 个数Y轴
	private List numydl = new ArrayList<>();

	public List getYdl() {
		return ydl;
	}

	public void setYdl(List ydl) {
		this.ydl = ydl;
	}

	public List getNumydl() {
		return numydl;
	}

	public void setNumydl(List numydl) {
		this.numydl = numydl;
	}

	public String getYd() {
		return yd;
	}

	public void setYd(String yd) {
		this.yd = yd;
	}

	public String getNumyd() {
		return numyd;
	}

	public void setNumyd(String numyd) {
		this.numyd = numyd;
	}
}
