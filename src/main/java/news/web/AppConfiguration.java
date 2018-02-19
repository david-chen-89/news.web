package news.web;

import news.web.controller.CacheInterceptor;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableCaching
@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public HandlerInterceptor getCacheInterceptor() {
		return new CacheInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getCacheInterceptor());
		super.addInterceptors(registry);
	}
}
