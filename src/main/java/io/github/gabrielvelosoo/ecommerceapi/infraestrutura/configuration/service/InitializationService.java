package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.configuration.service;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Role;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.UsuarioRole;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario.RoleRepository;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario.UsuarioRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void initRolesAndAdminUser() {
        if(roleRepository.findByNome("ADMIN").isEmpty()) {
            roleRepository.save(new Role("ADMIN", "Usuário com permissões administrativas. Tem acesso total ao sistema, podendo realizar o CRUD de todos os recursos, além de gerenciar usuários, permissões e configurações da aplicação."));
        }

        if(roleRepository.findByNome("USER").isEmpty()) {
            roleRepository.save(new Role("USER", "Usuário padrão do sistema. Possui acesso restrito às funcionalidades voltadas ao uso regular da aplicação, limitado às ações permitidas para o seu próprio perfil."));
        }

        String email = "ecommerceadmin@gmail.com";

        if(usuarioRepository.findByEmail(email).isEmpty()) {
            Role adminRole = roleRepository.findByNome("ADMIN")
                    .orElseThrow(() -> new RegistroNaoEncontradoException("Role não encontrada"));

            adminRole = entityManager.merge(adminRole);

            Usuario admin = new Usuario();
            admin.setEmail(email);
            admin.setSenha(passwordEncoder.encode("ecommerceadmin@123"));

            UsuarioRole usuarioRole = new UsuarioRole();
            usuarioRole.setUsuario(admin);
            usuarioRole.setRole(adminRole);

            admin.getUsuarioRoles().add(usuarioRole);

            usuarioRepository.save(admin);
        }
    }
}
