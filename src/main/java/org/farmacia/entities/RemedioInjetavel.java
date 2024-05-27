package org.farmacia.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class RemedioInjetavel extends Remedio {
    private String dosagem;
    private String descricao;

    public RemedioInjetavel(ArrayList<Substancia> substancias, String nome_remedio, LocalDate data_vencimento, int quantidade, float concentracao, Uso uso, String dosagem, String descricao) {
        super(substancias, nome_remedio, data_vencimento, quantidade, concentracao, uso);
        this.dosagem = dosagem;
        this.descricao = descricao;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
