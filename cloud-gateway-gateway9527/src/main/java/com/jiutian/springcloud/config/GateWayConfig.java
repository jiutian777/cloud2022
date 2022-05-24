package com.jiutian.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2022/5/14 20:41
 * @Author: jiutian
 * @Description:
 */
@Configuration
public class GateWayConfig {

    /**
     * 配置了一个 id 为 path_route_jiutian 的路由规则，
     * 当访问 http://localhost:9527/guonei 时会自动转发到地址：http://news.baidu.com/guonei
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_jiutian",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .build();

        return routes.build();
    }
}
