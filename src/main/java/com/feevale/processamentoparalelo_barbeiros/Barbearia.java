package com.feevale.processamentoparalelo_barbeiros;

/**
 * Barbearia
 * 
 * @author Marina
 */
public class Barbearia {
    
    public static void main(String[] args) {
        
        ListaCadeiras cadeiras = new ListaCadeiras();
        Barbeiro b1 = new Barbeiro(cadeiras, "Joseilson");
        Barbeiro b2 = new Barbeiro(cadeiras, "Teilor");
        GeradorClientes clientes = new GeradorClientes(cadeiras, "ThreadClientes");
        
        b1.start();
        b2.start();
        clientes.start();
        
    }
    
}
