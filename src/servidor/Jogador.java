/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author estagiario
 */
public class Jogador {

    private int id;

    private String nome;

    private int palitos;

    private int aposta;
    
    public int aberto;
    
    public Jogador(){
        
    }

    public Jogador(String nome,int palitos,int aposta) {
        
        this.nome = nome;
        this.palitos =palitos;
        this.aposta = aposta;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPalitos() {
        return palitos;
    }

    public void setPalitos(int palitos) {
        this.palitos = palitos;
    }

    public int getAposta() {
        return aposta;
    }

    public void setAposta(int aposta) {
        this.aposta = aposta;
    }

    public int getAberto() {
        return aberto;
    }

    public void setAberto(int aberto) {
        this.aberto = aberto;
    }
    
    

}
