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
    private String dosagem;
    private String descricao;

    public Remedio(ArrayList<Substancia> substancias, String nome_remedio, LocalDate data_vencimento, int quantidade, float concentracao, Uso uso) {
        this.substancias = substancias;
        this.nome_remedio = nome_remedio;
        this.data_vencimento = data_vencimento;
        this.quantidade = quantidade;
        this.concentracao = concentracao;
        this.uso = uso;
    }

    public ArrayList<Substancia> getSubstancias() {
        return substancias;
    }

    public void setSubstancias(ArrayList<Substancia> substancias) {
        this.substancias = substancias;
    }

    public String getNome_remedio() {
        return nome_remedio;
    }

    public void setNome_remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public LocalDate getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(LocalDate data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(float concentracao) {
        this.concentracao = concentracao;
    }

    public Uso getUso() {
        return uso;
    }

    public void setUso(Uso uso) {
        this.uso = uso;
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

