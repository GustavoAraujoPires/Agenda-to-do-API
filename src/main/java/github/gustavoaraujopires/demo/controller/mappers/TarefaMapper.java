package github.gustavoaraujopires.demo.controller.mappers;

import github.gustavoaraujopires.demo.controller.DTO.TarefaDTO;
import github.gustavoaraujopires.demo.model.Tarefa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    Tarefa toDTO(TarefaDTO dto);
    TarefaDTO toEntity(Tarefa tarefa);
}
