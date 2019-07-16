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
public class Camping extends StayInfos {

    private double totalPrice;
    private String destination = null;
    private double priceForChildren;
    private final double priceForOneAnimal = 20;
    private double priceForElectricity = 0;
    private double priceOptionAnimals;
    private double priceAnimationChildren = 0;
    StayInfos si;
    private Scanner kb = new Scanner(System.in);

    public Camping(StayInfos si) {
        super(si.getBeginning(),
                si.getEnd(),
                si.getAdults(),
                si.getChildren(),
                si.getAgeChildren(),
                si.getAnimals());
        this.si = si;
    }

    public void setDestination() {
        int choice = 0;
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
                    destination = "Les flows bleues";
                    totalPrice = 32.30;
                    is_correct = true;
                    break;
                case 2:
                    destination = "La ginguette";
                    totalPrice = 36.78;
                    is_correct = true;
                    break;
                case 3:
                    destination = "Le Mora Road";
                    totalPrice = 27.58;
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
    
    

    public void chooseTypeOfCamping() {
        int choice;
        initPriceChildrenAnimation(20);
        do {
            System.out.println("What do you choose : ");
            while (!kb.hasNextInt()) {
                System.out.println("Enter a number");
                kb.next();
            }
            choice = kb.nextInt();
            System.out.println("\n");
        } while (choice <= 0 || choice >= 4);
        switch (choice) {
            case 1:
                Tent tent = new Tent(si);
                Menu.showCampingDestination();
                tent.setDestination();
                tent.addPriceRentTent();
                tent.saveReceipt();
                break;
            case 2:
                Bungalow bung = new Bungalow(si);
                Menu.showCampingDestination();
                bung.setDestination();
                bung.initPriceRoomPerPersonn();
                bung.saveReceipt();
                break;
            case 3:
                CampingCar ccar = new CampingCar(si);
                Menu.showCampingDestination();
                ccar.setDestination();
                ccar.addPriceForGaz();
                ccar.addPriceForWater();
                ccar.saveReceipt();
                break;
        }

    }
    

    public void initAnimalOptionPrice() {
        priceOptionAnimals = getAnimals() * priceForOneAnimal;
    }

    public double getPriceOptionAnimals() {
        return priceOptionAnimals;
    }

    public void addPriceForElectricity() {
        boolean is_correct = false;
        String answer;
        while (is_correct == false) {
            System.out.println("Do you want electricity (+5€/day) ? y/n ");
            answer = kb.next();
            switch (answer.charAt(0)) {
                case 'Y':
                case 'y':
                    priceForElectricity = getDuration() * 5;
                    is_correct = true;
                    break;
                case 'N':
                case 'n':
                    priceForElectricity = 0;
                    is_correct = true;
                    break;
                default:
                    is_correct = false;
            }
        }
    }

    public double getPriceForElectricity() {
        return priceForElectricity;
    }
    
    public double pricePerNightForAdultsInCamping() {
        return totalPrice * getAdults();
    }

    public double pricePerNightForChildrenInCamping() {
        if (getChildren() != 0) {
            for (int i = 0; i < getChildren(); i++) {
                priceForChildren += pricePerNightForAdultsInCamping() / 1.2;
            }
        } else {
            priceForChildren = 0;
        }
        return priceForChildren;
    }

    public void initPriceChildrenAnimation(double price) {
        boolean animation = false;
        boolean is_correct = false;
        double priceAnimationChildren = 0;
        String answer;
        if (getChildren() == 0) {
            priceAnimationChildren = 0;
        } else {
            while (is_correct == false) {
                System.out.println("Do you want animation for your children (+100€/child) ? y/n ");
                answer = kb.next();
                switch (answer.charAt(0)) {
                    case 'Y':
                    case 'y':
                        animation = true;
                        is_correct = true;
                        break;
                    case 'N':
                    case 'n':
                        animation = false;
                        is_correct = true;
                        break;
                    default:
                        is_correct = false;
                }
            }
            if (animation) {
                priceAnimationChildren = +price * getChildren();
            }
        }
    }

    public double getPriceAnimationChildren() {
        return priceAnimationChildren;
    }

}
