/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaystates;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ludo
 */
public class AdventureCruise extends Cruise {

    private double totalPrice;
    private String Circuit;
    private double priceForChildren;
    private Scanner kb = new Scanner(System.in);

    public AdventureCruise(StayInfos si) {
        super(si);
    }
    
    public void setDestination() {
        int choice = 0;
        String answer = null;
        boolean is_correct = false;
        while (is_correct == false) {
            System.out.println("Choose a destination");
            while (!kb.hasNextInt()) {
                System.out.println("Enter a number");
                kb.next();
            }
            choice = kb.nextInt();
            switch (choice) {
                case 1:
                    Circuit = "North American Coasts";
                    totalPrice = 265.30;
                    is_correct = true;
                    break;
                case 2:
                    Circuit = "South American Coasts";
                    totalPrice = 354.56;
                    is_correct = true;
                    break;
                case 3:
                    Circuit = "West European Coasts";
                    totalPrice = 215.58;
                    is_correct = true;
                    break;
                default:
                    is_correct = false;
            }
        }
        kb.nextLine();
    }

    public String getCircuit() {
        return Circuit;
    }
    

    public double addPriceNumberOfStepOvers() {
        System.out.println("5 stepovers are included in the price");
        System.out.println("+200€ per stopover over 5");
        double optionPrice;
        int numberOfStepOvers;
        do {
            System.out.println("How many Stepovers do you want : (total)");
            while (!kb.hasNextInt()) {
                System.out.println("Enter a number");
                kb.next();
            }
            numberOfStepOvers = kb.nextInt();
        } while (numberOfStepOvers < 0);
        if (numberOfStepOvers > 5) {
            optionPrice = numberOfStepOvers - 5 * 200;
        } else {
            optionPrice = 0;
        }
        return optionPrice;
    }

    

    public double pricePerNightForAdultsInCruise() {
        return totalPrice * getAdults();
    }

    public double pricePerNightForChildrenInCruise() {
        if (getChildren() != 0) {
            for (int i = 0; i < getChildren(); i++) {

                priceForChildren += pricePerNightForAdultsInCruise() / 1.2;

            }
        } else {
            priceForChildren = 0;
        }
        return priceForChildren;
    }

    public double getTotalPrice() {
        totalPrice = (pricePerNightForAdultsInCruise() + pricePerNightForChildrenInCruise())
                * getDuration()
                + addAnimalOptionPrice()
                + addPriceNumberOfStepOvers();
        return totalPrice;
    }

    public void showPrice() {
        try {
            File file = new File("Adventure Cruise.txt");
            PrintWriter outputFile = new PrintWriter(file);
            outputFile.println("Circuit :");
            outputFile.println(getCircuit());
            outputFile.println("Duration :");
            outputFile.println(getDuration());
            outputFile.println("Price per night x Number of adults");
            outputFile.println(String.format("%.2f", pricePerNightForAdultsInCruise()) + " x " + getAdults());
            outputFile.println("Price per night x Number of children");
            outputFile.println(String.format("%.2f", pricePerNightForChildrenInCruise()) + " x " + getChildren());
            outputFile.println("50€ x number of animals");
            outputFile.println(addAnimalOptionPrice());
            outputFile.println("Option more than 5 stopovers");
            outputFile.println(addPriceNumberOfStepOvers());
            outputFile.println("Total : " + getTotalPrice());
            outputFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OceanCruise.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
