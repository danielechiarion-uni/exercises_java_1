public class Es4_recursiveSum{
  public static void main(String[] args){
    /* if the number of parameter
    is not one, return an error */
    if(args.length != 1){
      System.out.println("ERRORE! E' richiesto un parametro in input");
      return;
    }
    
    /* otherwise try to convert the only 
    parameter found and see if it is 
    a positive integer value */
    int number;
    try{
      number = Integer.parseInt(args[0]);
      if(number<=0){
        throw new Exception("ERRORE! E' richiesto un numero intero positivo.");
      }
    }catch(NumberFormatException e){
      System.out.println("ERRORE! Il parametro fornito non era un numero intero.");
      return;
    }catch(Exception e){
      System.out.println(e.toString());
      return;
    }
    
    /* invoke the function which provides
    the sum of the first numbers given by command line */
    int sum = recursiveSum(number);
    
    System.out.println("Il risultato della somma ricorsiva dei primi numeri e' "+sum);
  }
  
  private static int recursiveSum(int number){
    if(number == 1){
      return 1; // if the number is 1, return it because it is the last one
    }
    
    return number + recursiveSum(number-1); // otherwise sum the number to the lower ones
  }
}
