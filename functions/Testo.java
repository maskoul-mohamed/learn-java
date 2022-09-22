package functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Testo {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Moe/Desktop/work space/learn-java/functions/past.txt"));
            FileWriter past = new FileWriter("C:/Users/Moe/Desktop/work space/learn-java/functions/past.txt");

            String line = br.readLine();
            int num = 0;
            System.out.print(line);

            while(line != null){
                System.out.print(line);
               past.write(++num + " " + line + "."); 
            }
            past.close();
            br.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
