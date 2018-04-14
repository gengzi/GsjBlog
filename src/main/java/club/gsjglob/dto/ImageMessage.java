package club.gsjglob.dto;

/**
 * ClassName: ImageMessage
 * @Description: 图片消息
 * @date 2018年4月14日23:08:27
 */
public class ImageMessage extends BaseMessageWeiXin {
 // 图片链接
 private String PicUrl;
  
 public String getPicUrl() {
  return PicUrl;
 }
  
 public void setPicUrl(String picUrl) {
  PicUrl = picUrl;
 }
}