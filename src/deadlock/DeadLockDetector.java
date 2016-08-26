package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author Lars Mortensen
 */
/*Initially, this class could actually not detect the deadlock that arose from the two threads colliding.
This has been fixed by making it extend Thread instead of Runnable, and fixing the body of it. */
public class DeadLockDetector extends Thread {
    ThreadMXBean bean = ManagementFactory.getThreadMXBean();

    public void run() {
    while (true) {
        long[] threadIds = bean.findDeadlockedThreads();
            if(threadIds != null && threadIds.length > 0) {
                System.out.println("Deadlocked!");
                break;
            }
        }
    }
}
