package org.farmacia.repositories;

import org.farmacia.entities.Remedio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

// Repositório de Remédios: Armazena remédios em memória em uma ArrayList
public class RemedioRepository {

    private static ArrayList<Remedio> remedios = new ArrayList<>();

    //save(Remedio):void -> Adiciona remédio ao banco de dados
    public static void save(Remedio remedio) {
        remedios.add(remedio);
    }

    //encontrarPorNome(String nome): ArrayList<Remedio> -> Pesquisa por um nome e retorna remédios com este nome
    public static ArrayList<Remedio> encontrarPorNome(String nome) {
        ArrayList<Remedio> remediosPesquisados = new ArrayList<>();
        for (Remedio remedio : remedios) {
            if (Objects.equals(remedio.getNome_remedio().toLowerCase(), nome.toLowerCase())) {
                remediosPesquisados.add(remedio);
            }
        }
        return remediosPesquisados;
    }

    // encontrarTodosRemedios(): ArrayList<Remedio> -> Retorna todos remédios cadastrados,
    public static ArrayList<Remedio> encontrarTodosRemedios() {
        return remedios;
    }

    //atualizarRemedio(String nome, String farmaceutica, String novoNome, Date dataVencimento, int quantidade,float concentracao, Farmaceutica novaFarmaceutica): void -> Atualiza remédio x de farmaceutica y com os dados passados.
    public static void atualizarRemedio(String nome, String novoNome, LocalDate dataVencimento, int quantidade,
                                        float concentracao) {
        ArrayList<Remedio> remediosPesquisados = encontrarPorNome(nome);
        if (!remediosPesquisados.isEmpty()) {
            for (Remedio remedio : remediosPesquisados) {
                remedio.setNome_remedio(novoNome);
                remedio.setData_vencimento(dataVencimento);
                remedio.setQuantidade(quantidade);
                remedio.setConcentracao(concentracao);
            }
        } else {
            System.out.println("Remédio não encontrado.");
        }
    }


    //removerRemedio(String nome, String farmaceutica): void -> Remove remédio x de farmaceutica y do sistema.
    public static void removerRemedio(String nome, String farmaceutica) {
        ArrayList<Remedio> remediosPesquisados = encontrarPorNome(nome);
        if (!remediosPesquisados.isEmpty()) {
            for (Remedio remedio : remediosPesquisados) {
                remedios.remove(remedio);
            }
        } else {
            System.out.println("Remédio não encontrado.");
        }
    }
}
