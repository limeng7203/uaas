# uaas
权限管理系统

在期间做的一个权限管理系统，第一个版本使用Grails/Groovy开发的，基于Ldap持久，做的不是很好，这次想改版<br>
1、spring boot<br>
2、spring data/mybatis<br>
3、h2databse/postres<br>
4、oauth2<br>
5、openapi<br>

做项目最要强调的就是统一，这个项目，我会演示不同风格，但是建议大家以后项目中要统一，举例说明：<br>
1、单页面应用还是多页面应用<br>
2、单页面和多页面混合应用时候，但是规则尽量统一，指定什么情况使用单页面（交互Ajax），什么时候多页面跳转<br>
3、主推同步请求还是异步（Ajax）<br>
4、异常统一处理方式，页面内提示还是统一提示<br>
5、应用尽量做到无状态（Session），推荐使用Cookie，如果用到Session可以的话封装一个分布式Session会话<br>
6、统一处理权限，尽量不要污染业务代码<br>
7、使用Cookie时候注意中文问题，另外提前考虑不能超过4K<br>

项目介绍：<br>
uaas-api：契约接口<br>
uaas-auth：实现接口，认证和授权<br>
uaas-console：管理界面<br>
uaas-client：一个干净的客户端使用，其实在uaas-console中也会使用到<br>

联系方式：<br>
QQ:745356640<br>
Email:2008dreams@2008.sina.com<br>
