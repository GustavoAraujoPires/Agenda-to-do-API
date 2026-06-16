package github.gustavoaraujopires.demo.service;

import github.gustavoaraujopires.demo.exception.IdNaoEncontradoException;
import github.gustavoaraujopires.demo.exception.StatusInvalidoException;
import github.gustavoaraujopires.demo.model.StatusTarefa;
import github.gustavoaraujopires.demo.model.Tarefa;
import github.gustavoaraujopires.demo.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;

    public Tarefa salvarTarefa(Tarefa tarefa){
        tarefa.setStatusTarefa(StatusTarefa.PENDENTE);
        return repository.save(tarefa);
    }

    public void concluirTarefa (Long id){
        var idTarefa = repository.findById(id).orElseThrow(()-> new IdNaoEncontradoException("id não encontrado"));
        if (idTarefa.getStatusTarefa() == StatusTarefa.CONCLUIDA){
            throw new StatusInvalidoException("Tarefa já está concluida !!");
        }
        idTarefa.setStatusTarefa(StatusTarefa.CONCLUIDA);
        repository.save(idTarefa);
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

    public ResponseEntity<Void> deletar(Long id) {
        var idDeletar = repository.findById(id);
       if (idDeletar.isPresent()){
           repository.deleteById(id);
           return ResponseEntity.ok().build();
       }
        throw new IdNaoEncontradoException("Id não encontrado");

    }

}
