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
    public static Substancia encontrarPorNome(String nome) {
        for (Substancia substancia : substancias) {
            if (Objects.equals(substancia.getNome().toLowerCase(), nome.toLowerCase())) {
                return substancia;
            }
        }
        return null;
    }

    //encontrarPorTipo(Tipo meuTipo): ArrayList<Substancia> -> Pesquisa por um Tipo e retorna tipo da substancia com este nome
        public static Substancia encontrarPorTipo(Tipo meuTipo) {
            for (Substancia substancia : substancias) {
                if (Objects.equals(substancia.getTipo(), meuTipo)) {
                   return substancia;
                }
            }
            return null;
        }

    // encontrarTodosSubstancias(): ArrayList<Substancia> -> Retorna todos Substancias cadastrados,
    public static ArrayList<Substancia> encontrarTodasSubstancias() {
        return substancias;
    }
      
  }
