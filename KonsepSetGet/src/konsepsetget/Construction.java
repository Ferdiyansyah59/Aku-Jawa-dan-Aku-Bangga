/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsepsetget;

/**
 *
 * @author ferdiyansyah
 */
public class Construction {
    
  //Nyoba Construktor gan  
  

  private double sisi;
  
  //construktor
  public Construction()
  {
  
  }
  //construction 1 parameret
  public Construction(double s)
  {
      sisi = s;
  }
  public void setSisi(double s)
  {
      if(s<=0)
      {
          sisi=1;
      }
      else
      {
          sisi=s;
      }
  }
  public double hitLuas()
  {
      return (sisi*sisi);
  }
   
}
