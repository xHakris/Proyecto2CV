
package models;

import java.util.Date;

public class Reloj {
    private static Reloj instancia;
    
    private Reloj(){
        
    }
    
    public static Reloj getInstancia(){
        if (instancia == null) {
            instancia = new Reloj();
        }
        return instancia;
    }
    
    public Runnable getHora() {
        Runnable contador = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Date hora = new Date(System.currentTimeMillis());
                        Thread.sleep(1000);
                        System.out.println("Son las: " + hora.getHours() + "h " + hora.getMinutes() + "m " + hora.getSeconds() + "s");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        return contador;
    }
}
