package com.tdd.viswa.cafemenuproj;

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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}