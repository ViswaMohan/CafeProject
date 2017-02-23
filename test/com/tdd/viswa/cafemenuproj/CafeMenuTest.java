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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}