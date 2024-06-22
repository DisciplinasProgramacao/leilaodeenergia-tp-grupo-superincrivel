import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Conjunto de empresas interessadas 1
        List<Lance> lancesConjunto1 = new ArrayList<>();
        lancesConjunto1.add(new Lance("E1", 430, 1043));
        lancesConjunto1.add(new Lance("E2", 428, 1188));
        lancesConjunto1.add(new Lance("E3", 410, 1565));
        lancesConjunto1.add(new Lance("E4", 385, 1333));
        lancesConjunto1.add(new Lance("E5", 399, 1214));
        lancesConjunto1.add(new Lance("E6", 382, 1498));
        lancesConjunto1.add(new Lance("E7", 416, 1540));
        lancesConjunto1.add(new Lance("E8", 436, 1172));
        lancesConjunto1.add(new Lance("E9", 416, 1386));
        lancesConjunto1.add(new Lance("E10", 423, 1097));
        lancesConjunto1.add(new Lance("E11", 400, 1463));
        lancesConjunto1.add(new Lance("E12", 406, 1353));
        lancesConjunto1.add(new Lance("E13", 403, 1568));
        lancesConjunto1.add(new Lance("E14", 390, 1228));
        lancesConjunto1.add(new Lance("E15", 387, 1542));
        lancesConjunto1.add(new Lance("E16", 390, 1206));
        lancesConjunto1.add(new Lance("E17", 430, 1175));
        lancesConjunto1.add(new Lance("E18", 397, 1492));
        lancesConjunto1.add(new Lance("E19", 392, 1293));
        lancesConjunto1.add(new Lance("E20", 393, 1533));
        lancesConjunto1.add(new Lance("E21", 439, 1149));
        lancesConjunto1.add(new Lance("E22", 403, 1277));
        lancesConjunto1.add(new Lance("E23", 415, 1624));
        lancesConjunto1.add(new Lance("E24", 387, 1280));
        lancesConjunto1.add(new Lance("E25", 417, 1330));
        

        // Conjunto de empresas interessadas 2
        List<Lance> lancesConjunto2 = new ArrayList<>();
        lancesConjunto2.add(new Lance("E1", 430, 1043));
        lancesConjunto2.add(new Lance("E2", 428, 1188));
        lancesConjunto2.add(new Lance("E3", 410, 1565));
        lancesConjunto2.add(new Lance("E4", 385, 1333));
        lancesConjunto2.add(new Lance("E5", 399, 1214));
        lancesConjunto2.add(new Lance("E6", 382, 1498));
        lancesConjunto2.add(new Lance("E7", 416, 1540));
        lancesConjunto2.add(new Lance("E8", 436, 1172));
        lancesConjunto2.add(new Lance("E9", 416, 1386));
        lancesConjunto2.add(new Lance("E10", 423, 1097));
        lancesConjunto2.add(new Lance("E11", 400, 1463));
        lancesConjunto2.add(new Lance("E12", 406, 1353));
        lancesConjunto2.add(new Lance("E13", 403, 1568));
        lancesConjunto2.add(new Lance("E14", 390, 1228));
        lancesConjunto2.add(new Lance("E15", 387, 1542));
        lancesConjunto2.add(new Lance("E16", 390, 1206));
        lancesConjunto2.add(new Lance("E17", 430, 1175));
        lancesConjunto2.add(new Lance("E18", 397, 1492));
        lancesConjunto2.add(new Lance("E19", 392, 1293));
        lancesConjunto2.add(new Lance("E20", 393, 1533));
        lancesConjunto2.add(new Lance("E21", 439, 1149));
        lancesConjunto2.add(new Lance("E22", 403, 1277));
        lancesConjunto2.add(new Lance("E23", 415, 1624));
        lancesConjunto2.add(new Lance("E24", 387, 1280));
        lancesConjunto2.add(new Lance("E25", 417, 1330));
        lancesConjunto2.add(new Lance("E1", 313, 1496));
        lancesConjunto2.add(new Lance("E2", 398, 1768));
        lancesConjunto2.add(new Lance("E3", 240, 1210));
        lancesConjunto2.add(new Lance("E4", 433, 2327));
        lancesConjunto2.add(new Lance("E5", 301, 1263));
        lancesConjunto2.add(new Lance("E6", 297, 1499));
        lancesConjunto2.add(new Lance("E7", 232, 1209));
        lancesConjunto2.add(new Lance("E8", 614, 2342));
        lancesConjunto2.add(new Lance("E9", 558, 2983));
        lancesConjunto2.add(new Lance("E10", 495, 2259));
        lancesConjunto2.add(new Lance("E11", 310, 1381));
        lancesConjunto2.add(new Lance("E12", 213, 961));
        lancesConjunto2.add(new Lance("E13", 213, 1115));
        lancesConjunto2.add(new Lance("E14", 346, 1552));
        lancesConjunto2.add(new Lance("E15", 385, 2023));
        lancesConjunto2.add(new Lance("E16", 240, 1234));
        lancesConjunto2.add(new Lance("E17", 483, 2828));
        lancesConjunto2.add(new Lance("E18", 487, 2617));
        lancesConjunto2.add(new Lance("E19", 709, 2328));
        lancesConjunto2.add(new Lance("E20", 358, 1847));
        lancesConjunto2.add(new Lance("E21", 467, 2038));
        lancesConjunto2.add(new Lance("E22", 363, 2007));
        lancesConjunto2.add(new Lance("E23", 279, 1311));
        lancesConjunto2.add(new Lance("E24", 589, 3164));
        lancesConjunto2.add(new Lance("E25", 476, 2480));

        int quantidadeEnergia = 8000;

        // Teste com Conjunto 1
        System.out.println("Resultados para Conjunto 1:");
        VendedorDeEnergia vendedor1 = new VendedorDeEnergia(quantidadeEnergia, lancesConjunto1);

        System.out.println("\nBacktracking:");
        vendedor1.resolverBacktracking();

        System.out.println("\nAlgoritmo Guloso (estratégia 1):");
        vendedor1.resolverGuloso(1);

        System.out.println("\nAlgoritmo Guloso (estratégia 2):");
        vendedor1.resolverGuloso(2);

        System.out.println("\nDivisão e Conquista:");
        vendedor1.resolverDivisaoConquista();

        System.out.println("\nProgramação Dinâmica:");
        vendedor1.resolverProgramacaoDinamica();

        // Teste com Conjunto 2
        System.out.println("\n\nResultados para Conjunto 2:");
        VendedorDeEnergia vendedor2 = new VendedorDeEnergia(quantidadeEnergia, lancesConjunto2);

        System.out.println("\nBacktracking:");
        vendedor2.resolverBacktracking();

        System.out.println("\nAlgoritmo Guloso (estratégia 1):");
        vendedor2.resolverGuloso(1);

        System.out.println("\nAlgoritmo Guloso (estratégia 2):");
        vendedor2.resolverGuloso(2);

        System.out.println("\nDivisão e Conquista:");
        vendedor2.resolverDivisaoConquista();

        System.out.println("\nProgramação Dinâmica:");
        vendedor2.resolverProgramacaoDinamica();
    }
}