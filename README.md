# GsjBlog 个人博客系统
- 该系统参考了：https://gitee.com/jflyfox/jfinal_cms  感谢
- 前台页面，参考网上的 [H+ ui](http://yanshi.sucaihuo.com/modals/40/4078/demo/) 感谢
## 项目预览地址：[耿子blog](http://gsjblog.club/GsjBlog/)
### 项目功能结构：
![项目功能结构](https://github.com/gengzi/webshop/blob/master/docandsql/img2/1.png)
### 技术栈：
- SSM:Spring,spring mvc,mybatis
- 数据库： mysql5.7，redis4.0
- 前台：Bootstrap，百度UE，echars，H+，jquery
### 项目设计
- maven工程，常规架构（mvc），采用前后端分离，采用restful风格，数据交换格式为：json，请求方式为ajax。
- 后端 bean，dao，mapper 使用mybatis 的逆向工程生成。
- 博文评论，使用畅言组件，分页使用 page-helper，网站监控，使用腾讯分析，博客编辑，使用了百度ue组件。
- 使用了redis实现了简单的单点登陆。
其实该系统做的很简单，但可以做为一个练手项目。
### 运行环境
- 软件服务：Tomcat7.0.85，JDK1.7以上
- 数据库服务：Mysql5.5，Redis 4.0版本
- 配置： mysql ： db.peoperties
      redis: spring-redis.xml 注意项目中redis，加了认证，请在redisclient 中修改认证的token

## 效果预览
### 前台：
![前台](https://github.com/gengzi/webshop/blob/master/docandsql/img2/public1.png)
### 后台：
![前台](https://github.com/gengzi/webshop/blob/master/docandsql/img2/admin1.png)

