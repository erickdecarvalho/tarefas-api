package tarefas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tarefas.api.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
