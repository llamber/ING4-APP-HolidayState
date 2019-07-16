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
public class CampingCar extends Camping {

    private Scanner kb = new Scanner(System.in);
    private double totalPriceForAllDuration;
    private double priceForGaz=0, priceForWater =0;

    public CampingCar(StayInfos si) {
        super(si);
    }

    public void addPriceForWater() {
        boolean is_correct = false;
        String answer;
        while (is_correct == false) {
            System.out.println("Do you want water on field (+7€/day) ? y/n ");
            answer = kb.next();
            switch (answer.charAt(0)) {
                case 'Y':
                case 'y':
                    priceForWater = getDuration() * 7;
                    is_correct = true;
                    break;
                case 'N':
                case 'n':
                    priceForWater = 0;
                    is_correct = true;
                    break;
                default:
                    is_correct = false;
            }
        }
    }

    public void addPriceForGaz() {
        boolean is_correct = false;
        String answer;
        while (is_correct == false) {
            System.out.println("Do you want gaz on field (+7€/day) ? y/n ");
            answer = kb.next();
            switch (answer.charAt(0)) {
                case 'Y':
                case 'y':
                    priceForGaz = getDuration() * 7;
                    is_correct = true;
                    break;
                case 'N':
                case 'n':
                    priceForGaz = 0;
                    is_correct = true;
                    break;
                default:
                    is_correct = false;
            }
        }
    }

    public double getPriceForGaz() {
        return priceForGaz;
    }

    public double getPriceForWater() {
        return priceForWater;
    }
    

    public double getTotalPrice() {
        totalPriceForAllDuration = ((pricePerNightForAdultsInCamping() + pricePerNightForChildrenInCamping())
                * getDuration()) + getPriceOptionAnimals()+ getPriceAnimationChildren() 
                + getPriceForGaz() + getPriceForWater() + getPriceForElectricity();
        return totalPriceForAllDuration;
    }
    
    public void saveReceipt() {
        try {
            File file = new File("Camping Car.txt");
            PrintWriter outputFile = new PrintWriter(file);
            outputFile.println("Destination");
            outputFile.println(getDestination());
            outputFile.println("Duration :");
            outputFile.println(getDuration());
            outputFile.println("Price per night x Number of adults");
            outputFile.println(String.format("%.2f", pricePerNightForAdultsInCamping()) + " x " + getAdults());
            outputFile.println("Price per night x Number of children");
            outputFile.println(String.format("%.2f", pricePerNightForChildrenInCamping()) + " x " + getChildren());
            outputFile.println("Animal option :");
            outputFile.println(getAnimals() + " x " + String.format("%.2f", getPriceOptionAnimals()));
            outputFile.println("Option for electricity");
            outputFile.println(String.format("%.2f", getPriceForElectricity()));
            outputFile.println("Option for Gaz");
            outputFile.println(String.format("%.2f", getPriceForGaz()));
            outputFile.println("Option for Water");
            outputFile.println(String.format("%.2f", getPriceForWater()));
            outputFile.println("Option animation for children");
            outputFile.println(getChildren() + " x " + String.format("%.2f", getPriceAnimationChildren()));
            outputFile.println("Total : " + String.format("%.2f", getTotalPrice()));
            outputFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OceanCruise.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
