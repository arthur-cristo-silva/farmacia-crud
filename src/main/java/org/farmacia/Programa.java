package org.farmacia;

import org.farmacia.entities.*;
import org.farmacia.menu.Menu;
import org.farmacia.repositories.RemedioRepository;
import org.farmacia.repositories.SubstanciaRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {

        // Criação de 4 substancias
        Substancia sub1 = new Substancia(Tipo.Alzheimer_Demencia,"Cloridrato de Donepezila");
        SubstanciaRepository.save(sub1);
        Substancia sub2 = new Substancia(Tipo.Antidrepressivo,"Maleato de Fluvoxamina");
        SubstanciaRepository.save(sub2);
        Substancia sub3 = new Substancia(Tipo.Antipsicotico,"Quietiapina");
        SubstanciaRepository.save(sub3);
        Substancia sub4 = new Substancia(Tipo.Parkinson,"Levedopa");
        SubstanciaRepository.save(sub4);
        ArrayList<Substancia> substancias = new ArrayList<>();
        substancias.add(sub1);
        substancias.add(sub2);
        ArrayList<Substancia> substancias2 = new ArrayList<>();
        substancias2.add(sub3);



        // Criação de 8 Remedios
        Remedio remedio1 = new RemedioOral(substancias, "Fluoxetina", LocalDate.of(2023, 12, 31), 60, 20.0f, Uso.Topico, "Teste", "Teste2");
        Remedio remedio2 = new RemedioInjetavel(substancias2, "Risperidona", LocalDate.of(2024, 6, 30), 30, 2.0f, Uso.Topico, "Teste", "Teste2");
        Remedio remedio3 = new RemedioTopico(substancias, "Carbidopa-Levodopa", LocalDate.of(2024, 6, 30), 100, 25.0f, Uso.Topico, "Teste", "Teste2");
        Remedio remedio4 = new RemedioOral(null, "Donepezil", LocalDate.of(2023, 12, 31), 30, 10.0f, Uso.Topico, "Teste", "Teste2");
        Remedio remedio5 = new RemedioInjetavel(substancias2, "Paracetamol", LocalDate.of(2024, 12, 31), 20, 500.0f, Uso.Topico, "Teste", "Teste2");
        Remedio remedio6 = new RemedioTopico(substancias, "Vitamina C", LocalDate.of(2025, 12, 31), 20, 1000.0f, Uso.Topico, "Teste", "Teste2");
        Remedio remedio7 = new RemedioOral(null, "Sildenafil", LocalDate.of(2024, 12, 31), 4, 50.0f, Uso.Topico, "Teste", "Teste2");
        Remedio remedio8 = new RemedioTopico(substancias2, "Alprazolam", LocalDate.of(2023, 12, 31), 60, 0.25f, Uso.Topico, "Teste", "Teste2");

        RemedioRepository.save(remedio1);
        RemedioRepository.save(remedio2);
        RemedioRepository.save(remedio3);
        RemedioRepository.save(remedio4);
        RemedioRepository.save(remedio5);
        RemedioRepository.save(remedio6);
        RemedioRepository.save(remedio7);
        RemedioRepository.save(remedio8);

        System.out.println("  ____    _____   __  __   _____   ____    ___    ___  ");
        System.out.println(" |  _ |  | ____| |  |/  | | ____| |  _ |  |_ _|  / _ | ");
        System.out.println(" | |_) | |  _|   | |||| | |  _|   | | | |  | |  | | | |");
        System.out.println(" |  _ <  | |___  | |  | | | |___  | |_| |  | |  | |_| |");
        System.out.println(" |_| |_| |_____| |_|  |_| |_____| |____/  |___|  |___/");
        // Interface Interativa com Usuário -> Menu.java
        Menu.menuInicial();
    }
}