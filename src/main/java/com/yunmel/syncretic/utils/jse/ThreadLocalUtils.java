/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.utils.jse;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 
 * @description ThreadLocal工具类
 *
 * @author xuyq - chainisit@126.com
 * @since 1.0 - 2016年7月15日
 */
public class ThreadLocalUtils {
  @SuppressWarnings("rawtypes")
  private static final ThreadLocal SESSION_MAP = new ThreadLocal();

  protected ThreadLocalUtils() {}

  @SuppressWarnings("rawtypes")
  public static Object get(String attribute) {
    Map map = (Map) SESSION_MAP.get();
    if (null != map) {
      return map.get(attribute);
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  public static <T> T get(String attribute, Class<T> clazz) {
    return (T) get(attribute);
  }

  @SuppressWarnings("unchecked")
  public static void set(String attribute, Object value) {
    Map<String, Object> map = (Map<String, Object>) SESSION_MAP.get();
    if (map == null) {
      map = Maps.newHashMap();
      SESSION_MAP.set(map);
    }
    map.put(attribute, value);
  }

}
