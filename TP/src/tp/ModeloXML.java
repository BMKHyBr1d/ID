/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

import java.util.List;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author HyBr1d
 */
public class ModeloXML {

    public static Document adicionaJogador(Jogador jog, Document doc) throws SaxonApiException {
        Element raiz;
        XdmValue res = null;
        if (doc == null) {
            raiz = new Element("jogadores"); //cria <catalogo>...</catalogo>
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
            String xp = "//jogador[@nome ='" + jog.getNome() + "']";
            System.out.println(xp);
            res = XPathFunctions.executaXpath(xp, "jogador.xml");
            if (res != null && res.size() > 0) {
                System.out.println("O Jogador JÁ EXISTE");
                return doc;
            } else { //ADICIONA

                Element jogador = new Element("jogador");
                Attribute nome = new Attribute("nome", jog.getNome());
                jogador.setAttribute(nome);
                Attribute numero = new Attribute("numero", jog.getNumero());
                jogador.setAttribute(numero);
                Element nomec = new Element("nomec").addContent(jog.getNomec());
                Element foto = new Element("foto").addContent(jog.getLink_foto());
                Element datan = new Element("DataN").addContent(jog.getDatanasc());
                Element nacionalidade = new Element("nacionalidade").addContent(jog.getNacionalidade());
                Element altura = new Element("altura").addContent(jog.getAltura());
                Element peso = new Element("peso").addContent(jog.getPeso());
                Element pepref = new Element("pepref").addContent(jog.getPe_pref());
                Element posicao = new Element("posicao").addContent(jog.getPosicao());
                Element clube = new Element("clube").addContent(jog.getClube_atual());
                Element selecao = new Element("selecao").addContent(jog.getSelecao());
                Element valor = new Element("valor").addContent(jog.getValor_contrato());
                Element empresario = new Element("empresario").addContent(jog.getEmpresario());
                Element ranking = new Element("ranking").addContent(jog.getRanking_tm());
                Element rankingClube = new Element("ranking").addContent(jog.getRanking_clube());
                Attribute tipog = new Attribute("tipo", "global");
                Attribute tipoc = new Attribute("tipo", "clube");
                ranking.setAttribute(tipog);
                rankingClube.setAttribute(tipoc);
                Element premios = new Element("premios").addContent(jog.getPremios().toString());
                jogador.addContent(nomec);
                jogador.addContent(foto);
                jogador.addContent(datan);
                jogador.addContent(nacionalidade);
                jogador.addContent(altura);
                jogador.addContent(peso);
                jogador.addContent(pepref);
                jogador.addContent(posicao);
                jogador.addContent(clube);
                jogador.addContent(selecao);
                jogador.addContent(valor);
                jogador.addContent(empresario);
                jogador.addContent(ranking);
                jogador.addContent(rankingClube);
                jogador.addContent(premios);
                raiz.addContent(jogador);
                return doc;
            }
        }
        return doc;
    }

    public static Document removeJogador(String nome, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe, nada a remover");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List todosJogadores = raiz.getChildren("jogador");
        boolean found = false;
        for (int i = 0; i < todosJogadores.size(); i++) {
            Element jogador = (Element) todosJogadores.get(i); //obtem livro i da Lista
            if (jogador.getAttributeValue("nome").equals(nome)) {
                jogador.getParent().removeContent(jogador);
                System.out.println("Jogador removido com sucesso!");
                found = true;
            }

        }
        if (!found) {
            System.out.println("Jogador " + nome + " não foi encontrado");
            return null;
        }
        return doc;

    }

    public static Document alteraClube(String nome, String novoClube, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe, nada a alterar");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List todosJogadores = raiz.getChildren("jogador");
        boolean found = false;
        for (int i = 0; i < todosJogadores.size(); i++) {
            Element jogador = (Element) todosJogadores.get(i); //obtem jogador i da Lista
            if (jogador.getAttributeValue("nome").equals(nome)) {
                jogador.getChild("clube").setText(novoClube);
                found = true;
            }

        }
        if (!found) {
            System.out.println("Jogador " + nome + " não foi encontrado");
            return null;
        } else {
            System.out.println("Clube alterado!");
        }
        return doc;
    }
    
    public static Document alteraNacionalidade(String nome, String novoNacionalidade , Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe, nada a alterar");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List todosJogadores = raiz.getChildren("jogador");
        boolean found = false;
        for (int i = 0; i < todosJogadores.size(); i++) {
            Element jogador = (Element) todosJogadores.get(i); //obtem jogador i da Lista
            if (jogador.getAttributeValue("nome").equals(nome)) {
                jogador.getChild("nacionalidade").setText(novoNacionalidade);
                found = true;
            }

        }
        if (!found) {
            System.out.println("Jogador " + nome + " não foi encontrado");
            return null;
        } else {
            System.out.println("Nacionalidade alterado!");
        }
        return doc;
    }
    
    public static Document alteraIdade(String nome, String novoIdade , Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe, nada a alterar");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List todosJogadores = raiz.getChildren("jogador");
        boolean found = false;
        for (int i = 0; i < todosJogadores.size(); i++) {
            Element jogador = (Element) todosJogadores.get(i); //obtem jogador i da Lista
            if (jogador.getAttributeValue("nome").equals(nome)) {
                jogador.getChild("idade").setText(novoIdade);
                found = true;
            }

        }
        if (!found) {
            System.out.println("Jogador " + nome + " não foi encontrado");
            return null;
        } else {
            System.out.println("Idade alterado!");
        }
        return doc;
    }

}
