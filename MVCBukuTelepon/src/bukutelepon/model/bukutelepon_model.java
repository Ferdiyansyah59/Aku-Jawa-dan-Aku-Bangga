/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bukutelepon.model;

/**
 *
 * @author ferdiyansyah
 */
public class bukutelepon_model {
    private Integer id;
    private String nope;
    private String nama;
    private String alamat;
    
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getNope(){
        return nope;
    }
    public void setNope(String nope){
        this.nope = nope;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getAlamat(){
        return alamat;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    
}
