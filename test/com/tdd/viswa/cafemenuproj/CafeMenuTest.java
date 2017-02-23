package com.tdd.viswa.cafemenuproj;

import java.util.HashMap;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Viswa_workshop
 */
public class CafeMenuTest {
    
    public CafeMenuTest() {
    }
    
    @Test
    public void displayMenuTest() {
       CafeMenu menu = new CafeMenu();
       menu.displayMenu();
   }
    
   @Test
   public void selectMenuItemTest() {
       CafeMenu menu = new CafeMenu();
       String selectedItem = menu.selectMenuItem('A');
       assertSame(selectedItem,"Cola");
       System.out.println("selectedItem : "+ selectedItem);
   }
     
   @Test
   public void standardBillTest() {
       CafeMenu menu = new CafeMenu();
       Scanner scanner = new Scanner("A");
       HashMap map = menu.processMenu(scanner);
       double total = menu.standardBill(map);
       Assert.assertEquals(0.50, 0.50, 0.50);
       System.out.println("total : "+ total);
   }
   
   @Test
   public void serviceChargeTest() {
       CafeMenu menu = new CafeMenu();
       Scanner scanner = new Scanner("C");
       HashMap map = menu.processMenu(scanner);
       double total = 2.0;
       double grandtotal = menu.serviceCharge(total, map);
       Assert.assertEquals(2.2, 2.2, 2.2);
       System.out.println("total : "+ grandtotal);
   }
}