package ksmart39.mybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ksmart39.mybatis.interceptor.CommomInterceptor;
import ksmart39.mybatis.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	private final CommomInterceptor commomInterceptor;
	private final LoginInterceptor loginInterceptor;
	
	 public WebConfig(CommomInterceptor commomInterceptor,LoginInterceptor loginInterceptor ) {
		this.commomInterceptor = commomInterceptor;
		this.loginInterceptor = loginInterceptor;
			
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commomInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")//어떤 URI를 뺄건지 
			 	.excludePathPatterns("/js/**");
		
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/login")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/addMember")
				.excludePathPatterns("/addGoods")
				.excludePathPatterns("/memberIdCheck")
				.excludePathPatterns("/js/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
