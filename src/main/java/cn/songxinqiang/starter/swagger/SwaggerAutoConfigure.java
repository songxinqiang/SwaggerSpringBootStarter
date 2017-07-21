/**
 * <pre>
 * Copyright (c) 2017 阿信sxq(songxinqiang@vip.qq.com).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
/*
 * 创建时间：2017年7月21日--上午11:48:32
 * 作者：宋信强(阿信sxq, songxinqiang@vip.qq.com, https://my.oschina.net/songxinqiang)
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 */
package cn.songxinqiang.starter.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 自动配置swagger
 *
 * @author 阿信sxq
 *
 */
@Configuration
@EnableSwagger2
@ConditionalOnClass(Docket.class)
@EnableConfigurationProperties(SwaggerApiProperties.class)
public class SwaggerAutoConfigure {

    @Autowired
    SwaggerApiProperties properties;

    @Bean
    public Docket autoEnableSwagger() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(properties.getName())
                .apiInfo(specialApiInfo()).select().build();
    }

    /**
     * 设置api的参数
     *
     * @return api参数信息
     */
    private ApiInfo specialApiInfo() {
        Contact contact = new Contact(properties.getContactUser(), properties.getContactUrl(),
                properties.getContactEmail());
        return new ApiInfoBuilder().title(properties.getTitle())
                .description(properties.getDescription()).contact(contact)
                .version(properties.getVersion()).build();
    }

}
