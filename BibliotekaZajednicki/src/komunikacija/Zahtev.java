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
public class Zahtev implements Serializable{
    private Operacije operacija;
    private Object parametar;

    public Zahtev() {
    }

    public Zahtev(Operacije operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public Operacije getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacije operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }
    
    
}
