/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 
 * @description redis操作类
 *
 * @author xuyq - chainisit@126.com
 * @since 1.0 - 2016年7月15日
 */
@Service
public class RedisService {

	@Autowired(required = false)
	private ShardedJedisPool shardedJedisPool;

	/**
	 * redis 执行方法
	 * 
	 * @param fun
	 * @return
	 */
	private <T> T execute(Function<ShardedJedis, T> fun) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = this.shardedJedisPool.getResource();
			return fun.callBack(shardedJedis);
		} catch (Exception e) {
			e.printStackTrace();
			if (null != shardedJedis) {
				shardedJedis.close();
			}
		} finally {
			if (null != shardedJedis) {
				shardedJedis.close();
			}
		}
		return null;
	}

	public String set(final String key, final String value) {
		return execute(new Function<ShardedJedis, String>() {
			public String callBack(ShardedJedis shardedJedis) {
				return shardedJedis.set(key, value);
			}
		});
	}

	public String set(final String key, final String value, final Integer seconds) {
		return (String) execute(new Function<ShardedJedis, String>() {
			public String callBack(ShardedJedis shardedJedis) {
				String str = shardedJedis.set(key, value);
				shardedJedis.expire(key, seconds.intValue());
				return str;
			}
		});
	}

	public String get(final String key) {
		return (String) execute(new Function<ShardedJedis, String>() {
			public String callBack(ShardedJedis e) {
				return e.get(key);
			}
		});
	}

	public Long del(final String key) {
		return (Long) execute(new Function<ShardedJedis, Long>() {
			public Long callBack(ShardedJedis e) {
				return e.del(key);
			}
		});
	}

	public Long expire(final String key, final Integer seconds) {
		return (Long) execute(new Function<ShardedJedis, Long>() {
			public Long callBack(ShardedJedis e) {
				return e.expire(key, seconds.intValue());
			}
		});
	}

	interface Function<E, T> {
		public abstract T callBack(E e);
	}
}
