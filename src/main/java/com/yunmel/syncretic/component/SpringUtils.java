/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 
 * @description  以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.
 *
 * @author xuyq - chainisit@126.com
 * @since 1.0 - 2016年7月18日
 */
@Component
public class SpringUtils implements ApplicationContextAware {
  private static ApplicationContext context;

  private SpringUtils() {}

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    SpringUtils.context = context;
  }

  public static <T> T getBean(Class<T> clazz) {
    if (clazz == null)
      return null;
    return context.getBean(clazz);
  }

  public static <T> T getBean(String beanName, Class<T> clazz) {
    if (null == beanName || "".equals(beanName.trim())) {
      return null;
    }
    if (clazz == null)
      return null;
    return (T) context.getBean(beanName, clazz);
  }

  public static ApplicationContext getContext() {
    if (context == null)
      return null;
    return context;
  }

  public void publishEvent(ApplicationEvent event) {
    if (context == null)
      return;
    context.publishEvent(event);
  }

  @SuppressWarnings("unchecked")
  public static <T> T getBean(String name) {
    return (T) context.getBean(name);
  }

}
