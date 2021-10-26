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
public class Knjiga implements GenerickiElement{
    private int idKnjiga;
    private String ime;
    private String opis;
    private Date datumIzdavanja;

    public Knjiga() {
    }

    public Knjiga(int idKnjiga, String ime, String opis, Date datumIzdavanja) {
        this.idKnjiga = idKnjiga;
        this.ime = ime;
        this.opis = opis;
        this.datumIzdavanja = datumIzdavanja;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public int getIdKnjiga() {
        return idKnjiga;
    }

    public void setIdKnjiga(int idKnjiga) {
        this.idKnjiga = idKnjiga;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String getImeTabele() {
        return "knjiga";
    }

    @Override
    public String getKoloneZaUbacivanje() {
        return "idKnjiga,ime,opis,datumIzdavanja";
    }

    @Override
    public String getUbaceneVrednosti() {
        StringBuilder sb = new StringBuilder();
        sb.append(",'").append(ime).append("',")
                .append("'").append(opis).append("',").append("'").append(datumIzdavanja).append("'")

                ;
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        idKnjiga=id;
    }

    @Override
    public String vratiKoloneZaIzmenu() {
        return "ime= '"+ime+"' , opis= '"+opis+"', datumIzdavanja= '"+datumIzdavanja+"' WHERE idKnjiga=" +idKnjiga;
    }

    @Override
    public String brisanje() {
        return "idKnjiga="+idKnjiga;
    }

    @Override
    public String max() {
        return "idKnjiga";
    }

    @Override
    public List<GenerickiElement> vratilistuResultSet(ResultSet rs) throws SQLException {
        List<GenerickiElement> lista = new ArrayList<>();
        while(rs.next()){
         int id = rs.getInt("idKnjiga");
         String ime = rs.getString("ime");
         String opis = rs.getString("opis");
         Date datum = new Date(rs.getDate("datumIzdavanja").getTime());
         
         Knjiga k = new Knjiga(id, ime, opis, datum);
         lista.add(k);
        }
        rs.close();
        return lista;

    }

    @Override
    public String join(int i) {
        return "";
    }

    @Override
    public String toString() {
        return "Knjiga{" + "idKnjiga=" + idKnjiga + ", ime=" + ime + ", opis=" + opis + ", datumIzdavanja=" + datumIzdavanja + '}';
    }
    
    
    
}
