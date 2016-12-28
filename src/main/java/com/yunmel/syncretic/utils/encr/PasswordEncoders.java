/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.utils.encr;

/**
 * 
 * @description 密码MD5加盐加密工具类
 *
 * @author xuyq - chainisit@126.com
 * @since 1.0 - 2016年7月15日
 */
public class PasswordEncoders {

  public static String encrypt(String src, Object salt) {
    return encrypt(src, String.valueOf(salt));
  }

  /**
   * 密码加密
   * 
   * @param src 密码
   * @param salt 账号
   * @return
   */
  public static String encrypt(String src, String salt) {
    return EncryptUtils.MD5_HEX(EncryptUtils.MD5_HEX(src) + salt);
  }

  public static void main(String[] args) {
    System.out.println(encrypt("admin", "admin"));
  }
}
