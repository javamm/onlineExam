package controllers;

import java.util.List;

import models.Exam;
import models.ExamXmlBean;
import play.Play;
import play.cache.Cache;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {

		// if (Http.Request.current().cookies.get("name") != null) {
		// System.out.println(Http.Request.current().cookies.get("name").value);
		// }

		List<Exam> exams = getExams();

		int random = (int) (Math.random() * exams.size());
		// Http.Response.current().setCookie("name", "savage", "10s");//
		// 10h,10mn,10s

		Exam exam = exams.get(random);
		render(exam);
	}

	private static List<Exam> getExams() {
		List<Exam> exams = Cache.get("exams", List.class);

		if (exams == null) {
			exams = ExamXmlBean.fromXml(
					Play.applicationPath.getPath() + "/conf/examBank.xml")
					.getExams();
			Cache.set("exams", exams);
		}

		return exams;
	}

}