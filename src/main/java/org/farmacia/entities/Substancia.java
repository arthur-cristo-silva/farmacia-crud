package org.farmacia.entities;
// aqui é a classe de Substancia no qual se criara o objeto
public class Substancia {
    public Tipo meuTipo;
    public String nome_substancia;
    // o seu contrutor que cria o objeto
    public Substancia(Tipo tipo, String nome) {
        this.meuTipo = tipo;
        this.nome_substancia = nome;
    }

    // os get e setter que são utilizados para manipular os atributos do objeto
    public Tipo getMeuTipo() {
        return meuTipo;
    }

    public void setMeuTipo(Tipo meuTipo) {
        this.meuTipo = meuTipo;
    }

    public String getNome() {
        return nome_substancia;
    }

    public void setNome(String nome) {
        this.nome_substancia = nome;
    }

    // trata a resposta , trazendo  os atributos do objeto
    @Override
    public String toString() {
        return "Substancia{" +
                "meuTipo=" + meuTipo +
                ", nome_substancia='" + nome_substancia + '\'' +
                '}';
    }
}
