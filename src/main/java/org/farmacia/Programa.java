package org.farmacia;

import org.farmacia.entities.Remedio;
import org.farmacia.entities.Substancia;
import org.farmacia.entities.Tipo;
import org.farmacia.menu.Menu;
import org.farmacia.repositories.RemedioRepository;
import org.farmacia.repositories.SubstanciaRepository;

import java.time.LocalDate;

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

        // Criação de uma farmaceutica
        Farmaceutica novaFarmaceutica = new Farmaceutica("Sam",00001,"novaFarmaceutica");

        // Criação de 8 Remedios
        Remedio remedio1 = new Remedio(Tipo.Antidrepressivo, "Fluoxetina", "Prozac", LocalDate.of(2023, 12, 31), 60, 20.0f, novaFarmaceutica);
        Remedio remedio2 = new Remedio(Tipo.Antipsicotico, "Risperidona", "Risperdal", LocalDate.of(2024, 6, 30), 30, 2.0f, novaFarmaceutica);
        Remedio remedio3 = new Remedio(Tipo.Parkinson, "Carbidopa-Levodopa", "Sinemet", LocalDate.of(2024, 6, 30), 100, 25.0f, novaFarmaceutica);
        Remedio remedio4 = new Remedio(Tipo.Alzheimer_Demencia, "Donepezil", "Aricept", LocalDate.of(2023, 12, 31), 30, 10.0f, novaFarmaceutica);
        Remedio remedio5 = new Remedio(Tipo.Antinflamatorio_DorDeCabeca, "Paracetamol", "Tylenol", LocalDate.of(2024, 12, 31), 20, 500.0f, novaFarmaceutica);
        Remedio remedio6 = new Remedio(Tipo.Vitamina, "Vitamina C", "Redoxon", LocalDate.of(2025, 12, 31), 20, 1000.0f, novaFarmaceutica);
        Remedio remedio7 = new Remedio(Tipo.Outros, "Sildenafil", "Viagra", LocalDate.of(2024, 12, 31), 4, 50.0f, novaFarmaceutica);
        Remedio remedio8 = new Remedio(Tipo.Outros, "Alprazolam", "Xanax", LocalDate.of(2023, 12, 31), 60, 0.25f, novaFarmaceutica);

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
        Menu menu = new Menu();
        menu.menuInicial();
    }
}