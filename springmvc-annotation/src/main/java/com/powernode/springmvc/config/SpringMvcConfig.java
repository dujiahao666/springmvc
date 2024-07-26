package com.powernode.springmvc.config;

import com.powernode.springmvc.interceptors.MyInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/30 19:18
 * @description:
 */
//以下相当于是springmvc.xml配置文件
@Configuration
//组件扫描
@ComponentScan("com.powernode.springmvc.controller")
//开启注解驱动
@EnableWebMvc

public class SpringMvcConfig implements WebMvcConfigurer {
/*
在springmvc.xml文件中都可以配置什么？
1.组件扫描
2.视图解析器
3.静态资源处理 default-servlet-handler
4.视图控制器 view-controller
5.开启注解驱动
6.异常处理器
7.拦截器
 */

    //以下三个方法合起来就是开启视图解析器，thymeleaf的
    @Bean
    public ThymeleafViewResolver getViewResolver(SpringTemplateEngine springTemplateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(springTemplateEngine);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver iTemplateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(iTemplateResolver);
        return templateEngine;
    }

    @Bean
    public ITemplateResolver templateResolver(ApplicationContext applicationContext) {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/thymeleaf/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);//开发时关闭缓存，改动即可生效
        return resolver;
    }

    //开启 静态资源处理，开启默认的servlet处理
    // 实现的WebMvcConfigurer接口，重现里面的configureDefaultServletHandling方法
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    //开启视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("test");
    }


//        <!-- 配置属于自己的异常处理器-->
//<!--    <bean  class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">-->
//<!--        <property name="exceptionMappings">-->
//<!--            <props>-->
//<!--                &lt;!&ndash;这里可以配置很多键值对，key是异常，要提供具体的类型，包括包名&ndash;&gt;-->
//<!--                &lt;!&ndash;以下的配置表示，只要发生异常，都跳转到tip视图，出错时会按照配置顺序依次匹配异常类型，使用第一个匹配成功的异常类型对应的视图进行跳转。&ndash;&gt;-->
//<!--                <prop key="java.lang.Exception">tip</prop>-->
//<!--            </props>-->
//              <property name="exceptionAttribute" value="yiChang"/>-->
//<!--        </property>-->
//<!--    </bean>-->


    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        //可以配置多个异常处理器，这是其中一个
        SimpleMappingExceptionResolver resolver=new SimpleMappingExceptionResolver();
        //设置其中的exceptionMappings属性
        Properties properties=new Properties();
        properties.setProperty("java.lang.Exception","tip");
        resolver.setExceptionMappings(properties);
        //设置其中的exceptionAttribute属性
        resolver.setExceptionAttribute("e");
        resolvers.add(resolver);
    }


    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInterceptor myInterceptor=new MyInterceptor();
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/test");
    }


}
