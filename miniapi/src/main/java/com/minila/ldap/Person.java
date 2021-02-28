package com.minila.ldap;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
 
@Getter
@Setter
@ToString
public class Person {
    private String userId;
    private String fullName;
    private String lastName;
    private String description;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
