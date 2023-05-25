//package ru.itis.semesterwork.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//@EnableWebMvc
//@Configuration
//@ComponentScan("ru.itis.semesterwork.controllers")
//public class WebConfig implements WebMvcConfigurer {
////    @Override
////    public void configureViewResolvers(ViewResolverRegistry registry) {
////        registry.jsp("/WEB-INF/view/pizza/",".jsp");
////    }
//////
////    @Override
////    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
////    }
////
////
////    @Bean
////    public ViewResolver internalResourceViewResolver() {
////        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
////        resolver.setPrefix("/WEB-INF/view/");
////        resolver.setSuffix(".jsp");
////        resolver.setViewClass(JstlView.class);
////        resolver.setRedirectContextRelative(false);
////        return resolver;
////    }
////
////    @Override
////    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addViewController("/sign-in").setViewName("security/signIn");
//////        registry.addViewController("/dodo-pizza/sign-in").setViewName("signIn");
////        registry.addViewController("/products").setViewName("pizza/products");
////    }
//}
