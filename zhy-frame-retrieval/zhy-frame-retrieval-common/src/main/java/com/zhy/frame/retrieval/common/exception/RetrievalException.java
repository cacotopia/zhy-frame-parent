package com.zhy.frame.retrieval.common.exception;/**
 * 描述:
 * 包名:com.zhy.oauth2.center.feign
 * 版本信息: 版本1.0
 * 日期:2019/7/28
 * Copyright XXXXXX科技有限公司
 */


import com.zhy.frame.base.core.enums.ExceptionCodeLevel;
import com.zhy.frame.base.core.exception.ExceptionType;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2019/7/28 16:50
 */
public interface RetrievalException {


    enum Proxy implements ExceptionType {
        /**
         * es 查询的内容是需要的
         */
        ES_QUERY_CONTENT_IS_REQUIRED(ExceptionCodeLevel.RETRIEVAL.getValue() + 1, "elasticsearch query content is required"),
        /**
         * es 查询的bean是需要的
         */
        ES_QUERY_BEAN_IS_REQUIRED(ExceptionCodeLevel.RETRIEVAL.getValue() + 2, "elasticsearch query bean is required"),
        /**
         * es 查询的bean是需要的
         */
        /**
         * es 分页是需要的
         */
        ES_QUERY_PAGEABLE_IS_REQUIRED(ExceptionCodeLevel.RETRIEVAL.getValue() + 3, "elasticsearch query pageable is required"),
        /**
         * 至少是一个
         */
        ES_QUERY_PERCENT_IS_ERROR(ExceptionCodeLevel.RETRIEVAL.getValue() + 4, "elasticsearch query percent need Less Than One"),
        /**
         * es 删除报错
         */
        ES_DELETE_IS_ERROR(ExceptionCodeLevel.RETRIEVAL.getValue() + 5, "elasticsearch delete error"),
        /**
         * es fieles 是需要的
         */
        ES_DELETE_FIELDS_IS_REQUIRED(ExceptionCodeLevel.RETRIEVAL.getValue() + 6, "elasticsearch FIELDS error is Required"),
        /**
         * 其他
         */
        OTHER(ExceptionCodeLevel.ROUTE.getValue() + 7, "未知错误");
        private int code;
        private String description;

        private Proxy(int code, String description) {
            this.code = code;
            this.description = description;
        }

        @Override
        public int getCode() {
            return this.code;
        }

        @Override
        public String getDescription() {
            return this.description;
        }
    }

}
