package classes;

//Класс загадка
public class Mystery {
    private String name;
    private int pictureId;
    private int pictureAnswer;
    private String answer;
    private String question;
	
    public Mystery(String name, String question, String answer, 
    		int pictureIdMin, int pictureAnswer) 
    {
	  setName(name);
	  setQuestion(question);
	  setAnswer(answer);
	  setPictureId(pictureIdMin);
	  setPictureAnswer(pictureAnswer);
	}
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public int getPictureAnswer() {
		return pictureAnswer;
	}

	public void setPictureAnswer(int pictureAnswer) {
		this.pictureAnswer = pictureAnswer;
	}
}
