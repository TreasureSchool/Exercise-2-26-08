package exercise.pkg2;

import java.io.IOException;

/**
 * @author Joachim E. Christensen
 */
public class Exercise2 extends Thread{
    public static void main(String[] args) throws IOException {
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        ThreadG g1 = new ThreadG("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
        ThreadG g2 = new ThreadG("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
        ThreadG g3 = new ThreadG("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
        long start = System.nanoTime();
        g1.start();
        g2.start();
        g3.start();
        //Runtime: 262820
        //long totalSum = g1.getSum() + g2.getSum() + g3.getSum();
        //System.out.println(totalSum);
        
        /*g1.run();
        g2.run();
        g3.run();*/
        //Runtime: 11155
        long end = System.nanoTime();
        System.out.println("Sequential time = " + (end - start));
        /* Baseret på løbetiden af de to metoder, forstår jeg at det er internt hurtigere hvis man bruger Run istedet for start,
        da det gør at Threadsene kører en efter hinanden, og gør at de ikke skal kæmpe om at bruge funktionerne.*/
    }
}
