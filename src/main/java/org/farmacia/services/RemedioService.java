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
        ArrayList<Substancia> sub = null;
        boolean subAdd = true;
        while (subAdd) {
            try {
                SubstanciaService.listarSubstancias();
                System.out.print("Digite o nome da substância do remédio: ");
                String subName = sc.nextLine();
                sub.add(SubstanciaRepository.encontrarPorNome(subName).get(0));
                System.out.println("Você deseja adicionar outra substância? (S/N) ");
                String opcao = sc.nextLine();
                if (!opcao.equalsIgnoreCase("s")) {
                    subAdd = false;
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
        System.out.println("O remédio é: " +
                "[1] Uso Oral," +
                "[2] Uso Tópico," +
                "[3] Injetável.");
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
        switch (res) {
            case 1:
                RemedioOral remedioOral = new RemedioOral(sub, nome, date, quantidade, concentracao, dosagem);
                RemedioRepository.save(remedioOral);
                break;
            case 2:
                RemedioTopico remedioTopico = new RemedioTopico(sub, nome, date, quantidade, concentracao, dosagem);
                RemedioRepository.save(remedioTopico);
                break;
            case 3:
                RemedioInjetavel remedioInjetavel = new RemedioInjetavel(sub, nome, date, quantidade, concentracao, dosagem)
                RemedioRepository.save(remedioInjetavel);
                break;
        }
        System.out.println("Remédio cadastrado!");
    }

    public static void listarRemedios() {
        ArrayList<Remedio> remedios = RemedioRepository.encontrarTodosRemedios();
        if (!remedios.isEmpty()) {
            System.out.print("REMÉDIOS CADASTRADOS ");
            System.out.println("_".repeat(19));
            System.out.printf("%-50s | %-12s | %-10s %n", "Substância", "Nome", "Vencimento");
            for (Remedio remedio : remedios) {
                System.out.printf("%-50s | %-12s | %-10s %n", remedio.getSubstancias(), remedio.getNome_remedio(), remedio.getData_vencimento().format(formatter));
            }
            System.out.println("_".repeat(40));
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
            System.out.println("_".repeat(72));
            System.out.printf("%-50s | %-12s | %-10s | %-12s | %-12s%n", "Substancia", "Nome", "Vencimento", "Quantidade", "Concentração");
            for (Remedio remedio : remedios) {
                System.out.printf("%-50s | %-12s | %-10s | %-12s | %-12s%n", remedio.getSubstancias(), remedio.getNome_remedio(), remedio.getData_vencimento().format(formatter), remedio.getQuantidade(), remedio.getConcentracao(), remedio.getDosagem, getDescricao);
            }
            System.out.println("_".repeat(72));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

    public static void buscarRemedioPorValidade(Scanner sc) {
        System.out.println("Pesquisar por validade:");
        LocalDate date = getDate(sc);
        sc.nextLine();
        ArrayList<Remedio> remedios = RemedioRepository.encontrarPorValidade(date);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios que vencem em " + date.format(formatter) + " ");
            System.out.println("_".repeat(72));
            System.out.printf("%-12s | %-12s | %-10s | %-12s | %-12s%n", "Substancia", "Nome", "Vencimento", "Quantidade", "Concentração");
            for (Remedio remedio : remedios) {
                System.out.printf("%-12s | %-12s | %-10s | %-12s | %-12s%n", remedio.nome_substancia, remedio.nome_remedio, remedio.data_vencimento.format(formatter), remedio.quantidade, remedio.concentracao);
            }
            System.out.println("_".repeat(72));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

    public static void buscarRemedioPorFarmaceutica(Scanner sc) {
        System.out.print("Pesquisar por farmaceutica: ");
        sc.nextLine();
        String farmaceutica = sc.nextLine();
        ArrayList<Remedio> remedios = RemedioRepository.encontrarPorFarmaceutica(farmaceutica);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios da farmaceutica " + farmaceutica + " ");
            System.out.println("_".repeat(72));
            System.out.printf("%-12s | %-12s | %-10s | %-12s | %-12s%n", "Substancia", "Nome", "Vencimento", "Quantidade", "Concentração");
            for (Remedio remedio : remedios) {
                System.out.printf("%-12s | %-12s | %-10s | %-12s | %-12s%n", remedio.nome_substancia, remedio.nome_remedio, remedio.data_vencimento.format(formatter), remedio.quantidade, remedio.concentracao);
            }
            System.out.println("_".repeat(72));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

    public static void atualizarRemedio(Scanner sc) {
        System.out.println("-- ATUALIZAR REMÉDIO --");
        System.out.print("Insira o nome do remédio: ");
        String oldNome = sc.nextLine();
        String oldFarmaceutica = "null";
        if (!RemedioRepository.encontrarPorNome(oldNome).isEmpty()) {
            System.out.print("Insira a farmaceutica: ");
            oldFarmaceutica = sc.nextLine();
        }
        if (!RemedioRepository.encontrarPorFarmaceutica(oldFarmaceutica).isEmpty()) {
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
            System.out.print("Digite o nome da farmaceutica: ");
            farmaceuticaNome = sc.nextLine();
            Farmaceutica farm = new Farmaceutica("placeholder", -1, farmaceuticaNome);
            RemedioRepository.atualizarRemedio(oldNome, oldFarmaceutica, nome, date, quantidade, concentracao, farm);
            System.out.println("Remédio atualizado!");
        } else {
            System.out.println("Remédio não encontrado.");
        }
    }

    public static void removerRemedio(Scanner sc) {
        System.out.println("-- REMOVER REMÉDIO --");
        System.out.print("Insira o nome do remédio: ");
        String nome = sc.nextLine();
        String farmaceutica = "null";
        if (!RemedioRepository.encontrarPorNome(nome).isEmpty()) {
            System.out.print("Insira a farmaceutica: ");
            farmaceutica = sc.nextLine();
        }
        if (!RemedioRepository.encontrarPorFarmaceutica(farmaceutica).isEmpty()) {
            RemedioRepository.removerRemedio(nome, farmaceutica);
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

    public static void buscarRemedioPorSubstancia(Scanner sc) {
        System.out.print("Pesquisar por substancia: ");
        sc.nextLine();
        String substancia = sc.nextLine();
        ArrayList<Remedio> remedios = RemedioRepository.encontrarPorSubstancia(substancia);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios com a substancia " + substancia + " ");
            System.out.println("_".repeat(72));
            System.out.printf("%-12s | %-12s | %-10s | %-12s | %-12s%n", "Substancia", "Nome", "Vencimento", "Quantidade", "Concentração");
            for (Remedio remedio : remedios) {
                System.out.printf("%-12s | %-12s | %-10s | %-12s | %-12s%n", remedio.nome_substancia, remedio.nome_remedio, remedio.data_vencimento.format(formatter), remedio.quantidade, remedio.concentracao);
            }
            System.out.println("_".repeat(72));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

}
