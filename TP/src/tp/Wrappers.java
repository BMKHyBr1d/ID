/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static tp.TP.*;

/**
 *
 * @author HyBr1d
 */
public class Wrappers {

    /*
    public static String WrapperNomeCompleto(String nome) throws IOException {
        HttpRequestFunctions.httpRequest1("https://pt.wikipedia.org/wiki/", nome, "wiki.txt");

        String er1 = "Nome completo";
        String er3 = "<b>([a-zA-Z\\sãõéíàáóçú]+)</b>, [a-zA-Z]* conhecido como";
        String er2 = "<td[^>]*>([a-zA-Z\\sãõéíàáóçú]+)";
        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Pattern p3 = Pattern.compile(er3);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("wiki.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            } else {
                m = p3.matcher(linha);
            }
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }
        ler.close();
        return "Nome Completo não encontrado!";
    }
     */
    public static String WrapperNomeCompleto(String nome) throws IOException {
        HttpRequestFunctions.httpRequest1("https://pt.wikipedia.org/wiki/", nome, "wiki.txt");

        String er1 = "Nome completo";
        String er3 = "<b>([a-zA-Z\\sãõéíàáóçú]+)</b>, [a-zA-Z]* conhecido como";
        String er2 = "<td[^>]*>([a-zA-Z\\sãõéíàáóçú]+)";
        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Pattern p3 = Pattern.compile(er3);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("wiki.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            } else {
                m = p3.matcher(linha);
            }
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }
        ler.close();
        return WrapperNomeCompleto1(nome);
    }

    public static String WrapperNomeCompleto1(String nome) throws IOException {
        String link = encontraLinkWikiF(nome);
        HttpRequestFunctions.httpRequest1(link, "", "wikif.txt");
        String er1 = "<b>Full.+</b>";
        String er2 = "<td colspan=\"2\">([a-zA-Z\\sãõéíàáóçú]+)";

        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("wikif.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }
        }
        return "Nome Completo não encontrado";
    }

    public static String WrapperNumero(String nome) throws IOException {
        String link2 = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link2, "", "transfer.txt");

        String er1 = "<span class=\"dataRN\">#([0-9]+)</span>";
        Pattern p = Pattern.compile(er1);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }
        return "Não joga";
    }

    public static String WrapperLink(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "<div class=\"dataBild\">";
        String er2 = "data-src=\"([^\"]+)\"";
        String er3 = "<div class=\"dataRibbonRIP\">";
        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Pattern p3 = Pattern.compile(er3);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }
                
        }
        return WrapperLink2(nome);
    }
    
    public static String WrapperLink2(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
                String er1 = "<div class=\"dataRibbonRIP\">";
        String er2 = "data-src=\"([^\"]+)\"";
        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }  
        }
        return "Link não encontrado";
    }

    public static String WrapperDatanasc(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "<span itemprop=\"birthDate\" class=\"dataValue\">";
        String er2 = "([0-9/]+)";
        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }
        }
        return "Data de nascimento não encontrada";
    }

    ;
    
     public static String WrapperNacionalidade(String nome) throws IOException {
        String link2 = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link2, "", "transfer.txt");

        String er1 = "<span itemprop=\"nationality\">([^<]+)</span>";
        Pattern p = Pattern.compile(er1);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }
        return "Nacionalidade não encontrada";
    }

    /*
    public static String WrapperAltura(String nome) throws IOException {
        String link = "https://www.zerozero.pt/search.php?inputString=" + nome.replace(" ", "+") + "&op=all";
        //System.out.println("\nLINK:"+link+"\n");
        HttpRequestFunctions.httpRequest2(link, nome, "zerozeroS.txt");

        String er1 = "<div class=\"bio_half\"><span>Altura</span>(.*) cm</div>";
        Pattern p = Pattern.compile(er1);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("zerozeroS.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }
        return "Altura não encontrada!";
    }
     */
    public static String WrapperAltura(String nome) throws IOException {

        String link = encontraLinkSoccerW(nome);
        HttpRequestFunctions.httpRequest1(link, "", "soccerw.txt");

        String er1 = "cm[)]</th><td class=\"left\">([0-9]+)</td>";
        Pattern p = Pattern.compile(er1);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("soccerw.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }
        return "Altura não encontrada";
    }

    //<th class="right">Peso (kg)</th><td class="left">81</td>
/*
    public static String WrapperPeso(String nome) throws IOException {
        String link = "https://www.zerozero.pt/search.php?inputString=" + nome.replace(" ", "+") + "&op=all";
        //System.out.println("\nLINK:"+link+"\n");
        HttpRequestFunctions.httpRequest2(link, nome, "zerozeroS.txt");

        String er1 = "<div class=\"bio_half\"><span>Peso</span>(.*) kg</div>";
        Pattern p = Pattern.compile(er1);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("zerozeroS.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }
        return "Peso não encontrado!";
    }
     */
    public static String WrapperPeso(String nome) throws IOException {
        String link = encontraLinkSoccerW(nome);
        HttpRequestFunctions.httpRequest1(link, "", "soccerw.txt");

        String er1 = "kg[)]</th><td class=\"left\">([0-9]+)</td>";
        Pattern p = Pattern.compile(er1);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("soccerw.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }
        return "Peso não encontrada";
    }

    public static String WrapperPePref(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "<th>Pé:</th>";
        String er2 = "<td>([a-zA-Z]+)</td>";
        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }
        }
        return "Pe Preferido não encontrado";
    }

    ;
     
 public static String WrapperPosicao(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "class=\"hauptposition_[0-9]+\"";
        String er2 = "title=\"([^\"]+)\"/>";

        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }
        }
        return "Posição não encontrada";
    }

    ;
  public static String WrapperClubeA(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "Clube atual:";
        String er2 = "alt=\"([^\"]+)\"";

        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }
        }
        return "Clube não encontrado";
    }

    ;
   public static String WrapperSelecao(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "('subnavigation_spieler','click','nationalmannschaft')";
        Pattern p = Pattern.compile(er1);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return WrapperNacionalidade(nome);
            }
        }
        return "Não esteve na selecao!";
    }

    ;
  
  public static String WrapperValor(String nome) throws IOException {
        String link2 = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link2, "", "transfer.txt");

        String er1 = "<a href=\"/[a-zA-Z-]+/marktwertverlauf/spieler/[0-9]+\">([0-9,]+) <span class=\"waehrung\">(.+)</span>";
        Pattern p = Pattern.compile(er1);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1)+m.group(2);
            }
        }
        return "Valor não encontrado";
    }
  
   public static String WrapperEmpresario(String nome) throws IOException {
        String link = encontraLinkTransferProfil(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "<th>Empresários:</th>";
        String er2 = " <a href=\"/[a-zA-Z-]+/beraterfirma/berater/[0-9]+\">(.+)</a>";

        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
           String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }
        }
        return "Empresário não encontrado";
    }

    ;
  //<th>Empresários:</th>
  
  public static String WrapperRanking(String nome) throws IOException {
        String link = encontraLinkTransferValorM(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "<div class=\"zahl.*\">";
        String er2 = "([0-9.]+).*</div>";

        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }
        }
        return "Ranking não encontrado";
    }
  
  public static String WrapperRankingClube(String nome) throws IOException {
        String link = encontraLinkTransferValorM(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "<a href=\"/.+/marktwertanalyse/verein/[0-9]+\">";
        String er2 = "([0-9.]+).*</div>";

        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                m = p2.matcher(linha);
                if (m.find()) {
                    ler.close();
                    return m.group(1);
                }
            }
        }
        return "Ranking não encontrado";
    }
  
   public static ArrayList<String> WrapperPremiosInd(String nome) throws IOException {
        String link = encontraLinkTransferP(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
        String er1 = "<span class=\"headerueberschrift\">(.*)</span>";
        String premios = null;
        ArrayList<String> lista = new ArrayList();
        
        Pattern p = Pattern.compile(er1);

        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                premios = m.group(1);
                lista.add(premios);
            }
        }
        if (lista.isEmpty()) {
            String a = "Sem Premios";
            lista.add(a);
        }
        return lista;
        
    }

   public static ArrayList<String> WrapperClubesAnt(String nome) throws IOException {
        String link = encontraLinkWikiF(nome);
        HttpRequestFunctions.httpRequest1(link, "", "transfer.txt");
         String er1 = "<td><b>Club</b>";
        String er2 = "</span> <a href=\"/wiki/.+\" title=\".+\">(.+)</a>";
        String clubesant = null;
        ArrayList<String> lista = new ArrayList();
        
        Pattern p = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("transfer.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                linha = ler.nextLine();
                m = p2.matcher(linha);
                    while(m.find()){
                   clubesant=m.group(1);
                    lista.add(clubesant);
                    }
            }
        }
        if (lista.isEmpty()) {
            String a = "Sem Clubes";
            lista.add(a);
        }
        return lista;
        
    }

    /*
     String nome;
    String numero;
    String link_foto;
    String datanasc;
    String nacionalidade;
    String altura;
    String peso;
    String pe_pref;
    String posicao;
    String clube_atual;
    ArrayList clubes_anteriores;
    String selecao;
    ArrayList premios;
    String estado;
    String valor_contrato;
    String empresario;
    String ranking_tm;
     */
    public static Jogador cria_jogador(String nome) throws IOException {
        Jogador x;
        String nc = WrapperNomeCompleto(nome);
        String num = WrapperNumero(nome);
        String link = WrapperLink(nome);
        String datanasc = WrapperDatanasc(nome);
        String nacionalidade = WrapperNacionalidade(nome);
        String altura = WrapperAltura(nome);
        String peso = WrapperPeso(nome);
        String pe_pref = WrapperPePref(nome);
        String pos = WrapperPosicao(nome);
        String clube_atual = WrapperClubeA(nome);
        //ArrayList clubes_ant = WrapperClubesAnt(nome);
        String selecao = WrapperSelecao(nome);
        String valor = WrapperValor(nome);
        String empresario = WrapperEmpresario(nome);
        String ranking = WrapperRanking(nome);
        String rankingc = WrapperRankingClube(nome);
        ArrayList<String> premios = WrapperPremiosInd(nome);
        x = new Jogador(nome, nc, num, link, datanasc, nacionalidade, altura, peso, pe_pref, pos, clube_atual,selecao,valor,empresario, ranking,rankingc,premios);
        return x;
    }

}
