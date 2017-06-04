package com.thymeleaf.test.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
	
	@NotNull
	@Size(min=2, max=30, message="Tên phải nhiều hơn 2 và ít hơn 30 ký tự.")
	private String name;
	
	@NotNull
	@Min(value=18, message="Rất tiếc! Hệ thống chỉ chấp nhận người trên 18 tuổi.")
	private Integer age;
	
	public Person() {
		super();
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person(Name: " + this.name + " - Age: " + this.age;
	}

}
