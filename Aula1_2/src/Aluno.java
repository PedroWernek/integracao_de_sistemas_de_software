import java.util.Set;

public class Aluno {
    private final String id;
    private final String nome;
    private Set<Curso> cursos;

    public Aluno(String id, String nome, Set<Curso> cursos) {
        this.id = id;
        this.nome = nome;
        this.cursos = cursos;
    }

    public void adicionarCursos(Curso curso){
        cursos.add(curso);
    }
}
