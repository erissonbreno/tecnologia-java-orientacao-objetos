package application;

import br.edu.infnet.model.domain.*;
import br.edu.infnet.model.enums.TamanhoBebida;
import br.edu.infnet.model.enums.TipoEntrega;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Cliente breno = new Cliente("Breno", "e@b.com", "123");

        Bebida cocaColaGrande = new Bebida("Refrigerante 2L", 8.00, 1001, true, TamanhoBebida.GARRAFA_2L, "Coca-Cola");
        Bebida cervejaLata = new Bebida("Cerveja Lata", 3.00, 1002, false, TamanhoBebida.LATA, "Budweiser");

        Comida hamburguer = new Comida("Hamburguer", 20.50, 1003, 0.5, false, new String[]{"Carne", "Sal"});
        Comida feijoada = new Comida("Feijoada", 7.50, 1004, 1, true, new String[]{"Feijao", "Calabresa", "Carne Seca"});

        Sobremesa mousseDeMaracuja = new Sobremesa("Mousse de Maracuja", 9.00, 1006, 2, true, Set.of("Contem acucar"));
        Sobremesa mousseFit = new Sobremesa("Mousse Whey", 13.90, 1007, 1, false, Set.of("Fitness"));

        String relativePath = "src/main/resources/sobremesa.txt";
        List<Object> data = List.of("Mousse de Maracuja", 9.00, 1006, 2, true, "Contem acucar");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(relativePath))) {
            data.forEach(info -> {
                try {
                    bw.write(info.toString());
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(relativePath);
        try (Scanner sc = new Scanner(file)) {
            System.out.println("########################Dados do Arquivo########################");
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        Pedido pedidoSoBebida = new Pedido(List.of(cocaColaGrande, cervejaLata), TipoEntrega.RAPIDA, true, breno);
        Pedido pedidoCompletoEntregaRapida = new Pedido(List.of(cocaColaGrande, cervejaLata, hamburguer, feijoada, mousseFit, mousseDeMaracuja),
                TipoEntrega.RAPIDA, false, breno);
        Pedido pedidoCompletoEntregaNormal = new Pedido(List.of(cocaColaGrande, cervejaLata, hamburguer, feijoada, mousseFit, mousseDeMaracuja),
                TipoEntrega.NORMAL, false, breno);

        System.out.println(pedidoSoBebida);
        System.out.println(pedidoCompletoEntregaRapida);
        System.out.println(pedidoCompletoEntregaNormal);
    }
}