/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaystates;

import java.util.Scanner;

public class Cruise extends StayInfos {

    private final double priceForOneAnimal = 50;
    private final Scanner kb = new Scanner(System.in);
    StayInfos si;

    public Cruise(StayInfos si) {
        super(si.getBeginning(),
                si.getEnd(),
                si.getAdults(),
                si.getChildren(),
                si.getAgeChildren(),
                si.getAnimals());
        this.si=si;
    }

    public void chooseTypeOfCruise() {
        boolean is_correct = false;
        while (is_correct == false) {
            System.out.println("Do you want stopovers ? y/n");
            String answer = kb.nextLine();
            System.out.println("\n");
            switch (answer.charAt(0)) {
                case 'y':
                    AdventureCruise acr = new AdventureCruise(si);
                    Menu.showCruiseCircuits(); // display the different destinations
                    acr.setDestination();  // ask user to chose a destination
                    acr.addPriceNumberOfStepOvers(); //Add the price of the option to the total price
                    System.out.println(acr.getTotalPrice()); //Display cost of vacation
                    //acr.saveReceipt();
                    is_correct = true;
                    break;
                case 'n':
                    OceanCruise ocr = new OceanCruise(si);
                    Menu.showDestination();
                    ocr.setDestination();
                    ocr.saveReceipt(); //<-- Normally it should save the receipt in a .txt file
                    is_correct = true;
                    break;
                default:
                    is_correct = false;
            }
        }
    }

    public double addAnimalOptionPrice() {
        return getAnimals() * this.priceForOneAnimal;
    }

}
