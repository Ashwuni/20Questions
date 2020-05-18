
public class QuestionNode {
	public QuestionNode answerYes;
	public QuestionNode answerNo;
	public String data;
	
	public QuestionNode (String data) {
		this(data, null, null);
	}
	
	public QuestionNode(String data, QuestionNode answerYes, QuestionNode answerNo) {
		this.data = data;
		this.answerNo =  answerNo;
		this.answerYes = answerYes;
		
	}
}
