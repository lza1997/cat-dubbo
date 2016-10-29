package com.zs.pig.common.redis.jedis;

import java.io.Serializable;
import java.util.Date;

public class TestE implements Serializable {

	private int id;
	private int age;
	private Date addTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}
