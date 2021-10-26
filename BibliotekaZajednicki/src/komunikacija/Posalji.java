/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Ana
 */
public class Posalji implements Serializable{
    private Socket socket;

    public Posalji(Socket socket) {
        this.socket = socket;
    }
    
    public void posalji(Object object) throws Exception{
        try {
            ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom slanja objekta !\n"+ex.getMessage());
        }
    }
}
