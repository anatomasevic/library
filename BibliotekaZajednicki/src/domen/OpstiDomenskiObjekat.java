/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ana
 */
public interface OpstiDomenskiObjekat extends Serializable{
    public String vratiNazivTabele();
    public String vratiNazivJoinTabele();
    public List<OpstiDomenskiObjekat> vratiListuSvih();
    public String vratiVrednostZaInsert();
    public String vratiVrednostZaUpdate();
    public String vratiUslovZaSelect(String s);
    public String vratiUslovZaUpdate();
    
}
