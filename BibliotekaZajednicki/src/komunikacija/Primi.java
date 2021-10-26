/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Ana
 */
public class Primi implements Serializable{
    private Socket socket;

    public Primi(Socket socket) {
        this.socket = socket;
    }
    
    public Object primi() throws Exception{
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom primanja objekta!\n"+ex.getMessage());
        }
    }
}
