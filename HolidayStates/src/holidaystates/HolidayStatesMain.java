/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaystates;

import java.io.FileNotFoundException;

/**
 *
 * @author Ludo
 */
public class HolidayStatesMain {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        // TODO code application logic here      


        StayInfos si = new StayInfos();
        Menu.showKindOfVacation();
        si.createSubObject(Menu.selectionInMenuWithNumber(1,2));

    }
}
