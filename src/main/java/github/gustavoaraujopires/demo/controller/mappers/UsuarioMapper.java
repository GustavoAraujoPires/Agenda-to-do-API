package github.gustavoaraujopires.demo.controller.mappers;

import github.gustavoaraujopires.demo.controller.DTO.UsuarioDTO;
import github.gustavoaraujopires.demo.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toDTO (UsuarioDTO dto);
    UsuarioDTO toEntity (Usuario usuario);
}
