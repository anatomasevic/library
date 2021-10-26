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
public class Korisnik implements GenerickiElement{
    private int idKorisnik;
    private String korisnickoIme;
    private Date datumRodjenja;
    private String pol;

    public Korisnik() {
    }

    public Korisnik(int idKorisnik, String korisnickoIme, Date datumRodjenja, String pol) {
        this.idKorisnik = idKorisnik;
        this.korisnickoIme = korisnickoIme;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

   

   
    public int getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String getImeTabele() {
        return "korisnik";
    }

    @Override
    public String getKoloneZaUbacivanje() {
        return "idKorisnik,korisnickoime,datumRodjenja,pol";
    }

    @Override
    public String getUbaceneVrednosti() {
 StringBuilder sb = new StringBuilder();
        sb.append(",").append("'").append(korisnickoIme).append("',")
                .append("'").append(datumRodjenja).append("',").append("'").append(pol).append("'")

                ;
        return sb.toString();    }

    @Override
    public void setId(int id) {
        idKorisnik=id;
    }

    @Override
    public String vratiKoloneZaIzmenu() {
        return "korisnickoime="+korisnickoIme+",datumRodjenja="+datumRodjenja+", pol="+pol+" WHERE idKorisnik="+idKorisnik;
    }

    @Override
    public String brisanje() {
        return "idKorisnik="+idKorisnik;
    }

    @Override
    public String max() {
        return "idKorisnik";
    }

    @Override
    public List<GenerickiElement> vratilistuResultSet(ResultSet rs) throws SQLException {
        List<GenerickiElement> lista = new ArrayList<>();
        while(rs.next()){
            Korisnik k = new Korisnik(rs.getInt("idKorisnik"), rs.getString("korisnickoime"), new Date(rs.getDate("datumRodjenja").getTime()), rs.getString("pol"));
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
        return "Korisnik{" + "idKorisnik=" + idKorisnik + ", korisnickoIme=" + korisnickoIme + ", datumRodjenja=" + datumRodjenja + ", pol=" + pol + '}';
    }
    
    
}
