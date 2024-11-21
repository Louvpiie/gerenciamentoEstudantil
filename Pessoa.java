package gerenciamentoEstudantil;

abstract class Pessoa {
    protected String nome;
    protected int idade;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método abstrato
    public abstract void exibirDados();
}