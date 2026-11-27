public class IntArrayList{
  /* define static constants for the 
  creation of the array */
  private static final int INITIAL_SIZE = 10;
  
  /* define private attributes for the instance */
  private int[] v;
  private int vSize;
  
  /* define constructor assigning 
  default size to the array */  
  public IntArrayList(){
    this.v = new int[INITIAL_SIZE];
    this.vSize = 0;
  }
  
  /* resize the array using a x2 factor */
  public void resize(){
    int[] newV = new int[this.v.length*2];
    System.arraycopy(this.v, 0, newV, 0, this.v.length);
    v = newV; // assign the reference of the new array to the old one, to increase its size
  }
  
  /* function to get the element 
  at the specified index */
  public int get(int index) throws IllegalArgumentException{
    if(index >= 0 && index < this.vSize){
      return this.v[index];
    }
    throw new IllegalArgumentException("Indice nel metodo get() non valido");
  }
  
  /* method to return the actual size
  of the array */
  public int size(){
    return this.vSize; // just return the attribute
  }
  
  /* function to add a new element adjusting 
  the size automatically */
  public void add(int element){
    this.add(this.vSize, element); // call the method using as a position the last one
  }
  
  /* function returning a flag 
  if the element is inside the array */
  public boolean contains(int element){
    /* it is necessary to cycle just
    among the actually occupied places of the array */
    for(int i=0; i<this.vSize;i++){
      if(this.v[i] == element){
        return true;
      }
    }
    
    return false;
  }
  
  /* returns the list in a
  recognizable format */
  @Override
  public String toString(){
    String output = "[";
    for(int i=0;i<this.vSize;i++){
      output += this.v[i];
      if(i != this.vSize-1){
        output += ",";
      }
    }
    output += "]";
    return output;
  }
  
  /* function to add an element in a specific position */
  public void add(int position, int element) throws IllegalArgumentException{
    /* first control if the index is valid */
    if(position < 0 || position > this.vSize)
      throw new IllegalArgumentException("Posizione fornita nel metodo add() non valida");
    
    /* if the array is full
    resize it */
    if(this.vSize == this.v.length){
      this.resize();
    }
    
    /* then move the numbers from the 
    position selected to the end one place to the right */
    for(int i=this.vSize-1;i>=position;i--){
      this.v[i+1] = this.v[i];
    }
    
    /* then add the element in the position selected */
    this.v[position] = element;
    this.vSize++;
  }
  
  /* function to remove the element 
  in a specified position */
  public void remove(int position) throws IllegalArgumentException{
    /* first control if the index is valid */
    if(position < 0 || position > this.vSize)
      throw new IllegalArgumentException("Posizione fornita nel metodo remove() non valida");
    
    /* find all the element to the right of the number 
    and move it one place to the left */
    for(int i=position+1; i<this.vSize;i++){
      this.v[i-1] = this.v[i];
    }
    
    /* it remains one more value to be 
    eliminated. But, in this case, it is necessary 
    just to reduce the actual size of the array */
    this.vSize--;
  }
}
