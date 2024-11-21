package gerenciamentoEstudantil;

public class Estudante extends Pessoa {
    private String matricula;

    public Estudante(String nome, int idade, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void exibirDados() {
        System.out.println("Aluno: " + nome + ", Idade: " + idade + ", Matrícula: " + matricula);
    }

    // Métodos de manipulação de dados (cadastro, edição, exclusão)
}