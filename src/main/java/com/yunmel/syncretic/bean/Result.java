/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.bean;

public class Result {
	private Integer status;
	private String msg;
	private Object data;

	public static Result build(Integer status, String msg, Object data) {
		return new Result(status, msg, data);
	}

	public static Result ok(Object data) {
		return new Result(data);
	}

	public static Result ok() {
		return new Result(null);
	}

	public Result() {
	}

	public static Result build(Integer status, String msg) {
		return new Result(status, msg, null);
	}

	public Result(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public Result(Object data) {
		this.status = Integer.valueOf(200);
		this.msg = "OK";
		this.data = data;
	}

	public Boolean isOK() {
		return Boolean.valueOf(this.status.intValue() == 200);
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
