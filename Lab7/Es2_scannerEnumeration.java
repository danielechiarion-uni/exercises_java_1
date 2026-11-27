import java.util.Scanner;

public class Es2_scannerEnumeration{
  public static void main(){
    /* create the scanner to read the first string */
    Scanner console = new Scanner(System.in);
    System.out.println("Inserisci una stringa in input: ");
    String inputString = console.nextLine();
    console.close();
    
    /* then read the string and 
    print all the words given using another scanner */
    Scanner scanline = new Scanner(inputString);
    System.out.println("PAROLE INSERITE: ");
    while(scanline.hasNext()){
      System.out.println("- "+scanline.next());
    }
    scanline.close();
  }
}
