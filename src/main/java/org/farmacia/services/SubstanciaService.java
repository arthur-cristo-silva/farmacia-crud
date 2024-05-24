package org.farmacia.services;

import org.farmacia.entities.Substancia;
import org.farmacia.entities.Tipo;
import org.farmacia.repositories.SubstanciaRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class SubstanciaService {

    /*
    Alzheimer_Demencia,
    Antidrepressivo,
    Antipsicotico,
    Parkinson,
    Antinflamatorio_DorDeCabeca,
    Outros,
    Vitamina
     */

    public static void cadastrarSubstancia(Scanner sc) {
        System.out.println("--- CADASTRO DE SUBSTANCIA ---");
        System.out.print("Digite o nome da substancia: ");
        String nome = sc.nextLine();
        Substancia substancia = new Substancia(getTipo(sc), nome);
        SubstanciaRepository.save(substancia);
        System.out.println("Substancia cadastrada com sucesso!");
    }

    public static void save(Substancia sub) {
        SubstanciaRepository.save(sub);
    }

    public static void encontrarPorNome(Scanner sc) {
        System.out.print("Pesquisar pelo nome: ");
        String nome = sc.nextLine();
        ArrayList<Substancia> substancias = SubstanciaRepository.encontrarPorNome(nome);
        if (!substancias.isEmpty()) {
            for (Substancia substancia : substancias) {
                System.out.printf("%-12s | %-12s%n", "Nome", "Tipo");
                System.out.printf("%-12s | %-12s%n", substancia.getNome(), substancia.getMeuTipo());
            }
        } else {
            System.out.println("Nenhuma substancia com este nome foi encontrada.");
        }
    }

    public static void encontrarPorTipo(Scanner sc) {
        System.out.println("Pesquisar pelo tipo: ");
        ArrayList<Substancia> substancias = SubstanciaRepository.encontrarPorTipo(getTipo(sc));
        if (!substancias.isEmpty()) {
            for (Substancia substancia : substancias) {
                System.out.printf("%-12s | %-12s%n", "Nome", "Tipo");
                System.out.printf("%-12s | %-12s%n", substancia.getNome(), substancia.getMeuTipo());
            }
        } else {
            System.out.println("Nenhuma substancia com este tipo foi encontrada.");
        }
    }

    private static Tipo getTipo(Scanner sc) {
        Tipo tipo;
        byte tipoEscolha = 0;
        System.out.println("""
                Escolha o tipo da substância:
                [1] Alzheimer ou Demencia
                [2] Antidrepressivo
                [3] Antipsicotico
                [4] Parkinson
                [5] Antinflamatorio ou Dor de Cabeça
                [6] Vitamina
                [7] Outros""");
        System.out.print("-> ");
        try {
            tipoEscolha = Byte.parseByte(sc.nextLine());
        } catch (NumberFormatException ignored) {}
        tipo = switch (tipoEscolha) {
            case 1 -> Tipo.Alzheimer_Demencia;
            case 2 -> Tipo.Antidrepressivo;
            case 3 -> Tipo.Antipsicotico;
            case 4 -> Tipo.Parkinson;
            case 5 -> Tipo.Antinflamatorio_DorDeCabeca;
            case 6 -> Tipo.Vitamina;
            default -> Tipo.Outros;
        };
        return tipo;
    }

    public static void listarSubstancias() {
        ArrayList<Substancia> substancias = SubstanciaRepository.encontrarTodasSubstancias();
        if (!substancias.isEmpty()) {
            System.out.print("SUBSTÂNCIAS CADASTRADAS ");
            System.out.println("_".repeat(10));
            System.out.printf("%-12s %n", "Substância");
            for (Substancia substancia : substancias) {
                System.out.printf("%-12s %n", substancia.getNome());
            }
            System.out.println("_".repeat(40));
        } else {
            System.out.println("Substâncias não encontradas.");
        }
    }
}

