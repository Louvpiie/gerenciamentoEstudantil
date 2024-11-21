package gerenciamentoEstudantil;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nomeCurso;
    private int cargaHoraria;
    private Professor professor;

    public Curso(String nomeCurso, int cargaHoraria, Professor professor) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    // Getters e Setters
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    private List<Estudante> estudantesMatriculados = new ArrayList<>();

    public void matricularEstudante(Estudante estudante) {
        estudantesMatriculados.add(estudante);
    }

    public List<Estudante> getEstudantesMatriculados() {
        return estudantesMatriculados;
    }


    // Métodos de manipulação de cursos
}