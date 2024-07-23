package tarefas.api.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tarefas.api.entity.Tarefa;
import tarefas.api.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {
    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> create(Tarefa tarefa) {
        tarefaRepository.save(tarefa);

        return list();
    }

    public List<Tarefa> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );

        return tarefaRepository.findAll(sort);
    }

    public List<Tarefa> update(Tarefa tarefa) {
        tarefaRepository.save(tarefa);

        return list();
    }

    public List<Tarefa> delete(Long id) {
        tarefaRepository.deleteById(id);

        return list();
    }
}
