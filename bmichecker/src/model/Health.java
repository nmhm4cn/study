package model;

import java.io.Serializable;

public class Health implements Serializable{

	private double height, weight;
	private int age;
	private String gender, bmi, bodyType, bmr;

	public double getHeight() { return height; }
	public void setHeight(double height) { this.height = height; }
	public double getWeight() { return weight; }
	public void setWeight(double weight) { this.weight = weight; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public String getGender() { return this.gender; }
	public void setGender(String gender) {
		if(gender.equals("M")) { this.gender = "M"; }
		else if(gender.equals("F")) { this.gender = "F"; }
	}
	public String getBmi() { return bmi; }
	public void setBmi(double bmi) { this.bmi = String.format("%.2f", bmi); }
	public String getBodyType() { return bodyType; }
	public void setBodyType(String bodyType) { this.bodyType = bodyType; }
	public String getBmr() { return bmr; }
	public void setBmr(double bmr) {this.bmr = String.format("%.3f", bmr); }
}
