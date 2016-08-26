package textwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Joachim E. Christensen
 */
public class BackupThread extends Thread {
    private List<String> myCopy;
    private int prevlines = 0;
   
    BackupThread(List l) {
        myCopy = l;
    }
   
    @Override
    public void run() {
        //This entire function prints the contents of the List into a file, specifically in my Documents folder.
        while(true) {
            if(myCopy.size() > prevlines) {
                try(FileWriter writer = new FileWriter("backup.txt", false)) {
                    for(int i = 0; i != myCopy.size(); i++) {
                        writer.write(myCopy.get(i) + System.getProperty("line.separator"));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(BackupThread.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                System.out.println("Saving~");
                prevlines = myCopy.size();
            }
            try {
                Thread.sleep(15000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BackupThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
