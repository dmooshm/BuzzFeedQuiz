import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;
// import java.util.Random;

public class Question {

    public static List<Answer> ansList;
    public static int[] WhichOneAreYou = {0, 0, 0, 0};
    public static boolean rerun = false;

    public static HashMap<String, String[]> qaMap = new HashMap<>();

    public Question() {

        qaMap.put("Your good friend invited you to a dinner party in the evening a day in advance. You know that you will have limited time the next day, and will have to bring a dish to contribute.", 
        new String[]{
            "A chipotle catering set with 10 custom bowls", 
            "A snack collection of all your friends favorite chips and candies", 
            "A fancy fruit plate with a great amount of variety", 
            "A dutch oven of chicken noodle soup"
        });

        qaMap.put("If you could add one additional class to the Horace Mann curriculum, what would it be?", 
        new String[]{
            "Mental Fortification", 
            "Blindfolded Chess",
            "Advanced Observation and Strategy",
            "Tea Making 101"
        });

        qaMap.put("You walk into a Target and see a wide selection of different pillows on sale. Which do you choose?",
        new String[]{
            "White, medium-firm, rectangular pillow",
            "Plush dog pillow",
            "Memory-foam pillow that molds to your head shape",
            "A pillow of a giant stick of lip balm"
        });

        qaMap.put("What type of watch are you choosing…? Assume they are all worth the same:",
        new String[]{
            "G-Shock GA700",
            "Studio Ghibli x Seiko Collaboration Watch",
            "A really fancy one",
            "Casio F-91W"
        });

        qaMap.put("You are being sent to a deserted island and have to take one of the following items with you. Which do you prefer?:",
        new String[]{
            "A plain brick sitting on your porch that’s been there for years",
            "A giant plush avocado",
            "A perfectly stacked set of coasters that you never use but look aesthetically pleasing",
            "A half-melted candle that smells vaguely like burnt toast"
        });

        qaMap.put("It’s a snow day! What are you going to do?:",
        new String[]{
            "Lie in bed and scroll reels",
            "Sleep in and work on homework",
            "Roadtrip alone to Vermont to ski for the day",
            "Bike to Soho with my friends and treat them to dinner"
        });

        qaMap.put("You are offered a variety of jobs. They all pay handsomely. Which will you choose?:",
        new String[]{
            "Teacher",
            "Therapist",
            "I’ll start my own business!",
            "Truck driver"
        });

        qaMap.put("You need 500,000 dollars, and fast! What are you going to do?:",
        new String[]{
            "I’ll just get a loan!",
            "I’ll just continue working at my current job and save.",
            "I’ll trade stocks!",
            "I’ll gamble all of my money!"
        });

        qaMap.put("You’re picking a notebook for the school year. Which one feels right?:",
        new String[]{
            "A simple, sturdy hardcover",
            "A colorful spiral with fun patterns",
            "A clean dotted journal",
            "A soft pastel notebook with rounded edges"
        });

        qaMap.put("You're deciding on a weekend activity. You…",
        new String[]{
            "Take a hike",
            "Browse a local market",
            "Work on a personal project",
            "Lounge in a café with a book"
        });

        qaMap.put("Your phone background is…",
        new String[]{
            "Solid blue",
            "Photo collage of friends and family",
            "Black and white image of NYC skyline",
            "A random Pinterest illustration of a sunset"
        });

        qaMap.put("If you were buying socks, you’d choose…",
        new String[]{
            "Thick gray crew socks",
            "Yellow and white stripped socks",
            "Black socks that fit with everyday outfits",
            "Soft pastel socks with little clouds"
        });

        qaMap.put("You find a single coin on the sidewalk. What will you do!",
        new String[]{
            "Pick it up and put it in your wallet!",
            "Flip it three times for luck!",
            "Examine the year and mint carefully to check value!",
            "Place it in a small decorative dish at home!"
        });

        qaMap.put("Choosing a tea, you would rather have...",
        new String[]{
            "Classic earl gray black tea",
            "A wild fruit blend you’ve never tried",
            "A rare imported green tea",
            "Chamomile with a hint of lavender"
        });

    }


    public static Answer[] archivedAnswers;

    public static void askQuestion(int questionNumber) throws InterruptedException {
        
        ArrayList<String> keys = new ArrayList<>(qaMap.keySet());
        String question = keys.get(questionNumber - 1);

        if (!rerun) {
            System.out.println(question); 
        }

        String[] answers = qaMap.get(question);

        //map answers to a character
        Answer[] mappedAnswers = new Answer[answers.length];
        for (int i = 0; i < answers.length; i++) {
            mappedAnswers[i] = new Answer(answers[i], i + 1);
        }

        if (!rerun) {
            List<Answer> answerList = Arrays.asList(mappedAnswers);
            Collections.shuffle(answerList); //shuffle answers
            archivedAnswers = answerList.toArray(new Answer[0]);
            for (int i = 0; i < archivedAnswers.length; i++) { //print answers--including numbered formatting
                System.out.println("[" + (i+1) + "]: " + archivedAnswers[i].label);
            }
            ansList = answerList;
        } else {
            System.out.println("rerunning...");
            for (int i = 0; i < mappedAnswers.length; i++) { //print answers--including numbered formatting
                System.out.println("[" + (i+1) + "]: " + archivedAnswers[i].label);
            }
            rerun = false;
        }

        getResponse(new Scanner(System.in));

    }


    public static void getResponse(Scanner sc) throws InterruptedException {

        String input = sc.nextLine(); 

        int response = stringToInt(input);

        if (response != 1 && response != 2 && response != 3 && response != 4) {
            System.out.println();
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
            WhichOneAreYou[2]++;
            askNextQuestion();
        } else if(ansList.get(response-1).toID() == 4) {
            WhichOneAreYou[3]++;
            askNextQuestion();
        } 

    }


    public static int stringToInt (String answerString) {

        char[] charArray = answerString.toCharArray();
        for (char c : charArray) {
            if (c == '1' || c == '2' || c == '3' || c == '4') {
                int answerInt = Character.getNumericValue(c);
                return answerInt;
            }
        }
        return 0;
        
    }


    public static void askNextQuestion() throws InterruptedException {
        if (Quiz.currentQuestionNumber < Quiz.questionOrder.length) {
            System.out.println();
            Quiz.currentQuestionNumber++;
            askQuestion(Quiz.questionOrder[Quiz.currentQuestionNumber-1]);
        } else {
            Quiz.calculateResult();
        }
    }


    public static void resetQuiz() throws InterruptedException {
        WhichOneAreYou = new int[]{0, 0, 0, 0};
        Quiz.currentQuestionNumber = 1;
        Quiz.Introscreen();
        int totalQuestions = qaMap.size();
        Quiz.questionOrder = new Integer[totalQuestions];

        for (int i = 0; i < totalQuestions; i++) {
        Quiz.questionOrder[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(Quiz.questionOrder));
        askQuestion(Quiz.questionOrder[0]);
        }

}  
