package com.feevale.processamentoparalelo_barbeiros;

import java.util.LinkedList;
import java.util.List;

/**
 * Cadeiras disponibilizadas para os clientes sentarem
 * 
 * @author Marina
 */
public class ListaCadeiras {
    
    /** Quantidade de lugares disponíveis para os clientes sentarem */
    private static final int QTD_LUGARES = 8;
    /** Cadeiras da barbearia */
    private List<Boolean> cadeiras = new LinkedList<Boolean>();
    
    public ListaCadeiras() {
        cadeiras.clear();
    }
    
    /**
     * Verifica se há cliente para atender
     * 
     * @return Tem cliente para atender
     */
    public boolean temCliente() {
        return !cadeiras.isEmpty();
    }
    
    /**
     * Verifica se há cadeira vaga para um novo cliente
     * 
     * @return Tem cadeira vaga
     */
    public boolean temCadeiraVaga() {
        return qtdCadeirasOcupadas() < QTD_LUGARES;
    }
    
    public int qtdCadeirasOcupadas() {
        return cadeiras.size();
    }
    
    public void alocaCadeira() {
        cadeiras.add(true);
    }
    
    public void atendeCliente() {
        cadeiras.remove(0);
    }
    
}
