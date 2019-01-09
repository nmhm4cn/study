package model;

public class BmrCheckLogic {
	public void execute(Health health) {
		// BMRの算出
		double height = health.getHeight();
		double weight = health.getWeight();
		int age = health.getAge();
		String gender = health.getGender();
		double bmr;
		if(gender == "M") {
			bmr = 13.397 * weight + 4.799 * height - 5.677 * age + 88.362;
		} else if(gender == "F") {
			bmr = 9.247 * weight + 3.098 * height - 4.33 * age + 447.593;
		} else {
			bmr = 0;
		}
		health.setBmr(bmr);
	}

}
