/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Ana
 */
public class Autor implements GenerickiElement{
    
    
    private int idAutor;
    private String imeiPrezime;
    private String biografija;

    public Autor() {
    }

    public Autor(int idAutor, String imeiPrezime, String biografija) {
        this.idAutor = idAutor;
        this.imeiPrezime = imeiPrezime;
        this.biografija = biografija;
    }
    
    

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getImeiPrezime() {
        return imeiPrezime;
    }

    public void setImeiPrezime(String imeiPrezime) {
        this.imeiPrezime = imeiPrezime;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    @Override
    public String getImeTabele() {
        return "autor";
    }

    @Override
    public String getKoloneZaUbacivanje() {
        return "idAutor,imeIPrezime,biografija";
    }

    @Override
    public String getUbaceneVrednosti() {
        StringBuilder sb = new StringBuilder();
        sb.append(",").append("'").append(imeiPrezime).append("',")
                .append("'").append(biografija).append("'")
                ;
        return sb.toString();
        
    }

    @Override
    public void setId(int id) {
        idAutor=++id;
    }

    @Override
    public String vratiKoloneZaIzmenu() {
        return "imeiPrezime="+imeiPrezime+",biografija="+biografija+" WHERE idAutor="+idAutor;
    }

    @Override
    public String brisanje() {
        return "idAutor="+idAutor;
    }

    @Override
    public String max() {
return "idAutor";
        }

    @Override
    public List<GenerickiElement> vratilistuResultSet(ResultSet rs) throws SQLException {
      List<GenerickiElement> lista = new ArrayList<>();
        while(rs.next()){
           Autor a = new Autor(rs.getInt("idAutor"), rs.getString("imeIPrezime"), rs.getString("biografija"));
           lista.add(a);
        }
        rs.close();
        return lista;
    }

    @Override
    public String join(int i) {
        return "";
    }
    
    
    
}
