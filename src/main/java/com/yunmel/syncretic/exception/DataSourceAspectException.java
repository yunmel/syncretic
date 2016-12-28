/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.exception;

/**
 * 
 * @author xuyq
 *
 */
public class DataSourceAspectException extends RuntimeException {
  private static final long serialVersionUID = 1401593546385403721L;

  public DataSourceAspectException() {
    super();
  }

  public DataSourceAspectException(String message) {
    super(message);
  }

  public DataSourceAspectException(Throwable cause) {
    super(cause);
  }

  public DataSourceAspectException(String message, Throwable cause) {
    super(message, cause);
  }
}
