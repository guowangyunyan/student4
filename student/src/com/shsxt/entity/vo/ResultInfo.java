package com.shsxt.entity.vo;

/**
 * 结果信息类 结果码 结果信息 结果中包含的类
 */
public class ResultInfo<T> {
	// -1 有错误 1正确
	private Integer code;
	private String msg;
	private T obj;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

}
