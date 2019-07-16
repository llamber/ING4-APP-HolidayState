/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaystates;

import java.util.Scanner;

/**
 *
 * @author Ludo
 */
public class Menu {

    static void showKindOfVacation() {
        System.out.println("What kind of vacation do you want");
        System.out.println("Choose 1 - for Cruises");
        System.out.println("Choose 2 - for Camping");
    }
    
    static int selectionInMenuWithNumber(int min, int max) {
        int choice;
        Scanner kb = new Scanner(System.in);
        do {
            while (!kb.hasNextInt()) {
                System.out.println("Enter a number");
                kb.next();
            }
            choice = kb.nextInt();
        } while (choice < min || choice > max);
        return choice;
    }
    
    static void showTypeOfCruise() {
        System.out.println("Do you want Adventure Cruise or Ocean Cruise ?");
        System.out.println("On the first one, the ship will make severals stopovers ");
        System.out.println("On the second one, embark in a luxious ship and enjoy ocean relaxing fresh air \n");
        System.out.println("Special offer on Cruises: ");
        System.out.println("Children under 4 yo : -75% ");
        System.out.println("Children under 18 yo : -50% ");
        System.out.println("Only 50€/animals you'll bring \n");
        
    }
    
    static void showTypeOfCampingRent() {
        System.out.println("Do you want to rent a tent, a bungalow or a camping car emplacment ?");
        System.out.println("1 - Tent");
        System.out.println("2 - Bungalow");
        System.out.println("3 - Camping Car");
        System.out.println("Only 20€/animals you'll bring \n");
    }
    
    static void showCampingDestination() {
        System.out.println("You can go on following camping :");
        System.out.println("1 - Les flows bleues");
        System.out.println("Price per nigh from : 32.30");
        System.out.println("2 - La ginguette");
        System.out.println("Price per nigh from : 36.78");
        System.out.println("3 - Le Mora Road");
        System.out.println("Price per nigh from : 27.58");
    }
    
    static void showDestination() {
        System.out.println("You can go on cruise on following oceans :");
        System.out.println("1 - Pacific Ocean");
        System.out.println("Price per nigh from : 182.30");
        System.out.println("2 - Atlantic Ocean");
        System.out.println("Price per nigh from : 162.78");
        System.out.println("3 - Indian Ocean");
        System.out.println("Price per nigh from : 127.58");
    }
    
    static void showCruiseCircuits() {
        System.out.println("You can go on cruise on following circuits :");
        System.out.println("1 - North American Coasts");
        System.out.println("Price per nigh from : 265.30");
        System.out.println("2 - South American Coasts");
        System.out.println("Price per nigh from : 354.56");
        System.out.println("3 - West European Coasts");
        System.out.println("Price per nigh from : 215.58");
    }


}
