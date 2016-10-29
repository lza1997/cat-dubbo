package com.zs.pig.common.redis.jedis;

import java.io.Serializable;

public class Person implements Serializable {

	private int id;
	private String name;
	TestE te;
	
	public TestE getTe() {
		return te;
	}
	public void setTe(TestE te) {
		this.te = te;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
