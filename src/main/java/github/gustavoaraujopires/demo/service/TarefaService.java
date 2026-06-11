package github.gustavoaraujopires.demo.service;

import github.gustavoaraujopires.demo.exception.TarefaNaoEncontradaException;
import github.gustavoaraujopires.demo.model.Tarefa;
import github.gustavoaraujopires.demo.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;

    public Tarefa salvarTarefa(Tarefa tarefa){
        return repository.save(tarefa);
    }

    public List<Tarefa> buscarTodasTarefas(){
        return repository.findAll();
    }

    public Tarefa buscarPorId (Long id){
        return repository.findById(id).orElseThrow(() -> new TarefaNaoEncontradaException("id não encontrado"));
    }

    public Tarefa atualizar (Long id){
       var Tarefa = repository.findById(id).orElseThrow(()-> new TarefaNaoEncontradaException("Id não encontrado"));
        if (Tarefa != null){
               Tarefa.setTitulo(Tarefa.getTitulo());
               Tarefa.setDescricao(Tarefa.getDescricao());
               Tarefa.setDataLimite(Tarefa.getDataLimite());
            return repository.save(Tarefa);

        }

        return null;

    }

    public Void 

}
