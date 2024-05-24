import org.farmacia.services.RemedioService;

import java.util.Scanner;

public class TesteRemedios {
    static void testeRemedios(Scanner sc) {
        RemedioService.cadastrarRemedio(sc);
        /*
        RemedioService.atualizarRemedio(sc);
        RemedioService.removerRemedio(sc);
         */
        RemedioService.listarRemedios();
    }
}
