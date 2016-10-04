package javacesi;

import java.io.*;

/**
 * Created by chris on 04/10/2016.
 */
public class ParseChris {


            public ParseChris()
            {
                File file = new File("assets/banque.txt");
                //System.out.println(file.getAbsolutePath());
                BufferedReader reader;

                try
                {
                    reader = new BufferedReader(new FileReader(file));
                    String text = null;

                    while((text = reader.readLine()) != null)
                    {
                        System.out.println(text);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



}
