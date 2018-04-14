package club.gsjglob.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;

import club.gsjglob.service.IWeiXinService;
import club.gsjglob.tools.SHA1;
import club.gsjglob.tools.XmlToMap;

/**
 * 博客文章管理
 * 
 * @author gengzi
 * @time 2018年3月18日13:37:19
 *
 */
@Controller
public class WeiXinController {
	
	@Autowired
	private IWeiXinService weiXinService;

	private final static String TOKEN = "gengzi666";

	/**
	 * 微信认证
	 * @param signature
	 * @param echostr
	 * @param timestamp
	 * @param nonce
	 * @param response
	 */
	@RequestMapping(value = "/wx", method = RequestMethod.GET)
	public void wxtokenValidate(String signature, String echostr, String timestamp, String nonce,
			HttpServletResponse response) {

		String[] str = { TOKEN, timestamp, nonce };
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2];
		// SHA1加密
		String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();

		// 确认请求来至微信
		if (digest.equals(signature)) {
			try {
				response.getWriter().print(echostr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 接收用户的消息，并回复
	 * @param request 请求
	 * @param response 响应
	 */
	@RequestMapping(value = "/wx", method = RequestMethod.POST)
	public void wxAnswerMessage(HttpServletRequest request, HttpServletResponse response) {
		// 接收微信的xml参数
		Map<String, String> xmlToMap = XmlToMap.xmlToMap(request);
		String processRequest = weiXinService.processRequest(xmlToMap);
		try {
			response.getWriter().println(processRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}