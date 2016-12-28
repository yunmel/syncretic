/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.ds;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yunmel.syncretic.annotation.DataSourceChange;
import com.yunmel.syncretic.exception.DataSourceAspectException;

/**
 * 
 * @description 
 *      {@link com.yunmel.commons.annotation.DataSourceChange}注解的方法，调用时会切换到指定的数据源
 * @author xuyq - chainisit@126.com
 * @since 1.0 - 2016年7月15日
 */
@Aspect
@Component
public class DataSourceAspect {
  private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

  @Around("@annotation(dataSourceChange)")
  public Object doAround(ProceedingJoinPoint pjp, DataSourceChange dataSourceChange) {
    Object retVal = null;
    boolean selectedDataSource = false;
    try {
      if (null != dataSourceChange) {
        selectedDataSource = true;
        if (dataSourceChange.slave()) {
          DynamicDataSource.useSlave();
        } else {
          DynamicDataSource.useMaster();
        }
      }
      retVal = pjp.proceed();
    } catch (Throwable e) {
      LOGGER.warn("数据源切换错误", e);
      throw new DataSourceAspectException("数据源切换错误", e);
    } finally {
      if (selectedDataSource) {
        DynamicDataSource.reset();
      }
    }
    return retVal;
  }
}
