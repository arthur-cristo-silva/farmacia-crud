package org.farmacia.services;

import org.farmacia.entities.*;
import org.farmacia.repositories.RemedioRepository;
import org.farmacia.repositories.SubstanciaRepository;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RemedioService {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void comprar() {

    }

    public static void vender() {

    }

    public static void cadastrarRemedio(Scanner sc) {
        int quantidade = -1;
        float concentracao = -1;
        System.out.println("-- CADASTRAR NOVO REMÉDIO --");
        ArrayList<Substancia> sub = new ArrayList<>();
        while (true) {
            try {
                SubstanciaService.listarSubstancias();
                System.out.print("Digite o nome da substância do remédio: ");
                String subName = sc.nextLine();
                Substancia substancia = SubstanciaRepository.encontrarPorNome(subName);
                if (substancia != null) {
                    sub.add(substancia);
                } else {
                    System.out.println("Substância não encontrada");
                }
                System.out.println("Você deseja adicionar outra substância? (S/N) ");
                String opcao = sc.nextLine();
                if (!opcao.equalsIgnoreCase("s")) {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("  ");
                System.out.println("!!! Substância não encontrada !!!");
                System.out.println("  ");
                System.out.println("Veja se digitou corretamente");
                System.out.println("  ou  ");
                System.out.println("Saia e Cadastre Substância");
                System.out.println("Digite 1 para sair ");
                Scanner aux = new Scanner(System.in);
                int a = aux.nextInt();
                if (a == 1) {
                    return;
                }
            }
        }
        System.out.print("Digite o nome do remédio: ");
        String nome = sc.nextLine();
        LocalDate date = getDate(sc);
        while (quantidade < 0) {
            try {
                System.out.print("Digite a quantidade de remédios em estoque: ");
                quantidade = sc.nextInt();
                if (quantidade < 0) {
                    System.out.println("Por favor, insira uma quantidade válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma quantidade válida.");
                sc.nextLine();
            }
        }
        while (concentracao < 0) {
            try {
                System.out.print("Digite a concentração do remédio: ");
                concentracao = sc.nextFloat();
                if (concentracao < 0) {
                    System.out.println("Por favor, insira uma concentração válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma concentração válida.");
                sc.nextLine();
            }
        }
        System.out.print("Qual é dosagem recomendada dele? ");
        String dosagem = sc.nextLine();
        System.out.printf("O remédio é:%n[1] Uso Oral,%n[2] Uso Tópico,%n[3] Injetável.%n>>> ");
        byte res = 0;
        while (res < 1 || res > 3) {
            try {
                res = Byte.parseByte(sc.nextLine());
                if (res < 1 || res > 3) {
                    System.out.println("Por favor, digite uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite uma opção válida.");
            }
        }
        Remedio remedio = switch (res) {
            case 1 -> new RemedioOral(sub, nome, date, quantidade, concentracao, Uso.Oral, "3 ao dia", "Muito bala");
            case 2 -> new RemedioTopico(sub, nome, date, quantidade, concentracao, Uso.Topico, "3 ao dia", "Muito bala");
            case 3 -> new RemedioInjetavel(sub, nome, date, quantidade, concentracao, Uso.Injetavel, "3 ao dia", "Muito bala");
            default -> null;
        };
        RemedioRepository.save(remedio);
        System.out.println("Remédio cadastrado!");
    }

    public static void listarRemedios() {
        ArrayList<Remedio> remedios = RemedioRepository.encontrarTodosRemedios();
        if (!remedios.isEmpty()) {
            System.out.print("REMÉDIOS CADASTRADOS ");
            System.out.println("_".repeat(25));
            System.out.printf("%-20s | %-10s | %-10s %n", "Nome", "Uso", "Vencimento");
            System.out.println("_".repeat(46));
            for (Remedio remedio : remedios) {
                System.out.printf("%-20s | %-10s | %-10s %n", remedio.getNome_remedio(), remedio.getUso(), remedio.getData_vencimento().format(formatter));
            }
            System.out.println("_".repeat(46));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

    public static void buscarRemedioPorNome(Scanner sc) {
        System.out.print("Procurar pelo nome: ");
        String nome = sc.nextLine();
        ArrayList<Remedio> remedios = RemedioRepository.encontrarPorNome(nome);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios com o nome " + nome + " ");
            System.out.println("_".repeat(61));
            System.out.printf("%-20s | %-10s | %-10s | %-10s%n", "Nome", "Vencimento", "Quantidade", "Concentração");
            System.out.println("_".repeat(61));
            for (Remedio remedio : remedios) {
                System.out.printf("%-20s | %-10s | %-10s | %-10s%nUso: %-12s %s%n%nDescrição:%n%s%n", remedio.getNome_remedio(), remedio.getData_vencimento().format(formatter), remedio.getQuantidade(), remedio.getConcentracao(), remedio.getUso(), remedio.getDosagem(), remedio.getDescricao());
                if (!remedio.getSubstancias().isEmpty()) {
                    System.out.println("\nSubstâncias:");
                    for (Substancia substancia : remedio.getSubstancias()) {
                        System.out.println(substancia);
                    }
                }
            }
            System.out.println("_".repeat(61));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

    public static void atualizarRemedio(Scanner sc) {
        System.out.println("-- ATUALIZAR REMÉDIO --");
        System.out.print("Insira o nome do remédio: ");
        String oldNome = sc.nextLine();
        if (!RemedioRepository.encontrarPorNome(oldNome).isEmpty()) {
            int quantidade = -1;
            float concentracao = -1;
            String farmaceuticaNome;
            System.out.println("Agora insira as informações atualizadas.");
            System.out.print("Digite o nome do remédio: ");
            String nome = sc.nextLine();
            LocalDate date = getDate(sc);
            while (quantidade < 0) {
                try {
                    System.out.print("Digite a quantidade de remédios em estoque: ");
                    quantidade = sc.nextInt();
                    if (quantidade < 0) {
                        System.out.println("Por favor, insira uma quantidade válida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira uma quantidade válida.");
                    sc.nextLine();
                }
            }
            while (concentracao < 0) {
                try {
                    System.out.print("Digite a concentração do remédio: ");
                    concentracao = sc.nextFloat();
                    if (concentracao < 0) {
                        System.out.println("Por favor, insira uma concentração válida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira uma concentração válida.");
                    sc.nextLine();
                }
            }
            sc.nextLine();
            RemedioRepository.atualizarRemedio(oldNome, nome, date, quantidade, concentracao);
            System.out.println("Remédio atualizado!");
        } else {
            System.out.println("Remédio não encontrado.");
        }
    }

    public static void removerRemedio(Scanner sc) {
        System.out.println("-- REMOVER REMÉDIO --");
        System.out.print("Insira o nome do remédio: ");
        String nome = sc.nextLine();
        if (!RemedioRepository.encontrarPorNome(nome).isEmpty()) {
            RemedioRepository.removerRemedio(nome);
            System.out.println("Remédio removido com sucesso!");
        } else {
            System.out.println("Remédio não encontrado.");
        }
    }

    public static void save(Remedio remedio) {
        RemedioRepository.save(remedio);
    }

    private static LocalDate getDate(Scanner sc) {
        int ano = -1;
        int mes = -1;
        int dia = -1;
        while (ano < Year.now().getValue()) {
            try {
                System.out.print("Digite o ano de vencimento: ");
                ano = sc.nextInt();
                if (ano < Year.now().getValue()) {
                    System.out.println("Por favor, insira um ano válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um ano válido.");
                sc.nextLine();
            }
        }
        while (mes < 1 || mes > 12) {
            try {
                System.out.print("Digite o mês de vencimento (1-12): ");
                mes = sc.nextInt();
                if (mes < 1 || mes > 12) {
                    System.out.println("Por favor, insira um mês válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um mês válido.");
                sc.nextLine();
            }
        }
        while (dia < 0 || dia > 31) {
            try {
                System.out.print("Digite o dia de vencimento: ");
                dia = sc.nextInt();
                if (dia < 0 || dia > 31) {
                    System.out.println("Por favor, insira um dia válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um dia válido.");
                sc.nextLine();
            }
        }
        return LocalDate.of(ano, mes, dia);
    }
}
