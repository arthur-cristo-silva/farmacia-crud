package org.farmacia.entities;
// aqui é a classe de Substancia no qual se criara o objeto
public class Substancia {
    public Tipo tipo;
    public String nome;
    // o seu contrutor que cria o objeto
    public Substancia(Tipo tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + " ("+tipo+")";
    }
}
