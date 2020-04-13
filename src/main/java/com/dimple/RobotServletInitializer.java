package com.dimple;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @className: LearningWeekServletInitializer
 * @description: web容器中进行部署
 * @Date: 2019/10/17
 * @Version: 1.1
 */
public class RobotServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RobotApplication.class);
    }
}
