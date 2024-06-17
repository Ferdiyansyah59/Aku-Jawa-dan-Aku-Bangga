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
public class CekFile {
    public static void main(String[] args) {
        try
        {
            File obj = new File("Malam Pertama di Alam Kubur.docx");
            
            if(obj.exists())
            {
                System.out.println("File sudah ada");
                System.out.println(obj.getName());
            }
            else
            {
                System.out.println("File tidak ada");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error");
            System.out.println(ex);
        }
    }
}
