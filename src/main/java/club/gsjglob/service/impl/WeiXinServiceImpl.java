package club.gsjglob.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

import club.gsjglob.dto.TextMessage;
import club.gsjglob.service.IWeiXinService;
import club.gsjglob.tools.MessageUtils;

/**
 * 处理微信的serviceimpl
 * 
 * @author gengzi
 * @time 2018年4月14日23:03:53
 *
 */
public class WeiXinServiceImpl implements IWeiXinService {

	@Override
	public String processRequest(Map<String, String> map) {
		if (map.get("MsgType").equals(MessageUtils.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
			System.out.println("==============这是文本消息！");
			return processTextMessage(map);
		}

		if (map.get("MsgType").equals(MessageUtils.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
			System.out.println("==============这是图片消息！");
		}

		if (map.get("MsgType").equals(MessageUtils.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
			System.out.println("==============这是链接消息！");
		}

		if (map.get("MsgType").equals(MessageUtils.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
			System.out.println("==============这是位置消息！");
		}

		if (map.get("MsgType").equals(MessageUtils.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
			System.out.println("==============这是视频消息！");
		}

		if (map.get("MsgType").equals(MessageUtils.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
			System.out.println("==============这是语音消息！");
		}

		return null;

		// // 发送方帐号（一个OpenID）
		// HashMap<String, String> map = (HashMap<String, String>) mapR;
		// String fromUserName = map.get("FromUserName");
		// // 开发者微信号
		// String toUserName = map.get("ToUserName");
		// // 消息类型
		// String msgType = map.get("MsgType");
		// // 默认回复一个"success"
		// String responseMessage = "success";
		// // 对消息进行处理
		// if (WechatMessageUtil.MESSAGE_TEXT.equals(msgType)) {// 文本消息
		// TextMessage textMessage = new TextMessage();
		// textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
		// textMessage.setToUserName(fromUserName);
		// textMessage.setFromUserName(toUserName);
		// textMessage.setCreateTime(System.currentTimeMillis());
		// textMessage.setContent("我已经受到你发来的消息了");
		// responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
		// }
		// log.info(responseMessage);
		// return responseMessage;
	}

	/**
	 * 处理文本信息
	 * 
	 * @param map
	 * @return
	 */
	private String processTextMessage(Map<String, String> map) {
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		// 默认回复一个"success"
		String responseMessage = "success";
		// 对消息进行处理
		TextMessage textMessage = new TextMessage();
		textMessage.setMsgType(MessageUtils.REQ_MESSAGE_TYPE_TEXT);
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(System.currentTimeMillis());
		textMessage.setContent("我已经接收到你发来的消息了");
		responseMessage = messageToXml(textMessage);
		return responseMessage;
	}

	/**
	 * 将返回信息转化为xml
	 * 
	 * @param message
	 * @return
	 */
	public static String messageToXml(Object message) {
		XStream xstream = new XStream();
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);

	}

}
