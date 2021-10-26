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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ana
 */
public class Spisak implements GenerickiElement{
    private int kolicina;
    private Autor autor;
    private Knjiga knjiga;

    public Spisak() {
    }

    public Spisak(int kolicina, Autor autor, Knjiga knjiga) {
        this.kolicina = kolicina;
        this.autor = autor;
        this.knjiga = knjiga;
    }

    

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

   

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String getImeTabele() {
        return "spisak";
    }

    @Override
    public String getKoloneZaUbacivanje() {
        return "idAutor,idKnjiga,kolicina";
    }

    @Override
    public String getUbaceneVrednosti() {
 StringBuilder sb = new StringBuilder();
        sb.append(autor.getIdAutor()).append(",").append("'").append(knjiga.getIdKnjiga()).append("',")
                .append("'").append(kolicina).append("'")

                ;
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKoloneZaIzmenu() {
return "kolicina="+kolicina+" WHERE idKnjiga="+knjiga.getIdKnjiga()+" AND idAutor="+autor.getIdAutor();
    }

    @Override
    public String brisanje() {
        return "idAutor="+autor.getIdAutor()+" AND idKnjiga="+knjiga.getIdKnjiga();
    }

    @Override
    public String max() {
return "";
    }

    @Override
    public List<GenerickiElement> vratilistuResultSet(ResultSet rs) throws SQLException {
        List<GenerickiElement> lista = new ArrayList<>();
        while(rs.next()){
            autor = new Autor(rs.getInt("idAutor"), rs.getString("imeIPrezime"), rs.getString("biografija"));
           knjiga = new Knjiga(rs.getInt("idKnjiga"), rs.getString("ime"), rs.getString("opis"), new Date(rs.getDate("datumIzdavanja").getTime()));
            Spisak s = new Spisak(rs.getInt("kolicina"), autor, knjiga);
            lista.add(s);
        }
        rs.close();
        return lista;
    }

    @Override
    public String join(int i) {
        return " s JOIN knjiga k ON s.idKnjiga=k.idKnjiga JOIN autor a ON s.idAutor=a.idAutor";
    }

    @Override
    public String toString() {
        return "Spisak{" + "kolicina=" + kolicina + ", autor=" + autor + ", knjiga=" + knjiga + '}';
    }
    
    
    
    
}
