package com.buct.employment.config;

import com.buct.employment.enums.FilePathEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author JeffCar
 * @date 4/1/2021 - 3:14 PM
 */
@Configuration
public class UserAvatarConfig implements WebMvcConfigurer {
    /**
     * 图片映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(FilePathEnum.USER_AVATAR_PATH.getPath()+"**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator")
                        + FilePathEnum.IMG_PATH.getPath() + System.getProperty("file.separator")
                        + FilePathEnum.USER_AVATAR.getPath() + System.getProperty("file.separator")
        );
    }
}
