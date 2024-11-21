package gerenciamentoEstudantil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private List<Estudante> estudantes = new ArrayList<Estudante>();
    private List<Professor> professores = new ArrayList<Professor>();
    private List<Curso> cursos = new ArrayList<Curso>();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenuPrincipal() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Aluno");
            System.out.println("2. Professor");
            System.out.println("3. Curso");
            System.out.println("4. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir o enter

            switch (escolha) {
                case 1:
                    menuAluno();
                    break;
                case 2:
                    menuProfessor();
                    break;
                case 3:
                    menuCurso();
                    break;
                case 4:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void menuAluno() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\nMenu Aluno:");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Consultar aluno");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir o enter

            switch (escolha) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    consultarAluno();
                    break;
                case 3:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Métodos como cadastrarAluno(), consultarAluno() e outros podem ser desenvolvidos aqui...

    private void cadastrarAluno() {
        System.out.println("\nCadastro de Aluno:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir o enter
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        Estudante estudante = new Estudante(nome, idade, matricula);
        estudantes.add(estudante);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void consultarAluno() {
        System.out.println("\nConsulta de Aluno:");
        System.out.print("Digite o nome ou matrícula do aluno: ");
        String busca = scanner.nextLine();

        boolean encontrado = false;
        for (Estudante estudante : estudantes) {
            if (estudante.getNome().equalsIgnoreCase(busca) || estudante.getMatricula().equals(busca)) {
                encontrado = true;
                estudante.exibirDados();

                System.out.println("1. Editar");
                System.out.println("2. Excluir");
                System.out.println("3. Voltar");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir o enter

                switch (opcao) {
                    case 1:
                      System.out.println("\nEditar Aluno:");
                        System.out.print("Novo nome: ");
                        estudante.setNome(scanner.nextLine());
                        System.out.print("Nova idade: ");
                        estudante.setIdade(scanner.nextInt());
                        scanner.nextLine(); // Consumir o enter
                        System.out.println("Aluno atualizado com sucesso!");
                        break;
                    case 2:
                      estudantes.remove(estudante);
                        System.out.println("Aluno excluído com sucesso!");
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void menuProfessor() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\nMenu Professor:");
            System.out.println("1. Cadastrar professor");
            System.out.println("2. Consultar professor");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir o enter

            switch (escolha) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    consultarProfessor();
                    break;
                case 3:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarProfessor() {
        System.out.println("\nCadastro de Professor:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir o enter
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        Professor professor = new Professor(nome, idade, especialidade);
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private void consultarProfessor() {
        System.out.println("\nConsulta de Professor:");
        System.out.print("Digite o nome ou matrícula do professor: ");
        String busca = scanner.nextLine();

        boolean encontrado = false;
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(busca)) {
                encontrado = true;
                professor.exibirDados();

                System.out.println("1. Editar");
                System.out.println("2. Excluir");
                System.out.println("3. Voltar");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir o enter

                switch (opcao) {
                    case 1:
                        System.out.print("Novo nome: ");
                        professor.setNome(scanner.nextLine());
                        System.out.print("Nova especialidade: ");
                        professor.setEspecialidade(scanner.nextLine());
                        System.out.println("Professor atualizado com sucesso!");
                        break;
                    case 2:
                        professores.remove(professor);
                        System.out.println("Professor excluído com sucesso!");
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Professor não encontrado.");
        }
    }

    public void menuCurso() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\nMenu Curso:");
            System.out.println("1. Cadastrar curso");
            System.out.println("2. Consultar curso");
            System.out.println("3. Vincular alunos ou professores");
            System.out.println("4. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir o enter

            switch (escolha) {
                case 1:
                    cadastrarCurso();
                    break;
                case 2:
                    consultarCurso();
                    break;
                case 3:
                    vincular();
                    break;
                case 4:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarCurso() {
        System.out.println("\nCadastro de Curso:");
        System.out.print("Nome do curso: ");
        String nomeCurso = scanner.nextLine();
        System.out.print("Carga horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine(); // Consumir o enter

        System.out.println("Escolha o professor responsável:");
        for (int i = 0; i < professores.size(); i++) {
            System.out.println((i + 1) + ". " + professores.get(i).getNome());
        }

        int professorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir o enter

        if (professorIndex >= 0 && professorIndex < professores.size()) {
            Curso curso = new Curso(nomeCurso, cargaHoraria, professores.get(professorIndex));
            cursos.add(curso);
            System.out.println("Curso cadastrado com sucesso!");
        } else {
            System.out.println("Professor inválido.");
        }
    }

    private void consultarCurso() {
        System.out.println("\nConsulta de Curso:");
        System.out.print("Digite o nome do curso: ");
        String busca = scanner.nextLine();

        boolean encontrado = false;
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equalsIgnoreCase(busca)) {
                encontrado = true;
                System.out.println("Curso: " + curso.getNomeCurso());
                System.out.println("Carga Horária: " + curso.getCargaHoraria());
                System.out.println("Professor Responsável: " + curso.getProfessor().getNome());

                System.out.println("1. Editar");
                System.out.println("2. Excluir");
                System.out.println("3. Voltar");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir o enter

                switch (opcao) {
                    case 1:
                        System.out.print("Novo nome do curso: ");
                        curso.setNomeCurso(scanner.nextLine());
                        System.out.print("Nova carga horária: ");
                        curso.setCargaHoraria(scanner.nextInt());
                        scanner.nextLine(); // Consumir o enter
                        System.out.println("Curso atualizado com sucesso!");
                        break;
                    case 2:
                        cursos.remove(curso);
                        System.out.println("Curso excluído com sucesso!");
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Curso não encontrado.");
        }
    }

    private void vincular() {
        System.out.println("\nVinculação de Estudantes ou Professores:");
        System.out.println("1. Matricular Estudantes");
        System.out.println("2. Associar Professores");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir o enter

        switch (escolha) {
            case 1:
                matricularEstudantes();
                break;
            case 2:
                associarProfessores();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void matricularEstudantes() {
        System.out.println("\nEscolha o curso para matrícula:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNomeCurso());
        }

        int cursoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir o enter

        if (cursoIndex >= 0 && cursoIndex < cursos.size()) {
            cursos.get(cursoIndex);

            System.out.println("Escolha o estudante para matrícula:");
            for (int i = 0; i < estudantes.size(); i++) {
                System.out.println((i + 1) + ". " + estudantes.get(i).getNome());
            }

            int estudanteIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir o enter

            if (estudanteIndex >= 0 && estudanteIndex < estudantes.size()) {
                // Lógica de matrícula (associar estudante ao curso)
                System.out.println("Estudante matriculado com sucesso!");
            } else {
                System.out.println("Estudante inválido.");
            }
        } else {
            System.out.println("Curso inválido.");
        }
    }

    private void associarProfessores() {
        System.out.println("\nEscolha o curso para associar um professor:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNomeCurso());
        }

        int cursoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir o enter

        if (cursoIndex >= 0 && cursoIndex < cursos.size()) {
            Curso curso = cursos.get(cursoIndex);

            System.out.println("Escolha o professor:");
            for (int i = 0; i < professores.size(); i++) {
                System.out.println((i + 1) + ". " + professores.get(i).getNome());
            }

            int professorIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir o enter

            if (professorIndex >= 0 && professorIndex < professores.size()) {
                curso.setProfessor(professores.get(professorIndex));
                System.out.println("Professor associado com sucesso!");
            } else {
                System.out.println("Professor inválido.");
            }
        } else {
            System.out.println("Curso inválido.");
        }
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.exibirMenuPrincipal();
    }
}