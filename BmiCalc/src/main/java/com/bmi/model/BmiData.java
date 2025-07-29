package com.bmi.model;

public class BmiData {
	
	private int id;
	private String name;
	private double weight;
	private double height;
	private double bmi;
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public BmiData(int id, String name, double weight, double height, double bmi) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.bmi = bmi;
	}
	public BmiData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
