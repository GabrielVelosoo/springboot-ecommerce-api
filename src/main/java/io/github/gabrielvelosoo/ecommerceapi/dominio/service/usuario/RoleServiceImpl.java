package io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Role;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario.RoleRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role obterRolePorNome(String nome) {
        return roleRepository.findByNome(nome)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Role " + nome + " nao encontrada"));
    }
}
