/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.viswa.cafemenuproj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Viswa_workshop
 */
public class CafeMenu {
    
    private String itemSelected = null;
    private final double cola = 0.50;
    private final double coffee = 1.00;
    private final double cheeseSandwich = 2.00;
    private final double steakSandwich = 4.50;
    private Map<String,Double> map=new HashMap<>();
    
    private void setSelectedMenu(){
        this.map.put("Cola", new Double(cola));
        this.map.put("Coffee", new Double(coffee));
        this.map.put("Cheese Sandwich", new Double(cheeseSandwich));
        this.map.put("Steak Sandwich", new Double(steakSandwich));
    }
    
    private double getSelectedMenu(String key ){
       return  this.map.get(key);
    }
    
    public void displayMenu(){
        System.out.println("***Welcome to Cafe*****");
        System.out.println("**Select your Items form the List**");
        System.out.println("A) Cola   - Cold - £0.50P");
        System.out.println("B) Coffee - Hot -  £1.00P");
        System.out.println("C) Cheese Sandwich - Cold - £2.00P");
        System.out.println("D) Steak Sandwich  - Hot  - £4.50P");
        System.out.println("Q) Quit");
    }
    
    public String selectMenuItem(char item){
        itemSelected = "";
       switch(item) {
         case 'A' :
            System.out.println("Great!! You have selected!! Cola - Cold - £0.50P");
            itemSelected = "Cola";
            break;
         case 'B' :
            System.out.println("Excellent!! You have selected!! Coffee - Hot - £1.00P");
            itemSelected =  "Coffee";
            break;
         case 'C' :
            System.out.println("Awesome!! You have selected!! Cheese Sandwich - Cold - £2.00P");
            itemSelected =  "Cheese Sandwich";
            break;
         case 'D' :
            System.out.println("Awesome!! You have selected!! Steak Sandwich- Hot - £4.50P");
            itemSelected =  "Steak Sandwich";
             break;
        case 'Q' :
            System.out.println("Quit !! Good Byeee");
             break;             
         default :
            System.out.println("Invalid Selection!! Please select item from Menu!!");
             
             
      }
       return itemSelected;
    }
    
    public HashMap processMenu(Scanner scanner){
        this.setSelectedMenu();
        HashMap<String,Double> map1 =new HashMap<>();
        try{
            while (true) {
                System.out.print("Enter your selection : ");
                String value = scanner.nextLine();
                char input = value.charAt(0);
                String itemSelection = this.selectMenuItem(input);
                if (!"".equals(itemSelection)){
                   map1.put(itemSelection, this.getSelectedMenu(itemSelection));
                }
                if ( value.equalsIgnoreCase("Q") || "".equals(value)) {
                  System.out.println("Items selected are : "+ map1.keySet());
                      break;
                }
             }
        }catch (StringIndexOutOfBoundsException exp){
            System.out.println("Invalid Selection!!! ");
            System.out.println("*************************** ");
            System.out.println("\n\n\n\n\n");
            exp.printStackTrace();
            
        } catch (Exception exp1){
            System.out.println("opps Something wrong !!!  ");
        }finally {
            scanner.close();
        }
        
        return map1;
    }

    public double standardBill(HashMap<String,Double> val){
        // calculation
        double totalVal = 0.0;
        for (String key : val.keySet()){
            totalVal+= val.get(key);
        }
        System.out.println("Standard Bill : £"+ totalVal+"P");
        
        return totalVal;
    }
    
    public double serviceCharge(double total, HashMap<String,Double> val ){
        double totalBillWithoutScharge = total;
        double grandTotal= total;
      //no service charge for drinks  
      if (val.containsValue(cheeseSandwich)){
         double coldFoodItemsCount = (totalBillWithoutScharge*0.1);
         grandTotal = (coldFoodItemsCount + totalBillWithoutScharge);
      }
      if (val.containsValue(steakSandwich)){
          double hotFoodItemsCount = (totalBillWithoutScharge*0.2);
          if (hotFoodItemsCount <= 20.0)
           grandTotal = (hotFoodItemsCount + totalBillWithoutScharge);
          else 
           grandTotal = (20.0 + totalBillWithoutScharge); 
      } 
        return grandTotal;
    }
    
    public static void main(String[] args) {
     CafeMenu menu = new CafeMenu();
     Scanner scanner = new Scanner(System.in);
     HashMap map = menu.processMenu(scanner);   
     System.out.println("Map contains: "+ map.toString());   
    }
}
