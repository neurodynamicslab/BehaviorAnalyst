/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behavioranalyst;

import static javax.swing.SwingUtilities.isEventDispatchThread;

/**
 *
 * @author Balaji
 */
public class BehaviorAnalyst {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         java.awt.EventQueue.invokeLater(() -> {
             new FrontEnd_MainFrame().setVisible(true);
         });
         if(isEventDispatchThread()){
             System.out.print("It is an event dispatch thread");
         }
         else{
               System.out.print("It is not an event dispatch thread");      
                     }
         
    }
    
}
