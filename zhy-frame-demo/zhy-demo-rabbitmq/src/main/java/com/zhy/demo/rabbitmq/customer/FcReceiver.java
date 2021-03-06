package com.zhy.demo.rabbitmq.customer;/**
 * 描述:
 * 包名:com.zhy.jwt.annotation
 * 版本信息: 版本1.0
 * 日期:2019/1/21
 * Copyright 四川******科技有限公司
 */

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.zhy.frame.base.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @describe：
 * @author: lvmoney /四川******科技有限公司
 * @version:v1.0 2018年10月30日 下午3:29:38
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "hotel_order_book_queue", durable = "true")
        , exchange = @Exchange(value = "hotel_order_book_exchange", type = ExchangeTypes.TOPIC, durable = "true")
        , key = "hotel_order_book_key"
)
)

public class FcReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(FcReceiver.class);
//    @Autowired
//    MqDataHandServiceContext handMqServiceContext;

    @RabbitHandler
    public void process(String msg, Channel channel, Message message) {
//        handMqServiceContext.getData(mqType, mqDataVo);
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            LOGGER.error("消费消息失败:{}", e.getMessage());
//            throw new BusinessException(MqException.Proxy.RABBIT_MESSAGE_RECEIVER_FANOUT_ERROR);
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
        }
    }
}
