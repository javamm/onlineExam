package models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exam")
public class Exam {

	private String question; // 问题

	private Options options;

	private String answer; // 参考答案，以,号分隔

	private String detail; // 答案解析

	@XmlElement(name = "question")
	public String getQuestion() {
		
		if(question != null){
			return question.trim();
		}
		
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	@XmlElement(name = "answer")
	public String getAnswer() {
		
		if(answer!=null){
			return answer.trim();
		}
		return answer;
	}

	@XmlElement(name = "options")
	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@XmlElement(name = "detail")
	public String getDetail() {
		if(detail!=null){
			return detail.trim();
		}
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
