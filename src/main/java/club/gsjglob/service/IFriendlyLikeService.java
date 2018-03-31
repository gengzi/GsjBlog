package club.gsjglob.service;

import java.util.List;

import club.gsjglob.domain.GsjFriendlylink;
import club.gsjglob.vo.ShowUrlInfo;

/**
 * 友情链接service
 * @author gengzi
 * @time 2018年3月31日12:45:23
 *
 */
public interface IFriendlyLikeService {

	/**
	 * 查询收藏父网址列表 all
	 * @return ShowUrlInfo
	 */
	List<ShowUrlInfo> selectParentInfo();

	/**
	 * 根据
	 * @return
	 */
	List<GsjFriendlylink> selectziUrlInfo(String id);
	
	

}
