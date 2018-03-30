package club.gsjglob.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.gsjglob.dao.GsjAdviceFeedbackMapper;
import club.gsjglob.domain.GsjAdviceFeedback;
import club.gsjglob.service.IFeedBackService;

/**
 * 意见反馈的serviceimpl
 * @author gengzi
 * @time 2018年3月30日22:52:08
 *
 */
@Service
public class FeedBackServiceImpl implements IFeedBackService {

	@Autowired
	private GsjAdviceFeedbackMapper  feedbackdao;
	
	@Override
	public String saveSendInfo(GsjAdviceFeedback adviceFeedback) {
		String content = adviceFeedback.getContent();
		if (!"".equals(content)) {
			int insertSelective = feedbackdao.insert(adviceFeedback);
			if (insertSelective >0) {
				return "{\"message\":\"success\"}";
			}
		}
		return "{\"message\":\"error\"}";
	}

}
