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

    @Test
    void deveLerCsvComCabecalhoIgnorandoPrimeiraLinha() {
        String csv = "src/test/resources/unipds-disciplinas.csv";

        Chavinho2 chavinho2 = new Chavinho2();
        List<Disciplina> lista = chavinho2.leCsvDeArquivo(csv, ",", true, Disciplina.class);

        Assertions.assertNotNull(lista);
        Assertions.assertEquals(11, lista.size());

        Disciplina primeiro = lista.getFirst();
        Assertions.assertEquals(0, primeiro.numero());

        Disciplina ultimo =  lista.getLast();
        Assertions.assertEquals("Como Atrair as Melhores Vagas do Mercado ", ultimo.nome());
        Assertions.assertTrue(ultimo.getClass().isRecord());
    }



}
