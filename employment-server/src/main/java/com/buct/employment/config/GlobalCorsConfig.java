package com.buct.employment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author
 * @date 2020/12/31 11:17
 */

//配置过滤器，全局解决跨域
@Configuration
public class GlobalCorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);    // 是否发送cookie信息
        corsConfiguration.addAllowedOriginPattern("*");    // 允许任何域名访问
        corsConfiguration.addAllowedHeader("*");    // 允许任何请求头访问
        corsConfiguration.addAllowedMethod("*");    // 允许任何请求方法(get, post等)
        corsConfiguration.addExposedHeader("*");    // 暴露头部信息
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
