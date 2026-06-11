package github.gustavoaraujopires.demo.repository;

import github.gustavoaraujopires.demo.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
