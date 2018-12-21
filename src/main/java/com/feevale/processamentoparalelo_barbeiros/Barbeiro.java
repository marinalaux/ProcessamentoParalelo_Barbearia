package com.feevale.processamentoparalelo_barbeiros;

import java.time.LocalDateTime;

/**
 * Barbeiro
 * 
 * @author Marina
 */
public class Barbeiro extends Thread {
    
    /** Cadeiras da barbearia */
    private ListaCadeiras cadeiras;
    
    public Barbeiro(ListaCadeiras cadeiras, String nome) {
        super(nome);
        this.cadeiras = cadeiras;
    }
    
    public void atender() {
        synchronized (cadeiras) {
            if (cadeiras.temCliente()) {
                cadeiras.atendeCliente();
                System.out.println("[" + LocalDateTime.now() + "]" + " Barbeiro " + this.getName() + " está atendendo um cliente. Ainda restam " + cadeiras.qtdCadeirasOcupadas() + " clientes esperando.");
            } else {
                System.out.println("[" + LocalDateTime.now() + "]" + " Barbeiro " + this.getName() + " dormiu.");
                try {
                    cadeiras.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void run() {
        while(true) {
            this.atender();
            try {
                Thread.sleep((int)Math.random() * 200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
