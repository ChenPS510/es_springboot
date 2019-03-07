此项目是基于SpringBoot快速构建，继承freemarker，mybatis，elasticsearch的web项目。
是一个简易的唐诗搜索系统，可以根据唐诗的title标题和content内容搜索，并且高亮显示。

前期工作：
1.快速构建项目，导入mysql和druid连接池jar包，mybatis的jar包不需要导入，因为已经快速构建集成
2.配置application.yml
3.开发entity dao mapper，在入口类配置mapperscan。可以从数据库查出所有的唐诗数据
3.在唐诗实体中加入@Document @Id注解
4.开发es包下的PoetryRespository,并在测试类中@autowired注入此类，调用其saveall方法，自动创建index、type 
5.开发es包下的复杂查询类以及方法CustomPoetryRespository，将其注入到service中
6.开发index.html,controller,peoperties.ftl
7.测试即可。


项目流转流程如下：
1. 从index.html页面输入关键字，程序跳转至控制器层
2.控制器调用customPoetryResposity中的方法，去索引index/类型type 下去查数据。
3.数据返回,跳转至poetries.ftl 并高亮显示