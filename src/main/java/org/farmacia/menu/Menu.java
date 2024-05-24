package org.farmacia.menu;
import java.util.Scanner;

import org.farmacia.services.RemedioService;
import org.farmacia.services.SubstanciaService;



public class Menu {

    public static void menuInicial(){
        int respostaMenuInicial;
        Scanner sc1 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("S I S T E M A   D E   A M O S T R A S  D E   R E M É D I O S ");
        System.out.println(" ----------------------");
        System.out.println("Escolha dentre as opções(Digite o número correspondente a função desejada)");
        System.out.println("[1] - Cadastro");
        System.out.println("[2] - Barra de Pesquisa");
        System.out.println("[3] - Sair");
        respostaMenuInicial = sc1.nextInt();
        switch (respostaMenuInicial) {
            case 1:
                menuCadastro();
                break;
            case 2:
                barraDePesquisa();
                break;
            case 3:
                System.out.println("Você escolheu sair do Sistema");
                System.out.println("Bye Bitch");
                sc1.close();
                break;

        }
    }


    //Menu de Cadastro
    public static void menuCadastro() {
        int respostaMenuCadastro;
        Scanner sc2 = new Scanner(System.in);
        Scanner dados = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" C A D A S T R O");
        System.out.println(" ----------------------");
        System.out.println(" A T E N Ç Ã O");
        System.out.println(" AO CADASTRAR REMÉDIO - A SUBSTÂNCIA e FARMACÊUTICA  ja devem estar cadastradas");
        System.out.println(" ----------------------");
        System.out.println("Escolha dentre as opções(Digite o número correspondente a função desejada)");
        System.out.println(" ");
        System.out.println("[1] - Remedio");
        System.out.println("[2] - Substância");
        System.out.println("[3] - Farmaceutica");
        System.out.println("[4] - Representante");
        System.out.println("[5] - Voltar ao Menu Inicial");
        respostaMenuCadastro = sc2.nextInt();
        switch (respostaMenuCadastro) {
            case 1:
                RemedioService.cadastrarRemedio(dados);
                menuInicial();
                break;
            case 2:
                SubstanciaService.cadastrarSubstancia(dados);
                menuInicial();
                break;
            case 3:
                System.out.println("Você escolheu a opção 3- Farmaceutica");
                menuInicial();
                break;
            case 4:
                RepresentanteService.cadastrarRepresentante(dados);
                menuInicial();
                break;
            case 5:
                menuInicial();
                break;

        }
    }

    // Menu da Barra de Pesquiza
    public static void barraDePesquisa() {
        int respostaBarraDePesquisa;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" B A R R A    D E    P E S Q U I S A");
        System.out.println(" ----------------------");
        System.out.println("[1] - Listagem");
        System.out.println("[2] - Pesquisa por Atributo");
        System.out.println("[3] - Voltar ao Menu Inicial");
        respostaBarraDePesquisa = sc3.nextInt();
        switch (respostaBarraDePesquisa) {
            case 1:
                listagem();
                break;
            case 2:
                pesquisa();
                menuInicial();
                break;
            case 3:
                menuInicial();
                break;

        }
    }


    public static void listagem (){
        int respostaListagem;
        Scanner sc4 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" L I S T A G E M  ");
        System.out.println(" ----------------------");
        System.out.println("[1] - Remedio");
        System.out.println("[2] - Substância");
      //  System.out.println("[3] - Farmaceutica");
       // System.out.println("[4] - Representante");
        System.out.println("[5] - Voltar ao Menu Inicial");
        respostaListagem = sc4.nextInt();
        switch (respostaListagem) {
            case 1:
                RemedioService.listarRemedios();
                menuInicial();
                break;
            case 2:
                SubstanciaService.listarSubstancias();
                menuInicial();
                break;
            case 5:
                System.out.println("Você escolheu a opção 5- Voltar Ao Menu Inicial");
                menuInicial();
                break;

        }

    }


    public static void pesquisa (){
        int respostaPesquisa;
        Scanner sc5 = new Scanner(System.in);
        Scanner atributo = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" Pesquisa de Remedios por Atributos  ");
        System.out.println(" ----------------------");
        System.out.println("[1] - Nome");
        System.out.println("[2] - Substância");
        System.out.println("[3] - Validade");
        // System.out.println("[4] - Representante");
        System.out.println("[5] - Voltar ao Menu Inicial");
        respostaPesquisa = sc5.nextInt();
        switch (respostaPesquisa) {
            case 1:

                RemedioService.buscarRemedioPorNome(atributo);
                menuInicial();
                break;
            case 2:
                RemedioService.buscarRemedioPorSubstancia(atributo);
                menuInicial();
                break;
            case 3:
                System.out.println("Digite a data de validade (formato AAAA-MM-DD):");
                RemedioService.buscarRemedioPorValidade(sc5);
                menuInicial();
                break;
            case 5:
                System.out.println("Você escolheu a opção 5- Voltar Ao Menu Inicial");
                menuInicial();
                break;
        }
    }


}

