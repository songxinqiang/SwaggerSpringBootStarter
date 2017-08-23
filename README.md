# SpringBootSwaggerStarter

在spring-boot中使用swagger，可以实现对代码无侵入地集成swagger

## 使用时的项目配置

需要在spring boot项目中使用，下面按照使用maven构建项目，以及使用`application.properties`文件来配置进行介绍，
如果使用其他的构建工具或配置文件，做相应的变更即可

在maven配置文件`pom.xml`中添加依赖

``` xml
<dependency>
    <groupId>cn.songxinqiang</groupId>
    <artifactId>swagger-spring-boot-starter</artifactId>
    <version>1.0.1</version>
</dependency>
```

在`application.properties`文件中配置api的信息

``` shell
swagger.api.name = #api 的组信息
swagger.api.title = #标题
swagger.api.description = #描述信息
swagger.api.version = #版本
swagger.api.contactUser = #联系人名称
swagger.api.contactUrl = #联系人url
swagger.api.contactEmail = #联系人邮箱
```

## swagger ui在使用时的配置

api的控制器会监听在地址`v2/api-docs?group=<swagger.api.name配置的值>`,
对于swagger ui来说需要指定服务器的“基础地址”为项目的根地址即可

## 说明

本组件应对的是在使用Spring MVC时的场景，只会处理`@Controller`,`@RequestMapping`等其他与之关联的注解

基于[springfox-swagger2](https://github.com/springfox/springfox),本组件只是简单的配置了一下下，感谢他们

