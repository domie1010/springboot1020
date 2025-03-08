# springboot+vue

#### 介绍
java毕业设计，房屋交易系统
3000多套系统，需要联系
抠：3565014707
微：a13424421017

软件架构分析
1. 分层架构
项目遵循典型的分层架构模式，主要分为：

表现层（Presentation Layer）：由前端代码（admin和front目录）实现，提供用户界面。
业务逻辑层（Business Layer）：后端的controller、service包处理核心业务逻辑。
数据访问层（Data Access Layer）：dao包和mapper目录中的MyBatis XML文件负责与数据库交互。
基础设施层（Infrastructure Layer）：utils包中的工具类（如BaiduUtil可能用于地图服务）、interceptor拦截器、config配置类。
2. 技术栈
后端：
Spring Boot：fangwujiaoyipingtaiApplication.java是启动类，application.yml为配置文件。
MyBatis：dao接口与mapper目录的XML文件实现数据持久化。
权限控制：通过AuthorizationInterceptor拦截器和APPLoginUser自定义注解实现。
线程管理：MyThreadMethod类可能用于异步任务。
前端：
管理后台：基于Vue.js（admin/src），使用Element UI组件库。
用户端：基于传统HTML+JS（front目录），集成LayUI、Bootstrap、ElementUI和TinyMCE富文本编辑器。
3. 模块化设计
实体模型：entity包定义数据模型，vo（值对象）、view（视图模型）、model（业务模型）实现分层数据传递。
功能模块：代码按业务领域划分（如chushoufangwu、zufang、gonggao），体现领域驱动设计（DDD）思想。
功能模块分析
1. 核心业务模块
房屋交易：
出售房屋（chushoufangwu）：包含房源发布、收藏（Collection）、留言（Liuyan）、订单（Order）功能。
租房（zufang）：类似出售模块，提供租赁信息管理。
用户管理（yonghu）：用户注册、登录、个人信息维护，可能通过APPLoginUser注解绑定当前用户。
公告管理（gonggao）：平台公告的发布与展示，使用TinyMCE支持富文本编辑。
2. 辅助功能模块
字典管理（dictionary）：维护系统枚举值（如房屋状态、区域、性别），通过TypeEnum等枚举类实现。
文件上传：static/upload目录存储上传的图片、视频等文件，支持房源多媒体展示。
权限控制：AuthorizationInterceptor拦截未登录请求，确保操作安全性。
异步处理：MyThreadMethod可能用于后台任务（如邮件通知、数据清理）。
3. 前后端交互
API设计：后端提供RESTful接口（如ChushoufangwuCollectionController），前端通过admin/src/utils/api.js和front/modules/http/http.js发起请求。
数据格式：使用VO（Value Object）封装返回数据，确保前后端数据解耦。
架构亮点与潜在改进点
亮点
前后端分离：管理后台使用Vue.js实现SPA，用户端兼容传统多页应用，适应不同场景。
权限粒度控制：通过拦截器+注解实现方法级权限检查，灵活性高。
模块化清晰：按业务领域划分代码，便于扩展和维护。

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
