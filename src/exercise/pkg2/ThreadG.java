
package exercise.pkg2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Joachim E. Christensen
 */
public class ThreadG extends Thread{
    private String thisurl;
    public ThreadG(String url) throws IOException {
        setUrl(url);
        byte[] bytes = getBytesFromUrl(url);
        System.out.println(getSum());
    }
    
    
    public void setUrl(String url){
        thisurl = url;
    }
    
    public String getUrl() {
        return thisurl;
    }
    
    public long getSum () throws IOException {
        
        byte[] bytes = getBytesFromUrl(getUrl());
        long sum = 0;
        for (byte b : bytes) {
            sum = sum + b & 0xFFFF;
        }
        return sum;
    }
    
    public static byte[] getBytesFromUrl(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.connect();
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = connection.getInputStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return bis.toByteArray();
    }
}
