/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

import java.util.ArrayList;

/**
 *
 * @author HyBr1d
 */
/*
nome completo do jogador
• nome pelo qual é mais conhecido
• fotografia (link)
• data de nascimento, idade
• nacionalidade
• altura
• peso
• pé preferencial
• posições onde joga
• clube atual
• clubes anteriores
• seleção nacional (se for o caso)
• prémios ganhos (taça, dat, etc)
• estado atual: ativo, reformado
• valor do contrato
• empresário
• ranking dado pelo site transfer markt
 */
public class Jogador {

    String nome;
    String nomec;
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
    String valor_contrato;
    String empresario;
    String ranking_tm;
    String ranking_clube;

    public Jogador(String nome, String nomec, String numero, String link_foto, String datanasc, String nacionalidade, String altura,String peso, String pe_pref, String posicao, String clube_atual,String selecao,String valor,String empresario, String ranking,String rankingc,ArrayList<String> premios) {
        this.nome = nome;
        this.nomec = nomec;
        this.numero = numero;
        this.link_foto = link_foto;
        this.datanasc = datanasc;
        this.nacionalidade = nacionalidade;
        this.pe_pref = pe_pref;
        this.posicao = posicao;
        this.clube_atual = clube_atual;
        this.selecao = selecao;
        this.peso = peso;
        this.altura = altura;
        this.valor_contrato = valor;
        this.empresario = empresario;
        this.ranking_tm = ranking;
        this.ranking_clube = rankingc;
        this.premios = premios;
    }

    public String getRanking_clube() {
        return ranking_clube;
    }

    public void setRanking_clube(String ranking_clube) {
        this.ranking_clube = ranking_clube;
    }
    
    

    public String getNome() {
        return nome;
    }

    public String getNomec() {
        return nomec;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLink_foto() {
        return link_foto;
    }

    public void setLink_foto(String link_foto) {
        this.link_foto = link_foto;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPe_pref() {
        return pe_pref;
    }

    public void setPe_pref(String pe_pref) {
        this.pe_pref = pe_pref;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getClube_atual() {
        return clube_atual;
    }

    public void setClube_atual(String clube_atual) {
        this.clube_atual = clube_atual;
    }

    public ArrayList getClubes_anteriores() {
        return clubes_anteriores;
    }

    public void setClubes_anteriores(ArrayList clubes_anteriores) {
        this.clubes_anteriores = clubes_anteriores;
    }

    public String getSelecao() {
        return selecao;
    }

    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }

    public ArrayList getPremios() {
        return premios;
    }

    public void setPremios(ArrayList premios) {
        this.premios = premios;
    }


    public String getValor_contrato() {
        return valor_contrato;
    }

    public void setValor_contrato(String valor_contrato) {
        this.valor_contrato = valor_contrato;
    }

    public String getEmpresario() {
        return empresario;
    }

    public void setEmpresario(String empresario) {
        this.empresario = empresario;
    }

    public String getRanking_tm() {
        return ranking_tm;
    }

    public void setRanking_tm(String ranking_tm) {
        this.ranking_tm = ranking_tm;
    }

}
