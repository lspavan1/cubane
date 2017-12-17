package com.cubane;

import java.util.Random;
import java.util.Scanner;

public class GameShow {

    public static void main(String[] args) {
    	try{
        Scanner sc = new Scanner(System.in);
        
        int userSelection=0;
        int revealedBox=0;        
        int prizeBox=0;
        int firstSelection=0;
        String reChoise=null;
        Random randomNumber = new Random();

        System.out.println(" \nWelcome to the Game show. Prize money is one Million SEK **");
        
        try{
        do{
        	System.out.println("Please select one of the box out of (1 or 2 or 3) with out opening it ");
        	userSelection = sc.nextInt();
        }while(userSelection > 3 || userSelection < 0);
        }catch(Exception e){
        	System.out.println("You have entered wrong input. We are starting again");
        	GameShow.main(null);
        }
        
       /* Deciding the Prize money box */ 
        prizeBox = randomNumber.nextInt(3) + 1;
               
        //Revealing the non prize money box by keeping user selection and prize money box       
        do{
            revealedBox = randomNumber.nextInt(3)+1;
        }while(revealedBox == prizeBox || revealedBox == userSelection);

        System.out.println("Now we will see what is inside the boxes other than your selection");
        System.out.println("Now opening the box "+revealedBox);
        System.out.println("\nohh! box " + revealedBox+ " is empty!!");
        System.out.println("\nYour selection box number is " + userSelection+".Do you want to change your mind, picking the remaining box?");
        
        do{
            System.out.println("Please state your answer either (Yes/No)? ");
            reChoise = sc.next();
            
            if(reChoise.endsWith("y") || reChoise.equals("Y")){
            	reChoise="YES";
            }else if(reChoise.endsWith("n") || reChoise.equals("N")){
            	reChoise="NO";
            }
            
            reChoise=reChoise.toUpperCase();
        }while(!reChoise.equals("YES") && !reChoise.equals("NO"));       

        firstSelection = userSelection;
        
        //validating the choice
        if (reChoise.equals("YES")) {
            do{
            	
                userSelection = randomNumber.nextInt(3)+1;
            }while(userSelection == revealedBox || userSelection == firstSelection);
        }

        

        if (userSelection == prizeBox) {
            System.out.println("Congratulations!! You won the prize money ");
        } else {
            System.out.println("Sorry. You lost.  Prize money is inside box number "+prizeBox);
        }
    }catch(Exception e){
    	System.out.println("Sorry! exiting from the show due to some unexpected technical issues..");
    }
    }
}


