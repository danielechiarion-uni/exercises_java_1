import java.util.Scanner;

public class ProvaPersonaggio{
  public static void main() {
    /* instantiate the scanner */
    Scanner scanner = new Scanner(System.in);
    
    /* ask the first values in input
    to create the two characters */
    System.out.println("Inserisci il nome dell'eroe: ");
    String heroName = scanner.nextLine();
    System.out.println("Inserisci il nome del mostro: ");
    String monsterName = scanner.nextLine();
    
    int life, damage; 
    do{
     System.out.println("Inserisci la vita del mostro: ");
     life = scanner.nextInt();
    }while(life <= 0);
    do{
      System.out.println("Inserisci il danno del mostro: ");
      damage = scanner.nextInt();
    }while(damage <= 0);
    /* close the scanner at the end */
    scanner.close();
    
    /* instantiate the two objects */
    Personaggio hero = new Personaggio(heroName);
    Personaggio monster = new Personaggio(monsterName, life, damage);
    
    /* create variables for the game */
    boolean potion = false;
    int turnCounter = 0;
    final int POTIONPOINTS = 20;
    
    while(hero.isVivo() && monster.isVivo()){
      potion = characterTurn(hero, monster, turnCounter, POTIONPOINTS, potion);
      turnCounter++;
    }
    
    /* understand wheter the monster or the hero
    is dead and print the result */
    if(!monster.isVivo()){
      hero.salitaDiLivello();
    }else{
      System.out.println("RIP eroe "+hero.getNome()+"! Ritenta la prossima volta!");
    }
  }
  
  /* function used to make every single turn 
  of the game */
  private static boolean characterTurn(Personaggio hero, Personaggio monster, int turnCounter, int potionPoints, boolean potionUsed){
    System.out.println("Turno numero: "+(turnCounter+1));
    
    /* see if the hero life is less than 40
    in order to use the potion */
    if(hero.getPuntiVita() < 40 && !potionUsed){
      hero.cura(potionPoints);
      potionUsed = true;
    }
    
    /* then understand whose the turn is 
    and attack the other */
    if(turnCounter % 2 == 0){
      System.out.println("EROE "+ hero.getNome() +" ALL'ATTACCO!");
      hero.attacca(monster);
    }else{
      System.out.println("MOSTRO "+ monster.getNome() +" ALL'ATTACCO!");
      monster.attacca(hero);
    }
    
    /* print the status of the monster */
    System.out.println("Status mostro: "+monster.toString());
    System.out.println("Status eroe: "+hero.toString()+"\n");
    
    return potionUsed;
  }
}
