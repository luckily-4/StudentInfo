package com.artisan.model;
/**
 * 
 * @author llq
 *�༶��Ϣentity
 */
public class StudentClass {
	private int id;
	private String name;
	private String info;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString(){
		return this.name;
	}
}
