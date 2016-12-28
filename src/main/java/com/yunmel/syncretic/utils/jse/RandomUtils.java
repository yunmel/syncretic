/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.utils.jse;

import java.security.SecureRandom;

/**
 * 
 * @description 随机数生成工具类
 *
 * @author xuyq - chainisit@126.com
 * @since 1.0 - 2016年7月15日
 */
public class RandomUtils {
  // Maxim: Copied from UUID implementation :)
  private static volatile SecureRandom numberGenerator = null;
  private static final long MSB = 0x8000000000000000L;

  public static String genRandom32Hex() {
    SecureRandom ng = numberGenerator;
    if (ng == null) {
      numberGenerator = ng = new SecureRandom();
    }

    return Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
  }

  public static void main(String[] args) {
    System.out.println(RandomUtils.genRandom32Hex());
  }
}
