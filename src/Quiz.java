import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Quiz {

    static Category rock = new Category("Rock", ""); //fill out descriptions later
    static Category chicken = new Category("Chicken", "");
    static Category totoro = new Category("Totoro", "");
    static Category cat = new Category("Cat", "");

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {


        Introscreen();
        Question.askQuestion(1);

    

       
        // System.out.println(content);
      //  Question.askQuestion(1);
        
       // System.out.println(Collections.shuffle(List.of(possibleAnswers)));

    }




    public static void Introscreen(){

        System.out.println("\n\n\nWhich VS Pet are you?\n\n\n");

        System.out.println("Presented by David and Gavin\n");
        System.out.println("Answer the following questions to find out which VS Pet matches your personality!\n");
        System.out.println("Press Enter to begin the quiz!");

        sc.nextLine();

    }
    

}