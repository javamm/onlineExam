package models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import controllers.XMITransform;

@XmlRootElement(name = "exams")
public class ExamXmlBean {

	private List<Exam> exams;

	@XmlElement(name = "exam")
	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public static ExamXmlBean fromXml(String filePath) {
		return (ExamXmlBean) XMITransform.loadFile(filePath, ExamXmlBean.class);
	}
	
	public static void main(String[] args) {
		ExamXmlBean examXmlBean=ExamXmlBean.fromXml("D:\\play-1.2.4\\play-1.2.4\\onlineExam\\conf\\examBank.xml");
		System.out.println(examXmlBean);
	}
}
