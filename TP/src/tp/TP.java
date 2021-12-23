/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;
import org.jdom2.DocType;
import org.jdom2.Document;
import static tp.Wrappers.*;

/**
 *
 * @author HyBr1d
 */
public class TP {

    /**
     * @param args the command line arguments
     */
 
   public static void main(String[] args) throws FileNotFoundException, IOException, SaxonApiException {

        String nome = "Diego Maradona";

        ImprimeInformacaoJogador(nome);
        ////////////////Cria jogador
        Jogador jog = cria_jogador(nome);
        //Inicializa Doc XML
        Document doc = XMLJDomFunctions.lerDocumentoXML("jogador.xml");
        //Chama a função para adicionar o livro ao XML
        doc = ModeloXML.adicionaJogador(jog, doc);
        /////////////////////remove jogador/////////////////
        //doc = ModeloXML.removeJogador(nome, doc);
        /////////////////////ALterações
        //Chama a função para alterar o nome do clube para Liverpool
        //doc = ModeloXML.alteraClube(nome, "Liverpool", doc);
        //Chama a função para alterar a nacionalidade
        //doc = ModeloXML.alteraNacionalidade(nome, "Espanha", doc);
        //doc= ModeloXML.alteraIdade(nome, "37", doc);

        //grava o ficheiro XML alterado em disco
        if (doc != null) {
            XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "jogador.xml");
        }

        ////////////////////////////VALIDACAO/////////////////////////////////////////
        
        
        /////////////////////XPATH/////////////////////////////////////////////
        //Pesquisar pelo nome de um jogador (pode ser parcial) e mostrar a informação relevante
        /*
        System.out.prPesquisar pelo nome de um jogadorint("Nome? ");
        Scanner ler = new Scanner(System.in);
        String nomejoga = ler.next();
        String xp = "//jogador[@nome = '" + nomejoga + "']";
        System.out.println(xp);
        XdmValue res = XPathFunctions.executaXpath(xp, "jogador.xml");
        String s = XPathFunctions.listaResultado(res);
        if (res == null) {
            System.out.println("Ficheiro XML não existe");
        } else if (res.size() == 0) {
            System.out.println("Sem resultados");
        } else {
            System.out.println(s);
        }
        
        //Pesquisar jogadores de um dado clube (atual)
        String xp = "//jogador[contains(clube,\"Liverpool\")]/@nome";
        System.out.println(xp);
        XdmValue res = XPathFunctions.executaXpath(xp, "jogador.xml");
        String s = XPathFunctions.listaResultado(res);
        if (res == null) {
            System.out.println("Ficheiro XML não existe");
        } else if (res.size() == 0) {
            System.out.println("Sem resultados");
        } else {
            System.out.println(s);
        }
        
          //Pesquisar jogadores com uma determinada nacionalidade
        String xp = "//jogador[contains(nacionalidade,\"Portugal\")]/@nome";
        System.out.println(xp);
        XdmValue res = XPathFunctions.executaXpath(xp, "jogador.xml");
        String s = XPathFunctions.listaResultado(res);
        if (res == null) {
            System.out.println("Ficheiro XML não existe");
        } else if (res.size() == 0) {
            System.out.println("Sem resultados");
        } else {
            System.out.println(s);
        }
       
         //Pesquisar jogadores que joguem numa dada posição
        String xp = "//jogador[contains(posicao,\"Ponta de Lança\")]/@nome";
        System.out.println(xp);
        XdmValue res = XPathFunctions.executaXpath(xp, "jogador.xml");
        String s = XPathFunctions.listaResultado(res);
        if (res == null) {
            System.out.println("Ficheiro XML não existe");
        } else if (res.size() == 0) {
            System.out.println("Sem resultados");
        } else {
            System.out.println(s);
        }
         
        //Pesquisar jogadores que não estejam no ativo (reformados, ou com outras funções)
        

        String xp = "//jogador[contains(clube,\"Fim de carreira\")]/@nome";
        System.out.println(xp);
        XdmValue res = XPathFunctions.executaXpath(xp, "jogador.xml");
        String s = XPathFunctions.listaResultado(res);
        if (res == null) {
            System.out.println("Ficheiro XML não existe");
        } else if (res.size() == 0) {
            System.out.println("Sem resultados");
        } else {
            System.out.println(s);
        }
 */       
    }


    public static void ImprimeInformacaoJogador(String nome) throws IOException {

        System.out.println("\nJogador:" + nome + "\n");

        String nomec = WrapperNomeCompleto(nome);
        
        System.out.println("\nNome Completo:" + nomec + "\n");

        String num = WrapperNumero(nomec);
        System.out.println("\nNumero:" + num + "\n");

        String link = WrapperLink(nomec);
        System.out.println("\nLink:" + link + "\n");

        String datanasc = WrapperDatanasc(nomec);
        System.out.println("\nDatanasc:" + datanasc + "\n");

        String nac = WrapperNacionalidade(nomec);
        System.out.println("\nNacionalidade:" + nac + "\n");

        String altura = WrapperAltura(nome);
        System.out.println("\nAltura:" + altura + "\n");

        String peso = WrapperPeso(nome);
        System.out.println("\nPeso:" + peso + "\n");

        String pepref = WrapperPePref(nomec);
        System.out.println("\nPepref:" + pepref + "\n");

        String pos = WrapperPosicao(nomec);
        System.out.println("\nPosicao:" + pos + "\n");
        

        String clube = WrapperClubeA(nomec);
        System.out.println("\nClube:" + clube + "\n");
        
        String selecao = WrapperSelecao(nomec);
        System.out.println("\nSelecao:" + selecao + "\n");
        
        String valor = WrapperValor(nomec);
        System.out.println("\nValor:" + valor + "\n");
        
        String empresario = WrapperEmpresario(nomec);
        System.out.println("\nEmpresario:" + empresario + "\n");

        String ranking;
        if (clube == "---" || clube == "Fim de carreira") {
            ranking = "Não tem ranking!";
        } else {
            ranking = WrapperRanking(nomec);
            System.out.println("\nRanking:" + ranking + "\n");
        }
        
        String rankingclube = WrapperRankingClube(nomec);
            System.out.println("\nRanking:" + rankingclube + "\n");
        
        
        ArrayList <String> premios = WrapperPremiosInd(nomec);
        System.out.println("\nPremios:" + premios.toString() + "\n");
        
        ArrayList <String> clubesant = WrapperClubesAnt(nomec);
        System.out.println("\nPremios:" + clubesant.toString() + "\n");

    }

     public static String encontraLinkWikiF(String nome) throws IOException {
        String link = "https://football.fandom.com/wiki/Special:Search?query=";
        HttpRequestFunctions.httpRequest1(link, nome, "soccerw.txt");
        String er1 = "<a href=\"(https://football.fandom.com/wiki/[^\"]+)\"";
        Pattern p1 = Pattern.compile(er1);
        Matcher m1;
        Scanner ler = new Scanner(new FileInputStream("soccerw.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if (m1.find()) {
                ler.close();
                return m1.group(1);
            }
        }
        ler.close();
        return null;
    }
    
    public static String encontraLinkSoccerW(String nome) throws IOException {
        String link = "https://pt-br.soccerwiki.org/wiki.php?action=search&searchType=all&q=";
        HttpRequestFunctions.httpRequest1(link, nome, "soccerw.txt");
        String er1 = "<a href=\"(player[.]php[?]pid=[0-9]+)\">";
        Pattern p1 = Pattern.compile(er1);
        Matcher m1;
        Scanner ler = new Scanner(new FileInputStream("soccerw.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if (m1.find()) {
                ler.close();
                return "https://pt-br.soccerwiki.org/" + m1.group(1);
            }
        }
        ler.close();
        return null;
    }

    public static String encontraLinkTransferProfil(String nome) throws IOException {
        String link = "https://www.transfermarkt.pt/schnellsuche/ergebnis/schnellsuche?query=";
        HttpRequestFunctions.httpRequest1(link, nome, "transfer.txt");
        String er1 = "href=\"/([a-z-]+/profil/spieler/[0-9]+)\">";
        Pattern p1 = Pattern.compile(er1);
        Matcher m1;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if (m1.find()) {
                ler.close();
                return "https://www.transfermarkt.pt/" + m1.group(1);
            }
        }
        ler.close();
        return null;
    }

    public static String encontraLinkTransferValorM(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "href=\"/([a-z-]+/marktwertverlauf/spieler/[0-9]+)\">";
        Pattern p1 = Pattern.compile(er1);
        Matcher m1;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if (m1.find()) {
                ler.close();
                return "https://www.transfermarkt.pt/" + m1.group(1);
            }
        }
        ler.close();
        return null;
    }
    
    public static String encontraLinkTransferP(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "href=\"/([a-z-]+/erfolge/spieler/[0-9]+)\"";
        Pattern p1 = Pattern.compile(er1);
        Matcher m1;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if (m1.find()) {
                ler.close();
                return "https://www.transfermarkt.pt/" + m1.group(1);
            }
        }
        ler.close();
        return null;
    }

   
    public static String encontraLinkWiki(String nome) throws IOException {
        String link = "https://www.google.com/search?q=";
        HttpRequestFunctions.httpRequest1(link, nome + "wikipedia", "wikipedia_google.bin");
        String er1 = "href=\"/(https://pt.wikipedia.org/wiki/[^\"]+)\">";
        Pattern p1 = Pattern.compile(er1);
        Matcher m1;
        Scanner ler = new Scanner(new FileInputStream("wikipedia_google.bin"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if (m1.find()) {
                ler.close();
                return m1.group(1);
            }
        }
        ler.close();
        return null;
    }
    

}
