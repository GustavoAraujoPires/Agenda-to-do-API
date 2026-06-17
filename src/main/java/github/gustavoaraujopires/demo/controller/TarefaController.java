package github.gustavoaraujopires.demo.controller;

import github.gustavoaraujopires.demo.controller.DTO.TarefaDTO;
import github.gustavoaraujopires.demo.controller.mappers.TarefaMapper;
import github.gustavoaraujopires.demo.model.Tarefa;
import github.gustavoaraujopires.demo.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('USUARIO')")
    public Tarefa salvar(@RequestBody  @Valid TarefaDTO dto){
        var tarefa = mapper.toDTO(dto);
        return service.salvarTarefa(tarefa);
    }

    @PatchMapping("{id}")
    @PreAuthorize("hasRole('USUARIO')")
    public void concluir (@PathVariable Long id){
        service.concluirTarefa(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADM')")
    public List<Tarefa> buscarTodos(){
        return service.buscarTodasTarefas();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('USUARIO')")
    public Tarefa buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('USUARIO')")
    public Tarefa atualizar(@RequestBody @Valid Tarefa tarefa, @PathVariable Long id){
        return service.atualizar(id, tarefa);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
         return service.deletar(id);
    }
}
