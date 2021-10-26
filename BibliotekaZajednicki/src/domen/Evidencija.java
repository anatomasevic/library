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
public class Evidencija implements GenerickiElement{
    private int idEvidencija;
    private Date datumKreiranja;
    private Date datumVracanja;
    private Knjiga knjiga;
    private Korisnik korisnik;
    int vracena =1;

    public Evidencija() {
    }

    public Evidencija(int idEvidencija, Date datumKreiranja, Date datumVracanja, Knjiga knjiga, Korisnik korisnik) {
        this.idEvidencija = idEvidencija;
        this.datumKreiranja = datumKreiranja;
        this.datumVracanja = datumVracanja;
        this.knjiga = knjiga;
        this.korisnik = korisnik;
    }

    public void setDatumVracanja(Date datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    public Date getDatumVracanja() {
        return datumVracanja;
    }

   

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public int getIdEvidencija() {
        return idEvidencija;
    }

    public void setIdEvidencija(int idEvidencija) {
        this.idEvidencija = idEvidencija;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String getImeTabele() {
        return "evidencija";
    }

    @Override
    public String getKoloneZaUbacivanje() {
        return "idEvidencija,datumKreiranja,idKnjiga,idKorisnik";
    }

    @Override
    public String getUbaceneVrednosti() {
      StringBuilder sb = new StringBuilder();
        sb.append(",'").append(datumKreiranja).append("',")
                .append("'").append(knjiga.getIdKnjiga()).append("',").append("'").append(korisnik.getIdKorisnik()).append("'")
                ;
        return sb.toString();    }

    @Override
    public void setId(int id) {
        idEvidencija=id;
    }

    @Override
    public String vratiKoloneZaIzmenu() {
        return "datumKreiranja="+datumKreiranja+"datumVracanja="+datumVracanja+"WHERE idEvidencija="+idEvidencija;
    }

    @Override
    public String brisanje() {
        return "idEvidencija="+idEvidencija;
    }

    @Override
    public String max() {
return "idEvidencija";
    }

    @Override
    public List<GenerickiElement> vratilistuResultSet(ResultSet rs) throws SQLException {
        List<GenerickiElement> evidencije = new ArrayList<>();
        while(rs.next()){
           knjiga = new Knjiga(rs.getInt("idKnjiga"), rs.getString("ime"), rs.getString("opis"), new Date(rs.getDate("datumIzdavanja").getTime()));
           korisnik = new Korisnik(rs.getInt("idKorisnik"), rs.getString("korisnickoime"), new Date(rs.getDate("datumRodjenja").getTime()), rs.getString("pol"));
          Evidencija ev=new Evidencija();
          
             int vracena = rs.getInt("vracena");
            
           if(vracena==0){
             ev = new Evidencija(rs.getInt("idEvidencija"), new Date(rs.getDate("datumKreiranja").getTime()),null, knjiga, korisnik);

           }else{
           
       ev = new Evidencija(rs.getInt("idEvidencija"), new Date(rs.getDate("datumKreiranja").getTime()),new Date(rs.getDate("datumVracanja").getTime()), knjiga, korisnik);
           }
           evidencije.add(ev);
                   }
        rs.close();
        return evidencije;
    }

    @Override
    public String join(int i) {
        return " e JOIN knjiga k ON e.idKnjiga=k.idKnjiga JOIN Korisnik ko ON e.idKorisnik=ko.idKorisnik WHERE e.vracena= "+i;
    }

    @Override
    public String toString() {
        return "Evidencija{" + "idEvidencija=" + idEvidencija + ", datumKreiranja=" + datumKreiranja + ", datumVracanja=" + datumVracanja + ", knjiga=" + knjiga + ", korisnik=" + korisnik + ", vracena=" + vracena + '}';
    }

   
    
    
    
}
