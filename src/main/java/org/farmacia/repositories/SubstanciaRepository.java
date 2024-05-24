package org.farmacia.repositories;

import org.farmacia.entities.Substancia;
import org.farmacia.entities.Tipo;

import java.util.ArrayList;
import java.util.Objects;

// Repositório de Substancia: Armazena substancias em memória em uma ArrayList
public class SubstanciaRepository {
    static ArrayList<Substancia> substancias = new ArrayList<>();
    //save(Substancia):void -> Adiciona substancia ao banco de dados


    public static void save(Substancia substancia) {
        substancias.add(substancia);
    }

    //encontrarPorNome(String nome): ArrayList<Substancia> -> Pesquisa por um nome e retorna substancias com este nome
    public static ArrayList<Substancia> encontrarPorNome(String nome) {
        ArrayList<Substancia> substanciasPesquisados = new ArrayList<>();
        for (Substancia substancia : substancias) {
            if (Objects.equals(substancia.nome_substancia.toLowerCase(), nome.toLowerCase())) {
                substanciasPesquisados.add(substancia);
            }
        }
        return substanciasPesquisados;
    }

    //encontrarPorTipo(Tipo meuTipo): ArrayList<Substancia> -> Pesquisa por um Tipo e retorna tipo da substancia com este nome
        public static ArrayList<Substancia> encontrarPorTipo(Tipo meuTipo) {
            ArrayList<Substancia> substanciasPesquisados = new ArrayList<>();
            for (Substancia substancia : substancias) {
                if (Objects.equals(substancia.meuTipo, meuTipo)) {
                    substanciasPesquisados.add(substancia);
                }
            }
            return substanciasPesquisados;
        }

    // encontrarTodosSubstancias(): ArrayList<Substancia> -> Retorna todos Substancias cadastrados,
    public static ArrayList<Substancia> encontrarTodasSubstancias() {
        return substancias;
    }
      
  }
