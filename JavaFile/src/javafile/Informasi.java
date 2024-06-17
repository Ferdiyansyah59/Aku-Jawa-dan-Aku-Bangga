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
public class Informasi {
    
    public static void main(String[] args) {
        File obj = new File(("Malam Pertama di Alam Kubur.docx"));
        
        if(obj.exists())
        {
            System.out.println("Nama File : " + obj.getName());
            System.out.println("Absolute Path : " + obj.getAbsolutePath());
            System.out.println("Apakah dapat diisi : " + obj.canWrite());
            System.out.println("Apakah bisa dibaca : " + obj.canRead());
            System.out.println("Ukuran File(dalam byte) : " + obj.length() + "byte");
        }
        else
        {
            System.out.println("File tidak ada");
        }
    }
}
