package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BmiCheckLogic;
import model.BmrCheckLogic;
import model.Health;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthCheck.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメーター取得
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");

		// 入力値をプロパティに設定
		Health health = new Health();
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));
		health.setAge(Integer.parseInt(age));
		health.setGender(gender);

		// BMI診断を実行し結果を設定
		BmiCheckLogic bmiCheckLogic = new BmiCheckLogic();
		bmiCheckLogic.execute(health);

		// BMR診断をし実行結果を設定
		BmrCheckLogic bmrCheckLogic = new BmrCheckLogic();
		bmrCheckLogic.execute(health);

		// リクエストスコープに保存
		request.setAttribute("health", health);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthCheckResult.jsp");
		dispatcher.forward(request, response);
	}

}
