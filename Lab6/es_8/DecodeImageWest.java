import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class DecodeImageWest {
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
          Color c = img.get(i,j);
          /* if blue is less than 16, make it 16 times,
          otherwise it is just noise */
          int blue = c.getBlue();
          if(blue < 16){
            blue *= 16;
          }else{
            blue = 0;
          }
        
          /* take the color and null red and green
          and the color blue changed */
          img.set(i,j, new Color(0, 0, blue));
        }
      }
      
      //Saving the modified image
      img.save(args[1]);
      System.out.println("Done...");
   }
}
