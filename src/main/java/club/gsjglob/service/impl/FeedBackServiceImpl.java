package club.gsjglob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.gsjglob.dao.GsjAdviceFeedbackMapper;
import club.gsjglob.domain.GsjAdviceFeedback;
import club.gsjglob.domain.GsjAdviceFeedbackExample;
import club.gsjglob.service.IFeedBackService;
import club.gsjglob.tools.DateUtils;

/**
 * 意见反馈的serviceimpl
 * 
 * @author gengzi
 * @time 2018年3月30日22:52:08
 *
 */
@Service
public class FeedBackServiceImpl implements IFeedBackService {

	@Autowired
	private GsjAdviceFeedbackMapper feedbackdao;

	@Override
	public String saveSendInfo(GsjAdviceFeedback adviceFeedback) {
		String content = adviceFeedback.getContent();
		adviceFeedback.setCreateTime(DateUtils.getStringDate());
		if (!"".equals(content)) {
			int insertSelective = feedbackdao.insert(adviceFeedback);
			if (insertSelective > 0) {
				return "{\"message\":\"success\"}";
			}
		}
		return "{\"message\":\"error\"}";
	}

	@Override
	public GsjAdviceFeedback saveSendInfoTwo(GsjAdviceFeedback adviceFeedback) {
		String content = adviceFeedback.getContent();
		adviceFeedback.setCreateTime(DateUtils.getStringDate());
		if (!"".equals(content)) {
			int insertSelective = feedbackdao.insert(adviceFeedback);
			if (insertSelective > 0) {
				return adviceFeedback;
			}
		}
		return new GsjAdviceFeedback();
	}

	@Override
	public List<GsjAdviceFeedback> getFeedBackInfo() {
		GsjAdviceFeedbackExample adviceFeedbackExample = new GsjAdviceFeedbackExample();
		return feedbackdao.selectByExample(adviceFeedbackExample);

	}

	@Override
	public String getFeedBackNum() {
		GsjAdviceFeedbackExample adviceFeedbackExample = new GsjAdviceFeedbackExample();
		int countByExample = feedbackdao.countByExample(adviceFeedbackExample);
		return "{\"num\":\"" + countByExample + "\"}";

	}

}
