package model;

import java.util.jar.Attributes.Name;

public class Player {
	private String name;
	private int id;
	private int  age;
	private double salary;
	private String location;
	
	//构造方法
	public Player(int id,String name,int age,double salary,String location){
		this.setName(name);
		this.setAge(age);
		this.setSalary(salary);
		this.setLocation(location);
		this.id=id;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






