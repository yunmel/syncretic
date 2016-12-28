/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.utils.biz;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 
 * @description 页面分页参数处理
 *
 * @author xuyq - chainisit@126.com
 * @since 1.0 - 2016年7月15日
 */
public class DealParamUtil {
  private final static int PAGE_NUM = 1; // 默认页码
  private final static int PAGE_SIZE = 20; // 每页显示多少条
  private final static String PAGE_NUM_STR = "pageNum";
  private final static String PAGE_SIZE_STR = "pageSize";

  /**
   * 处理请求参数
   * 
   * @param params
   * @return
   */
  public final static Map<String, Object> dealParam(Map<String, Object> params) {
    if (null != params) {
      if (!params.containsKey(PAGE_NUM_STR)) {
        params.put(PAGE_NUM_STR, PAGE_NUM);
      }

      if (!params.containsKey(PAGE_SIZE_STR)) {
        params.put(PAGE_SIZE_STR, PAGE_SIZE);
      }
    } else {
      params = Maps.newHashMap();
      params.put(PAGE_NUM_STR, PAGE_NUM);
      params.put(PAGE_SIZE_STR, PAGE_SIZE);
    }
    return params;
  }
}
