package club.gsjglob.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 图标出参
 * 
 * @author gengzi
 * @time 2018年4月3日17:24:03
 *
 */
public class FolderChar implements Serializable{
	// 目录名x轴
	private List folder = new ArrayList<>();
	// 个数Y轴
	private List num = new ArrayList<>();

	public List getFolder() {
		return folder;
	}

	public void setFolder(List folder) {
		this.folder = folder;
	}

	public List getNum() {
		return num;
	}

	public void setNum(List num) {
		this.num = num;
	}

}
