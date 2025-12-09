import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Question {
    
    // public static String[] questionInfo(int questionNumber) {
        
    //     ArrayList<String> content = new ArrayList<String>(List.of(
            
    //         "question 1: answerA: answerB: answerC: answerD",
    //         "question 2: answerA: answerB: answerC: answerD"
            
    //     ));
        
    //     String[] parts = content.get(questionNumber - 1).split(": ");
        
    //     return parts;
        
    // }

    public static void askQuestion(int questionNumber) {
        
        ArrayList<String> content = new ArrayList<String>(List.of(
            
            "question 1: answerA: answerB: answerC: answerD",
            "question 2: answerA: answerB: answerC: answerD"
            
        ));
        
        String[] parts = content.get(questionNumber - 1).split(": ");
        
        Answer[] possibleAnswers = new Answer[4];
        for (int i = 0; i < 4; i++) {
            possibleAnswers[i] = new Answer(parts[i+1], i);
        }
        

    
    
    // String label;
    // Question(String label) {
    //     this.label = label;
    // }
    

    // ask a question, and return the category that corresponds to the answer
    // Category ask(Scanner sc) {
    //     System.out.println(this.label);
    //     // prints out all the answer choices
    //     for (int i = 0; i < this.possibleAnswers.length; i++) {
    //         String choice = Integer.toString(i + 1);
    //         System.out.println("[" + choice + "]:" +
    //                 this.possibleAnswers[i].label);
    //     }
    //     int ans = sc.nextInt();
    //     return possibleAnswers[ans - 1].cat;
    // }

    }
}