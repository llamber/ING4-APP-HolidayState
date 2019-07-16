/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaystates;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ludo
 */
public class OceanCruise extends Cruise {

    private double totalPrice;
    private double priceForChildren;
    private String destination;
    private final Scanner kb = new Scanner(System.in);

    public OceanCruise(StayInfos si) {
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
                    destination = "Pacific Ocean";
                    totalPrice = 182.30;
                    is_correct = true;
                    break;
                case 2:
                    destination = "Atlantic Ocean";
                    totalPrice = 162.78;
                    is_correct = true;
                    break;
                case 3:
                    destination = "Indian Ocean";
                    totalPrice = 127.58;
                    is_correct = true;
                    break;
                default:
                    is_correct = false;
            }
        }
        kb.nextLine();
    }

    public String getDestination() {
        return destination;
    }
    
    public double pricePerNightForAdultsInCruise() {
        return totalPrice * getAdults();
    }

    public double pricePerNightForChildrenInCruise() {
        if (getChildren() != 0) {
            for (int i = 0; i < getChildren(); i++) {
                if (getAgeChildren()[i] < 4) {
                    priceForChildren += pricePerNightForAdultsInCruise() / 4;
                } else if (getAgeChildren()[i] < 18) {
                    priceForChildren += pricePerNightForAdultsInCruise() / 2;
                }
            }
        } else {
            priceForChildren = 0;
        }
        return priceForChildren;
    }

    public double getTotalPrice() {
        totalPrice = (pricePerNightForAdultsInCruise() + pricePerNightForChildrenInCruise())
                * getDuration()
                + addAnimalOptionPrice();
        return totalPrice;
    }

    public void saveReceipt() {
        try {
            File file = new File("Ocean Cruise.txt");
            PrintWriter outputFile = new PrintWriter(file);
            outputFile.println("Destination :");
            outputFile.println(getDestination());
            outputFile.println("Duration :");
            outputFile.println(getDuration());
            outputFile.println("Price per night x Number of adults");
            outputFile.println(String.format("%.2f", pricePerNightForAdultsInCruise()) + " x " + getAdults());
            outputFile.println("Price per night x Number of children");
            outputFile.println(String.format("%.2f", pricePerNightForChildrenInCruise()) + " x " + getChildren());
            outputFile.println("Animal option :");
            outputFile.println(getAnimals() + " x " + String.format("%.2f", addAnimalOptionPrice()));
            outputFile.println("Total : " + String.format("%.2f", getTotalPrice()));
            outputFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OceanCruise.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
