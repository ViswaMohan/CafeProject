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
   public void processMenuItemTest() {
       CafeMenu menu = new CafeMenu();
       Scanner scanner = new Scanner("A");
       HashMap map = menu.processMenu(scanner);
       Assert.assertNotNull(map);
       System.out.println("selectedItem : "+ map.keySet());
   }    
   
   @Test
   public void standardBillTest() {
       CafeMenu menu = new CafeMenu();
       Scanner scanner = new Scanner("D");
       HashMap map = menu.processMenu(scanner);
       double total = menu.standardBill(map);
       Assert.assertEquals(0.50, 0.50, 0.50);
       System.out.println("total : "+ total);
   }
}