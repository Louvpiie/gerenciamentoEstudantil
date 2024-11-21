package gerenciamentoEstudantil;

public class Professor extends Pessoa {
    private String especialidade;

    public Professor(String nome, int idade, String especialidade) {
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
    }

    // Getters e Setters
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void exibirDados() {
        System.out.println("Professor: " + nome + ", Idade: " + idade + ", Especialidade: " + especialidade);
    }

    // Métodos de manipulação de dados (cadastro, edição, exclusão)
}
