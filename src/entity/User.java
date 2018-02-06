package entity;

import dao.Identified;

public class User implements Identified<Integer> {
	private Integer id;
	private String firstName;
	private String secondName;
	private String email;
	private String password;
	
	public User() {
		id= 0;
		firstName = "";
		secondName = "";		
		email = "";
		password = "";
	}

	public void setId(Integer id) {
		this.id = id;		
	}
	
	public void setSecondName(String secondName) {
		this.secondName= secondName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	
	public String getPassWord() {
		return password;
	}
	
	
	
	
	

}
