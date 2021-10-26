/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Ana
 */
public class Odgovor implements Serializable{
    private Operacije operacija;
    private Object odgovor;

    public Odgovor() {
    }

    public Odgovor(Operacije operacija, Object odgovor) {
        this.operacija = operacija;
        this.odgovor = odgovor;
    }

    public Operacije getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacije operacija) {
        this.operacija = operacija;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }
    
    
}
