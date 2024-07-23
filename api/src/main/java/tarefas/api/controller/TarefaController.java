package tarefas.api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import tarefas.api.entity.Tarefa;
import tarefas.api.service.TarefaService;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    List<Tarefa> create(@RequestBody @Valid Tarefa tarefa) {
        return tarefaService.create(tarefa);
    }

    @GetMapping
    List<Tarefa> list() {
        return tarefaService.list();
    }

    @PutMapping
    List<Tarefa> update(@RequestBody Tarefa tarefa) {
        return tarefaService.update(tarefa);
    }

    @DeleteMapping("{id}")
    List<Tarefa> delete(@PathVariable("id") Long id) {
        return tarefaService.delete(id);
    }

}
