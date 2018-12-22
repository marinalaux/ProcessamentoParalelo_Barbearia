package com.feevale.processamentoparalelo_barbeiros;

import java.time.LocalDateTime;

/**
 * Gerador de clientes da barbearia
 * 
 * @author Marina
 */
public class GeradorClientes extends Thread {
    
    /** Cadeiras da barbearia */
    private ListaCadeiras cadeiras;
    
    public GeradorClientes(ListaCadeiras cadeiras, String nome) {
        super(nome);
        this.cadeiras = cadeiras;
    }
    
    public void geraClientes() {
        int qtdNovosClientes = (int)(Math.random() * 6);
        for (int i = 0; i <= qtdNovosClientes; i++) {
            synchronized (cadeiras) {
                if (cadeiras.temCadeiraVaga()) {
                    cadeiras.alocaCadeira();
                    cadeiras.notifyAll();
                    System.out.println("[" + LocalDateTime.now() + "]" + " Um novo cliente chegou na barbearia. Existem " + cadeiras.qtdCadeirasOcupadas() + " clientes esperando.");
                } else {
                    System.out.println("[" + LocalDateTime.now() + "]" + " Um novo cliente chegou, a barbearia já estava lotada e foi embora.");
                }
            }
        }
    }
    
    public void run() {
        while(true) {
            this.geraClientes();
            try {
                Thread.sleep((int)(Math.random() * 500));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
