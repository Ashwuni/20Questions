import java.io.PrintStream;
import java.util.Scanner;

public class QuestionTree {
	private QuestionNode treeRoot;
	private Scanner scanner; 
	private int totalGames;
	private int gamesWon;
	private PrintStream output;
	
	public QuestionTree(Scanner input, PrintStream output) throws IllegalArgumentException{
		if (input == null || output == null) {
			throw new IllegalArgumentException();}
		treeRoot = new QuestionNode("Celery");
		
		
		this.scanner = input;//new Scanner(output);
		this.output = output;
	}
	public void play() {
		if(treeRoot==null) {
			throw new IllegalArgumentException();
		}
		if(treeRoot!=null)
		//totalGames++;
		treeRoot = playHelper(treeRoot);
		//output.println("Challenge me again?");
		//String ans=scanner.next();
		/*if (UserInterface.nextAnswer(scanner)) {
			play();
		}else {
				output.println("Shall I recall our previous games?");
				if(UserInterface.nextAnswer(scanner)==false) {
					//totalGames =0;
					//gamesWon =0;
				}
			}*/
			}
		private QuestionNode playHelper(QuestionNode temp) {
			
			if (temp.answerNo == null && temp.answerYes == null) { //DOES NOT OR DOES
				output.println("Would your object happen to be " +	temp.data+"? ");
				if (UserInterface.nextAnswer(scanner)) {
					output.println("I win!");
					gamesWon++;
					totalGames++;
				} else {
					totalGames++;
					output.println("I lose. What is your object? ");
		            QuestionNode answer = new QuestionNode(scanner.nextLine());
		            output.println("Type a yes/no question to distinguish our item from " + temp.data+ ": ");
		            String question = scanner.nextLine(); 
		            
		            output.println("And what is the answer for your object? ");
		            if (UserInterface.nextAnswer(scanner)) {
		               temp = new QuestionNode(question, answer, temp); 
		            } else {
		               temp = new QuestionNode(question, temp, answer); 
		            }   
				}
			}else {
				output.print(temp.data);
				
				if (UserInterface.nextAnswer(scanner)){
		            temp.answerYes = playHelper(temp.answerYes);
		         } else {
		            temp.answerNo = playHelper(temp.answerNo); 
		         }   
		      
		      
			}
			return temp;
		}

			
		
//	public String checkIfYes(Questio answer) {
//		
//		if (scanner.equals("yes")) {
//			return ("yes");
//		}else { return ("no");}
//		//if yes, else no
//	}
	public void save(PrintStream output) {
		if (output != null) {
			saveHelper(output, treeRoot);
		} throw new IllegalArgumentException();
	}
	
		private void saveHelper(PrintStream output, QuestionNode treeRoot) {
			if (treeRoot.answerNo == null && treeRoot.answerYes == null) {   //DOES NOT OR DOES
				output.println("A: " + treeRoot.data); 
			} else {
				output.println("Q: " + treeRoot.data); 
				saveHelper(output, treeRoot.answerYes);
				saveHelper(output, treeRoot.answerNo);
			}
		}
	
	
	
	public void load(Scanner input) {
	//	while(input.hasNextLine()) {
		if (input==null) {
			throw new IllegalArgumentException();
		}
		if (input.hasNextLine()) {
			treeRoot = loadHelper(input);}
		}
	
	
		private QuestionNode loadHelper(Scanner input) {
			String QorA = input.nextLine().toUpperCase();
			String d = QorA.substring(2);
			
			QuestionNode node = new QuestionNode(d);
			
			if (QorA.startsWith("Q") ) {
				node.answerYes = loadHelper(input);
				node.answerNo = loadHelper(input);
			} return node;
		}
		
		
		
		
	public int totalGames() {
		return totalGames;
	}
	public int gamesWon() {
		return gamesWon;
	}
	
}
