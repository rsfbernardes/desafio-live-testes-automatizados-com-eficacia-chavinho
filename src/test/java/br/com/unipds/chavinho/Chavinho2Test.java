package br.com.unipds.chavinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Chavinho2Test {

    @Test
    void deveLerCsvSemCabecalhoComRecordESeparadorPontoEVirgula() {
        String csv = "src/test/resources/itens-cardapio.csv";

        Chavinho2 chavinho2 = new Chavinho2();
        List<ItemCardapio> lista = chavinho2.leCsvDeArquivo(csv, ";", false, ItemCardapio.class);
        ItemCardapio ultimo = lista.getLast();

        Assertions.assertNotNull(lista);
        Assertions.assertEquals(7, lista.size());
        Assertions.assertEquals(1L, lista.getFirst().id());
        Assertions.assertEquals("Tacos de Carnitas", ultimo.nome());
        Assertions.assertTrue(lista.getFirst().getClass().isRecord());
    }

}
