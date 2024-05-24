import org.farmacia.services.SubstanciaService;

import java.util.Scanner;

public class TesteSubstancias {
    public static void testeSubstancias(Scanner sc) {
        SubstanciaService.cadastrarSubstancia(sc);
        SubstanciaService.cadastrarSubstancia(sc);
        SubstanciaService.encontrarPorNome(sc);
        SubstanciaService.encontrarPorTipo(sc);
    }
}
