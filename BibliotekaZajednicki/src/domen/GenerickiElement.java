/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ana
 */
public interface GenerickiElement extends Serializable{
    String getImeTabele();
    String getKoloneZaUbacivanje();
    String getUbaceneVrednosti();
   
    List<GenerickiElement> vratilistuResultSet(ResultSet rs)throws SQLException;
    void setId(int id);
    String max();
    String vratiKoloneZaIzmenu();
    String brisanje();
     String join(int i);
    
}
