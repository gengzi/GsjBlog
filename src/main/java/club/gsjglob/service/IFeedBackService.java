package club.gsjglob.service;

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
	

}
