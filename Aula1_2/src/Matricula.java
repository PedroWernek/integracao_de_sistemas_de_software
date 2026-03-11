import java.util.Map;

public class Matricula {
    Map<String, Aluno> matriculas;

    public void addMatricula(String id,Aluno aluno){
        matriculas.put(id, aluno);
    }
}
