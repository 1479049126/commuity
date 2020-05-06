//package community.demo.Interceptore;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
//
//
//@Configuration
//public class WebConfig  implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//       // registry.addInterceptor(new LocaleInterceptor());
//       // registry.addInterceptor(new ThemeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
//       // registry.addInterceptor(new ThemeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
//        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
//    }
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
////        //第一个方法设置访问路径前缀，第二个方法设置资源路径
////        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
////    }
//
//
//}
