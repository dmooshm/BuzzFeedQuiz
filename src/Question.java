import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;


public class Question {

    public static List<Answer> ansList;

    public static void askQuestion(int questionNumber) {
        
        ArrayList<String> content = new ArrayList<String>(List.of(
            
            "question 1: answerA: answerB: answerC: answerD",
            "question 2: answerA: answerB: answerC: answerD", 
            "question 3: answerA: answerB: answerC: answerD",
            "question 4: answerA: answerB: answerC: answerD",
            "question 5: answerA: answerB: answerC: answerD",
            "question 6: answerA: answerB: answerC: answerD"
            // "Your good friend invites you to a dinner party in the evening a day in advance. You know that you will have limited time the next day, and will have to bring a dish to contribute. What would you bring?: A snack collection of all your friends favorite chips and candies: A chipotle catering set with 10 custom bowls: A dutch oven of chicken noodle soup: A fancy fruit plate with a great amount of variety"
            
        ));
        
        String[] parts = content.get(questionNumber - 1).split(": ");

        System.out.println(parts[0]); //print question
        
        Answer[] possibleAnswers = new Answer[4]; //print answers
        for (int i = 0; i < 4; i++) {
            possibleAnswers[i] = new Answer(parts[i+1], i+1);
        }

        ansList = Arrays.asList(possibleAnswers);
        Collections.shuffle(ansList); //shuffle answers
        for (int i = 0; i < ansList.size(); i++) { //print answers--including numbered formatting
            System.out.println("[" + (i+1) + "]: " + ansList.get(i).toString());
        }

        getResponse(new Scanner(System.in)); 

        int[] WhichOneAreYou = new int[4];
        



    }

    
    

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

    public static Category getResponse(Scanner sc){

        // Category rock = new Category("Rock", ""); //fill out descriptions later
        // Category chicken = new Category("Chicken", "");
        // Category totoro = new Category("Totoro", "");
        // Category cat = new Category("Cat", "");

        int response = sc.nextInt(); //get user input; set it as response
        System.out.println("You typed:" + response); //print what the user typed
        // System.out.println("You selected: " + ansList.get(response-1).toString()); //print what the user selected

        if (response != 1 && response != 2 && response != 3 && response != 4) {
            System.out.println("That isn't an option :( -- Please select one of the answers below:");
            for (int i = 0; i < ansList.size(); i++) { //print answers--including numbered formatting
                System.out.println("[" + (i+1) + "]: " + ansList.get(i).toString());
            }
            return null;
        } else if(ansList.get(response-1).toID() == 1) {
            return Quiz.rock; //if answer is 1, return rock category
        } else if(ansList.get(response-1).toID() == 2) {
            return Quiz.chicken; //if answer is 2, return chicken category
        } else if(ansList.get(response-1).toID() == 3) {
            return Quiz.totoro; //if answer is 3, return totoro category
        } else if(ansList.get(response-1).toID() == 4) {
            return Quiz.cat;
        } 

        return null;

    }

}  