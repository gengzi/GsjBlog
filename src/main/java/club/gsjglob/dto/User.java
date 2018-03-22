package club.gsjglob.dto;

import java.io.Serializable;

/**
 * 用户登录的入参
 * 
 * @author gengzi
 * @time 2018年3月22日10:12:46
 */
public class User  implements Serializable{
	// 登陆名
	private String adminname;
	// 密码
	private String adminpasswd;
	// 是否为管理员
	private String isadmin;
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpasswd() {
		return adminpasswd;
	}
	public void setAdminpasswd(String adminpasswd) {
		this.adminpasswd = adminpasswd;
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

}
