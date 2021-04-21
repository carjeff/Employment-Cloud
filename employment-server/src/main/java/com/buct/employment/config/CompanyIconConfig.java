package com.buct.employment.config;

import com.buct.employment.enums.FilePathEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author JeffCar
 * @date 4/21/2021 - 12:26 PM
 */
@Configuration
public class CompanyIconConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(FilePathEnum.COMPANY_ICON_PATH.getPath() + "**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator")
                        + FilePathEnum.IMG_PATH.getPath() + System.getProperty("file.separator")
                        + FilePathEnum.COMPANY_ICON.getPath() + System.getProperty("file.separator")
        );
    }
}
