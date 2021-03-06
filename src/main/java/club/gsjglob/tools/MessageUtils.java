package club.gsjglob.tools;

public class MessageUtils {
	// 文本
	public final static String REQ_MESSAGE_TYPE_TEXT = "text";
	// 图片
	public final static String REQ_MESSAGE_TYPE_IMAGE = "image";
	// 图文消息
	public final static String REQ_MESSAGE_TYPE_NEWS = "news";
	// 语音消息
	public final static String REQ_MESSAGE_TYPE_VOICE = "voice";
	// 视频消息
	public final static String REQ_MESSAGE_TYPE_VIDEO = "video";
	// 小视频消息
	public final static String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";
	// 地理位置消息
	public final static String REQ_MESSAGE_TYPE_LOCATION = "location";
	// 链接消息
	public final static String REQ_MESSAGE_TYPE_LINK = "link";
	// 事件推送消息
	public final static String MESSAGE_EVENT = "event";
	// 事件推送消息中,事件类型，subscribe(订阅)
	public static final String MESSAGE_EVENT_SUBSCRIBE = "subscribe";
	// 事件推送消息中,事件类型，unsubscribe(取消订阅)
	public static final String MESSAGE_EVENT_UNSUBSCRIBE = "unsubscribe";
	// 事件推送消息中,上报地理位置事件
	public static final String MESSAGE_EVENT_LOCATION_UP = "LOCATION";
	// 事件推送消息中,自定义菜单事件,点击菜单拉取消息时的事件推送
	public static final String MESSAGE_EVENT_CLICK = "CLICK";
	// 事件推送消息中,自定义菜单事件,点击菜单跳转链接时的事件推送
	public static final String MESSAGE_EVENT_VIEW = "VIEW";

}
