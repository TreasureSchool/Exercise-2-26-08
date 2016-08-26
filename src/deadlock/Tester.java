package deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Tester {
  public static void main(String[] args) {
    try {
      DeadLockDetector DiD = new DeadLockDetector();
      ResourceContainer resources = new ResourceContainer();
      ResourceUser1 t1 = new ResourceUser1(resources);
      ResourceUser2 t2 = new ResourceUser2(resources);
      t1.start();
      t2.start();
      
      DiD.start();
      
      t1.join();
      t2.join();
      
      System.out.println("Done");
      System.out.println("Words produced: "+resources.getResourceWords().size());
      System.out.println("Numbers produced: "+resources.getResourceNumbers().size());
      //The problem that originally arose was that the two threads were contradicting one another.
      //One would access Words, and other would access Numbers. and as they tried to access the other one, they'd clash.
      //So by reversing one of them so they both try to access numbers or words at the same time, it evens out and undoes the deadlock.
    } catch (InterruptedException ex) {
      Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
