package model;

public class BmiCheckLogic {
	public void execute(Health health) {
		// BMI算出
		double height = health.getHeight();
		double weight = health.getWeight();
		double bmi = weight / (height / 100.0 * height / 100.0);
		health.setBmi(bmi);

		// BMIから体型を判定
		String bodyType;
		if (bmi < 18.5) {
			bodyType = "痩せ";
		} else if (bmi < 25) {
			bodyType = "普通";
		} else {
			bodyType = "肥満";
		}
		health.setBodyType(bodyType);
	}
}
