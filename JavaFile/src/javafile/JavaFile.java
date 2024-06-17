/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafile;

/**
 *
 * @author ferdiyansyah
 */
import java.io.File;
import java.io.IOException;
public class JavaFile {
 public void createFile()
    {
      
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         try{
           File obj = new  File("Malam Pertama di Alam Kubur.docx");
           
           if(obj.createNewFile())
           {
               System.out.println("Nama File : " + obj.getName());
           }
           else
           {
               System.out.println("File Ndak ada");
           }
       }
       catch(Exception ex)
       {
           System.out.println("Error");
           System.out.println(ex);
       }
    }
    
}
