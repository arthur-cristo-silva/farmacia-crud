package org.farmacia.entities;

import java.time.LocalDate;
import java.util.ArrayList;

// aqui é a classe de remedio no qual se criara o objeto
public class Remedio {
    private ArrayList<Substancia> substancias;
    private String nome_remedio;
    private LocalDate data_vencimento;
    private int quantidade;
    private float concentracao;
    private Uso uso;

    public Remedio(ArrayList<Substancia> substancias, String nome_remedio, LocalDate data_vencimento, int quantidade, float concentracao, Uso uso) {
        this.substancias = substancias;
        this.nome_remedio = nome_remedio;
        this.data_vencimento = data_vencimento;
        this.quantidade = quantidade;
        this.concentracao = concentracao;
        this.uso = uso;
    }
}

