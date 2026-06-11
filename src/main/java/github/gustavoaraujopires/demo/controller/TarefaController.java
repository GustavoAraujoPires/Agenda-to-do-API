package github.gustavoaraujopires.demo.controller;

import github.gustavoaraujopires.demo.controller.DTO.TarefaDTO;
import github.gustavoaraujopires.demo.controller.mappers.TarefaMapper;
import github.gustavoaraujopires.demo.model.Tarefa;
import github.gustavoaraujopires.demo.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;
    private final TarefaMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa salvar(@RequestBody  @Valid TarefaDTO dto){
        var tarefa = mapper.toDTO(dto);
        return service.salvarTarefa(tarefa);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Tarefa> buscarTodos(){
        return service.buscarTodasTarefas();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa atualizar(@RequestBody @Valid Tarefa tarefa, @PathVariable Long id){
        return service.atualizar(id, tarefa);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
