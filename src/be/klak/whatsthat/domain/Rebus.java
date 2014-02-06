package be.klak.whatsthat.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Rebus {

	@Id
	private Long id;

	private Drawing drawing;
	private String answer;

	public Rebus() {
	}

	public Rebus(Drawing drawing, String answer) {
		this.drawing = drawing;
		this.answer = answer;
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Drawing getDrawing() {
		return drawing;
	}

	public String getAnswer() {
		return answer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
