import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;


public class Quiz {

    public static HashMap<String, String[]> characters = new HashMap<>();

    public Quiz() {

        characters.put("Rock", new String[]{
            "You're calm, steady, and reliable and unshakeable like a mountain!",
            """
               _______
            /         \\
            |          |
            |. (•_•)  |
            \\_______/
            """
        });
        characters.put("Chicken", new String[]{
        "You're kinda mindless, a little clucky, but full of energy and enthusiasm!",
            """
                 __  Quack!
               <(o )
                ( ._> /
                 `---'
            """
        });
        characters.put("Totoro", new String[]{
            "You're gentle, imaginative, and comforting to be around with a wholesome, magical aura!",
            """
                ／￣￣＼
               (  ´･ω･) yay!
               ()    ) づ
                しーJ
            """
        });
        characters.put("Cat", new String[]{
            "You are independent, elegant, full of energy, observant and clever!",
            """
             /\\_/\\ Meow!
            ( o.o )
             > ^ <
             |. .|
            """
        });

    }

    static String name;

    static Scanner sc = new Scanner(System.in);

    static Integer[] questionOrder;
    static int currentQuestionNumber = 1;


    public static void main(String[] args) throws Exception {

        new Question();

        Introscreen();

        int totalQuestions = Question.qaMap.size();
        questionOrder = new Integer[totalQuestions];

        for (int i = 0; i < totalQuestions; i++) {
            questionOrder[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(questionOrder));
        Question.askQuestion(questionOrder[0]);

        sc.close();

    }

    public static void Introscreen(){

        System.out.println("\n\n\nWhich VS Pet are you?\n\n\n");
        System.out.println("Presented by David and Gavin\n");
        System.out.println("Answer the following questions to find out which VS Pet matches your personality!\n");
        System.out.print("What is your name?  ");
        System.out.println("Enter your name:");
        name = sc.nextLine();
        System.out.println("\nWelcome, " + name + "! Please hit Enter to start the quiz!");
        sc.nextLine();

    }

    static String winner = "";
    static String description = "";
    static String asciiArt = "";

    public static void calculateResult() throws InterruptedException {

        new Quiz();
        
        System.out.print("Calculating");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(450);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int highest = 0;
        int highestIndex = 0;

        // Question.WhichOneAreYou
        for (int i = 0; i < Question.WhichOneAreYou.length; i++) {
            if (Question.WhichOneAreYou[i] >= highest) {
                highest = Question.WhichOneAreYou[i];
                highestIndex = i;
            }
        }

        int result = highestIndex;
        // String winner = "";
        // String description = "";
        // String asciiArt = "";

        switch (result) {
            case 0:
                winner = "Rock";
                description = characters.get(winner)[0];
                asciiArt = characters.get(winner)[1];
                break;
            case 1:
                winner = "Chicken";
                description = characters.get(winner)[0];
                asciiArt = characters.get(winner)[1];
                break;
            case 2:
                winner = "Totoro"; 
                description = characters.get(winner)[0];
                asciiArt = characters.get(winner)[1];
                break;
            case 3:
                winner = "Cat";
                description = characters.get(winner)[0];
                asciiArt = characters.get(winner)[1];
                break;
            default:
                System.out.println("Error calculating result.");
                break;
        }

        System.out.println("Thanks for completing the quiz, " + name + "! Your VS pet is: " + winner + "!\n");
        System.out.println(description);
        System.out.println(asciiArt);
        HashMap<String, HashMap<String, Integer>> printableScoreboard = scoreboard();
        for (String playerName : printableScoreboard.keySet()) {
            System.out.println("\n" + playerName + "'s characters:");
            HashMap<String, Integer> playerScores = printableScoreboard.get(playerName);
            for (String petName : playerScores.keySet()) {
                System.out.println(petName + ": " + playerScores.get(petName));
            }
        }
        System.out.println("Press Enter to restart the quiz!");
        sc.nextLine();
        Question.resetQuiz();

    }
    

    static HashMap<String, HashMap<String, Integer>> scoreboard = new HashMap<>();

    public static HashMap<String, HashMap<String, Integer>> scoreboard() {

        if (scoreboard.containsKey(name)) {
            HashMap<String, Integer>winIndex = scoreboard.get(name);
            int currentWins = winIndex.getOrDefault(winner, 0);
            winIndex.put(winner, currentWins + 1);
            scoreboard.put(name, winIndex);
        } else {
            HashMap<String, Integer> newWinIndex = new HashMap<>();
            newWinIndex.put(winner, 1);
            scoreboard.put(name, newWinIndex);
        }

        return scoreboard; //placeholder

    }
    
}
