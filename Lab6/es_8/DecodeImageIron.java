import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/* Usare costruttore e metodi della classe SimpleImage
   (fate riferimento alla classe per la descrizione):

public SimpleImage(String filename)
public int height() 
public int width() 
public Color get(int i, int j) 
public void set(int i, int j, Color c)

e i metodi della classe color
public int getRed()
public int getGreen()
public int getBlue()
e il costruttore Color(int r, int g, int b)

*/

public class DecodeImageIron {
   public static void main(String args[])throws IOException {
      
      if (args.length != 2){
         System.out.println("Usage: java DecodeImage inputFileName outputFileName");
         System.exit(0);
      }
      
      //Creo oggetto SimpleImage con l'immagine di input
      SimpleImage img = new SimpleImage(args[0]);
      
      
      // ricordarsi che le immagini sono griglie di pixel
      // l'asse x e' la larghezza
      // l'asse y l'altezza
      // (0,0) e' l'angolo in alto a sinistra
      int height = img.height();
      int width = img.width();
      for(int i=0; i<width; i++){
        for(int j=0; j<height; j++){
          /* take the color and null green and blue
          and increase red 10 times */
          Color c = img.get(i,j);
          img.set(i,j, new Color(c.getRed()*10, 0, 0));
        }
      }
      
      //Saving the modified image
      img.save(args[1]);
      System.out.println("Done...");
   }
}
