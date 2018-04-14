package club.gsjglob.dto;

/**
 * ClassName: TextMessage
 * @Description: 文本消息
 * @date 2018年4月14日23:09:25
 */
public class TextMessage extends BaseMessageWeiXin { 
 // 消息内容 
 private String Content; 
  
 public String getContent() { 
  return Content; 
 } 
  
 public void setContent(String content) { 
  Content = content; 
 } 
}
