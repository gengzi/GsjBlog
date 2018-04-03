package club.gsjglob.service;

import java.util.List;

import club.gsjglob.domain.GsjAdviceFeedback;

/**
 * 意见反馈的service
 * @author gengzi
 * @time 2018年3月30日22:48:19
 *
 */
public interface IFeedBackService {
	
	/**
	 * 接收用户的意见反馈
	 * @param adviceFeedback 意见反馈的实体类
	 * @return
	 */
	String saveSendInfo(GsjAdviceFeedback adviceFeedback);
	
	
	/**
	 * 接收用户的意见反馈
	 * @param adviceFeedback 意见反馈的实体类
	 * @return
	 */
	GsjAdviceFeedback saveSendInfoTwo(GsjAdviceFeedback adviceFeedback);


	/**
	 * 查询所有的留言意见信息
	 * @return List<GsjAdviceFeedback>
	 */
	List<GsjAdviceFeedback> getFeedBackInfo();


	/**
	 * 返回留言的条数
	 * @return
	 */
	String getFeedBackNum();
	

}
