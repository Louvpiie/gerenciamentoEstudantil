package gerenciamentoEstudantil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
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
            System.out.println("4. Relatórios");
            System.out.println("5. Sair");
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
                    menuRelatorios();
                    break;
                case 5:
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
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        Professor professor = new Professor(nome, idade, especialidade, matricula);
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }


    private void consultarProfessor() {
        System.out.println("\nConsulta de Professor:");
        System.out.print("Digite o nome ou matrícula do professor: ");
        String busca = scanner.nextLine();

        boolean encontrado = false;
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(busca) || professor.getMatricula().equalsIgnoreCase(busca)) {
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
                        scanner.nextLine();
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
            System.out.println("4. Desvincular aluno");
            System.out.println("5. Sair");
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
                    desvincularAluno();
                    break;
                case 5:
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

            // Verificar se o curso já tem um professor associado
            if (curso.getProfessor() != null) {
                System.out.println("Este curso já tem um professor associado: " + curso.getProfessor().getNome());
                System.out.println("Deseja substituir o professor? (S/N)");
                String resposta = scanner.nextLine().trim();

                if (!resposta.equalsIgnoreCase("S")) {
                    System.out.println("Operação cancelada.");
                    return;
                }
            }

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

    
    private void desvincularAluno() {
        System.out.println("\nEscolha o curso do qual deseja desvincular um aluno:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNomeCurso());
        }

        int cursoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir o enter

        if (cursoIndex >= 0 && cursoIndex < cursos.size()) {
            Curso curso = cursos.get(cursoIndex);

            List<Estudante> estudantesMatriculados = curso.getEstudantesMatriculados();
            if (estudantesMatriculados.isEmpty()) {
                System.out.println("Nenhum aluno matriculado neste curso.");
                return;
            }

            System.out.println("\nAlunos matriculados neste curso:");
            for (int i = 0; i < estudantesMatriculados.size(); i++) {
                System.out.println((i + 1) + ". " + estudantesMatriculados.get(i).getNome());
            }

            System.out.print("\nEscolha o aluno a ser desvinculado: ");
            int alunoIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir o enter

            if (alunoIndex >= 0 && alunoIndex < estudantesMatriculados.size()) {
                Estudante estudante = estudantesMatriculados.get(alunoIndex);
                estudantesMatriculados.remove(estudante);
                System.out.println("Aluno " + estudante.getNome() + " foi desvinculado do curso " + curso.getNomeCurso() + " com sucesso!");
            } else {
                System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Curso inválido.");
        }
    }
    
    private void menuRelatorios() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\nRelatórios:");
            System.out.println("1. Lista de alunos");
            System.out.println("2. Lista de professores");
            System.out.println("3. Lista de cursos");
            System.out.println("4. Voltar");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir o enter

            switch (escolha) {
                case 1:
                    exibirRelatorioAlunos();
                    break;
                case 2:
                    exibirRelatorioProfessores();
                    break;
                case 3:
                    exibirRelatorioCursos();
                    break;
                case 4:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void exibirRelatorioAlunos() {
        System.out.println("\nLista de Alunos:");
        if (estudantes.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Estudante estudante : estudantes) {
            System.out.println("- Nome: " + estudante.getNome() + ", Idade: " + estudante.getIdade() + ", Matrícula: " + estudante.getMatricula());
            List<Curso> cursosDoEstudante = new ArrayList<>();
            for (Curso curso : cursos) {
                if (curso.getEstudantesMatriculados().contains(estudante)) {
                    cursosDoEstudante.add(curso);
                }
            }
            if (cursosDoEstudante.isEmpty()) {
                System.out.println("  Cursos: Nenhum curso associado.");
            } else {
                System.out.println("  Cursos: " + cursosDoEstudante.stream().map(Curso::getNomeCurso).toList());
            }
        }
    }

    private void exibirRelatorioProfessores() {
        System.out.println("\nLista de Professores:");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }
        for (Professor professor : professores) {
            System.out.println("- Nome: " + professor.getNome() + ", Idade: " + professor.getIdade() + 
                               ", Especialidade: " + professor.getEspecialidade() + ", Matrícula: " + professor.getMatricula());
            List<Curso> cursosDoProfessor = new ArrayList<>();
            for (Curso curso : cursos) {
                if (curso.getProfessor().equals(professor)) {
                    cursosDoProfessor.add(curso);
                }
            }
            if (cursosDoProfessor.isEmpty()) {
                System.out.println("  Cursos: Nenhum curso associado.");
            } else {
                System.out.println("  Cursos: " + cursosDoProfessor.stream().map(Curso::getNomeCurso).toList());
            }
        }
    }

    private void exibirRelatorioCursos() {
        System.out.println("\nLista de Cursos:");
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }
        for (Curso curso : cursos) {
            System.out.println("- Curso: " + curso.getNomeCurso() + ", Carga Horária: " + curso.getCargaHoraria());
            System.out.println("  Professor: " + (curso.getProfessor() != null ? curso.getProfessor().getNome() : "Nenhum professor associado."));
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.exibirMenuPrincipal();
    }
}