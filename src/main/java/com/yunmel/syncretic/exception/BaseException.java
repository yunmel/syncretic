/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.exception;

public class BaseException extends Exception {
  private static final long serialVersionUID = 1896565869758362076L;
  private Integer code;

  public BaseException() {}

  public BaseException(Integer code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

  public BaseException(Integer code, String message) {
    super(message);
    this.code = code;
  }

  public BaseException(Integer code, Throwable cause) {
    super(cause);
    this.code = code;
  }

  public BaseException(Integer code) {
    super();
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }
}
