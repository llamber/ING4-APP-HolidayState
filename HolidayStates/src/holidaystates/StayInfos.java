/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaystates;

import java.time.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author 931801180
 */
public class StayInfos {

    private LocalDateTime beginning;
    private LocalDateTime end;
    private int adults;
    private int children;
    private int[] ageChildren;
    private int animals;
    private final Scanner kb = new Scanner(System.in);

    public StayInfos() {
        initAdultNumber();
        initChildrenNumber();
        initArrayChildrenAge();
        initAnimalsNumber();
        initDates();
        
    }

    public StayInfos(LocalDateTime beginning, LocalDateTime end, int adults, int children, int[] ageChildren, int animals) {
        this.beginning = beginning;
        this.end = end;
        this.adults = adults;
        this.children = children;
        this.ageChildren = ageChildren;
        this.animals = animals;
    }
    
    

    private void initAdultNumber() {
        do {
            System.out.println("How many adults : ");
            while (!kb.hasNextInt()) {
                System.out.println("Enter a number");
                kb.next();
            }
            this.adults = kb.nextInt();
        } while (this.adults <= 0);

    }

    private void initChildrenNumber() {
        do {
            System.out.println("How many children : ");
            while (!kb.hasNextInt()) {
                System.out.println("Enter a number");
                kb.next();
            }
            this.children = kb.nextInt();
        } while (this.children < 0 );
    }

    private void initAnimalsNumber() {
        String answer;
        kb.nextLine();
        do {
            System.out.println("Will you bring animals :");
            answer = kb.nextLine();
            if (answer.charAt(0) == 'y') {
                do {
                    System.out.println("How many animals : ");
                    while (!kb.hasNextInt()) {
                        System.out.println("Enter a number");
                        kb.next();
                    }
                    this.animals = kb.nextInt();
                } while (this.animals < 0);
                kb.nextLine();
            }
            else if (answer.charAt(0) == 'n') {
                this.animals = 0;
            } else {
                this.animals = -1;
            }
        } while (this.animals < 0);
    }

    private void initArrayChildrenAge() {
        ageChildren = new int[children];
        if (children != 0) {
            for (int i = 0; i < children; i++) {
                System.out.println("Enter age of children " + (i + 1) + " : ");
                do {
                    while (!kb.hasNextInt()) {
                        System.out.println("Enter a number");
                        kb.next();
                    }
                    this.ageChildren[i] = kb.nextInt();
                } while (this.ageChildren[i] < 0 || this.ageChildren[i]>18);
            }
        }
    }

    private void initDates() {
        System.out.println("Enter start date");
        this.beginning = dateStringToLocalDateTime(checkFormatDate());
        System.out.println("Enter end date");
        do {
            this.end = dateStringToLocalDateTime(checkFormatDate());
        } while (!beginning.isBefore(end));
    }

    private String checkFormatDate() {
        String answer = null;
        Pattern p = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        do{ //Verify format and existing date
            System.out.println("Enter date (dd/mm/yyyy)");
            answer = kb.nextLine();
        }while(!p.matcher(answer).matches());
        return answer;
    }

    private LocalDateTime dateStringToLocalDateTime(String dateInString) {
        LocalDateTime date = null;
        String[] splitDate;
        boolean is_correct = false;
        while (is_correct == false) {
            try {
                is_correct = true;
                splitDate = dateInString.split("/"); //Create an array of integers separated in the string by '/'
                date = LocalDateTime.of(Integer.parseInt(splitDate[2])
                        ,Integer.parseInt(splitDate[1])
                        ,Integer.parseInt(splitDate[0])
                        ,0,0); //Create a LocalDateTime object
            } catch (Exception e) {
                is_correct = false;
            }
        }
        return date;
    }

    /*
     * Convert the time difference in ms in number of day
     */
    public double getDuration() {
        return end.getDayOfYear() - beginning.getDayOfYear();
    }
    
    public int createSubObject(int choice){
        switch(choice){
            case 1:
                System.out.println("You chose Cruises\n");
                Cruise cr = new  Cruise(this);
                Menu.showTypeOfCruise();
                cr.chooseTypeOfCruise();
                cr.addAnimalOptionPrice();
                break;
            case 2:
                System.out.println("You chose Camping\n");
                Camping camp = new Camping(this);
                Menu.showTypeOfCampingRent();
                camp.chooseTypeOfCamping();
                camp.addPriceForElectricity();
        }
        return choice;
    }
    
    public LocalDateTime getBeginning() {
        return beginning;
    }
    public LocalDateTime getEnd() {
        return end;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public int[] getAgeChildren() {
        return ageChildren;
    }

    public int getAnimals() {
        return animals;
    }

    public void setBeginning(LocalDateTime beginning) {
        this.beginning = beginning;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setAgeChildren(int[] ageChildren) {
        this.ageChildren = ageChildren;
    }

    public void setAnimals(int animals) {
        this.animals = animals;
    }
    
    
}
