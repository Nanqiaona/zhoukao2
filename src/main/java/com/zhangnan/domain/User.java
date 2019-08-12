package com.zhangnan.domain;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{

	/**
	 * @fieldName: id
	 * @fieldType: Integer
	 * @Description: id
	 */
	private Integer id;
	/**
	 * @fieldName: name
	 * @fieldType: String
	 * @Description: name
	 */
	private String name;
	/**
	 * @fieldName: sex
	 * @fieldType: String
	 * @Description: TODO
	 */
	private String sex;
	/**
	 * @fieldName: tel
	 * @fieldType: String
	 * @Description: TODO
	 */
	private String tel;
	/**
	 * @fieldName: yx
	 * @fieldType: String
	 * @Description: TODO
	 */
	private String yx;
	/**
	 * @fieldName: birthday
	 * @fieldType: Date
	 * @Description: TODO
	 */
	private Date birthday;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getYx() {
		return yx;
	}
	public void setYx(String yx) {
		this.yx = yx;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", tel=" + tel + ", yx=" + yx + ", birthday="
				+ birthday + "]";
	}
	public User(Integer id, String name, String sex, String tel, String yx, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.yx = yx;
		this.birthday = birthday;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
