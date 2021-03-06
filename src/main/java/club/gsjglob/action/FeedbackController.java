package club.gsjglob.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import club.gsjglob.domain.GsjAdviceFeedback;
import club.gsjglob.domain.GsjArticle;
import club.gsjglob.service.IFeedBackService;

/**
 * 意见反馈controller
 * 
 * @author gengzi
 * @time 2018年3月30日22:30:36
 *
 */
@Controller
public class FeedbackController {
	
	@Autowired
	private IFeedBackService feedBackService; 
	
	/**
	 * 接收用户留言
	 * 
	 * @return
	 */
	@RequestMapping(value = "feedback/send",method=RequestMethod.POST)
	@ResponseBody
	public String sendinfo(GsjAdviceFeedback adviceFeedback) {
		//解析参数
		return feedBackService.saveSendInfo(adviceFeedback);
	}
	
	
	/**
	 * 接收用户的意见
	 * 
	 * @return
	 */
	@RequestMapping(value = "feedback/sendtwo",method=RequestMethod.POST)
	@ResponseBody
	public GsjAdviceFeedback sendfeedbackinfo(GsjAdviceFeedback adviceFeedback) {
		 return feedBackService.saveSendInfoTwo(adviceFeedback);
	}
	
	
	
	
	/**
	 * 接收用户的意见
	 * 
	 * @return
	 */
	@RequestMapping(value = "feedback/getfeedback")
	@ResponseBody
	public List<GsjAdviceFeedback> getfeedbackinfo() {
		 return feedBackService.getFeedBackInfo();
	}
	
	
	
	
	/**
	 * 返回留言列表
	 * @return
	 */
	@RequestMapping(value = "/feedback/getfeedbacknum")
	@ResponseBody
	public String getfeedbacknum() {
		 return feedBackService.getFeedBackNum();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
