package github.gustavoaraujopires.demo.service;

import github.gustavoaraujopires.demo.exception.IdNaoEncontradoException;
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
        return repository.findById(id).orElseThrow(() -> new IdNaoEncontradoException("id não encontrado"));
    }

    public Tarefa atualizar (Long id, Tarefa  tarefaAtualizada) {
        var Tarefa = repository.findById(id).orElseThrow(() -> new IdNaoEncontradoException("Id não encontrado"));
        if (Tarefa == null) {
            throw new IdNaoEncontradoException("Id não encontrado");
        }
            Tarefa.setTitulo(tarefaAtualizada.getTitulo());
            Tarefa.setDescricao(tarefaAtualizada.getDescricao());
            Tarefa.setDataLimite(tarefaAtualizada.getDataLimite());
            return repository.save(Tarefa);
    }


    public void deletar(Long id) {
        if (id != null) {
            repository.deleteById(id);
        }
        throw new IdNaoEncontradoException("id não encontrado");
    }

}
