package ifpb.edu.br.entidades;

import java.util.List;
import java.util.Objects;

public class Professor {
    private String matricula;
    private String nome;
    private String senha;
    protected List<Disciplina> disciplinas;

    public Professor(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina disciplinas) {
        this.disciplinas = (List<Disciplina>) disciplinas;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return getNome() + " " + getMatricula();
    }

    public Object getLogin(){
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor professor)) return false;
        return Objects.equals(getMatricula(), professor.getMatricula());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula());
    }
}

