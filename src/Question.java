import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;


public class Question {

    public static List<Answer> ansList;
    public static int[] WhichOneAreYou = {0, 0, 0, 0};
    public static boolean rerun = false;

    public static void askQuestion(int questionNumber) {
        
        ArrayList<String> content = new ArrayList<String>(List.of(
            
            "question 1: answerA: answerB: answerC: answerD",
            "question 2: answerA: answerB: answerC: answerD", 
            "question 3: answerA: answerB: answerC: answerD",
            "question 4: answerA: answerB: answerC: answerD",
            "question 5: answerA: answerB: answerC: answerD"
            // "Your good friend invites you to a dinner party in the evening a day in advance. You know that you will have limited time the next day, and will have to bring a dish to contribute. What would you bring?: A snack collection of all your friends favorite chips and candies: A chipotle catering set with 10 custom bowls: A dutch oven of chicken noodle soup: A fancy fruit plate with a great amount of variety"
            
        ));
        
        String[] parts = content.get(questionNumber - 1).split(": ");

        if (rerun == false) {
            System.out.println(parts[0]); //print question
        }
        rerun = false;

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

        // int[] WhichOneAreYou = {0, 0, 0, 0};

    }


    public static void getResponse(Scanner sc){

        int response = sc.nextInt(); //get user input; set it as response

        if (response != 1 && response != 2 && response != 3 && response != 4) {
            System.out.println("That isn't an option :( -- Please select one of the answers below:");
            rerun = true;
            askQuestion(Quiz.questionOrder[Quiz.currentQuestionNumber-1]);
        } else if(ansList.get(response-1).toID() == 1) {
            WhichOneAreYou[0]++;
            askNextQuestion();
        } else if(ansList.get(response-1).toID() == 2) {
            WhichOneAreYou[1]++;
            askNextQuestion();
        } else if(ansList.get(response-1).toID() == 3) {
            askNextQuestion();
            WhichOneAreYou[2]++;
        } else if(ansList.get(response-1).toID() == 4) {
            WhichOneAreYou[3]++;
            askNextQuestion();
        } 

    }


    public static void askNextQuestion() {

        if (Quiz.currentQuestionNumber < 5) {
            Quiz.currentQuestionNumber++;
            askQuestion(Quiz.questionOrder[Quiz.currentQuestionNumber-1]);
        } else {
            Quiz.calculateResult();
        }

    }

}  