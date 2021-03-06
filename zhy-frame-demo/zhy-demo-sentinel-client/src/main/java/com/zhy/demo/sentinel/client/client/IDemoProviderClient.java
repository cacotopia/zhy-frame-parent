package com.zhy.demo.sentinel.client.client;/**
 * 描述:
 * 包名:com.zhy.demo.customer.client
 * 版本信息: 版本1.0
 * 日期:2020/3/5
 * Copyright XXXXXX科技有限公司
 */


import com.zhy.frame.base.core.api.ApiResult;
import com.zhy.frame.demo.api.surface.IDemoProvider;
import com.zhy.frame.dispatch.feign.config.DisableHystrix;
import com.zhy.frame.dispatch.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2020/3/5 15:37
 */
@FeignClient(name = "sentinelProvider", url = "${rpc.server.gateway}", configuration = {FeignConfig.class/*, DisableHystrix.class*/}, fallbackFactory = IDemoProviderClientFallbackFactory.class)
public interface IDemoProviderClient extends IDemoProvider {
}
