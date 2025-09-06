package org.example.projeto1.services;

import lombok.RequiredArgsConstructor;
import org.example.projeto1.models.dto.UsuarioDTO;
import org.example.projeto1.models.dto.UsuarioPublicoDTO;
import org.example.projeto1.models.entities.Usuario;
import org.example.projeto1.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id); //SELECT * FROM usuario WHERE id = ?
    }

    private UsuarioPublicoDTO criaUsuarioPublico(Usuario usuario) {
        return new UsuarioPublicoDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }

    public ResponseEntity<?> retornaUsuario(Long id) {
        Optional<Usuario> usuarioEncontrado = findUsuarioById(id);
        return usuarioEncontrado.isEmpty()
                ? ResponseEntity.badRequest().body("Usuário não cadastrado")
                : ResponseEntity.ok(criaUsuarioPublico(usuarioEncontrado.get()));
    }

    public List<UsuarioPublicoDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll(); //SELECT * FROM usuario
        List<UsuarioPublicoDTO> usuariosPublicos = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            UsuarioPublicoDTO usuarioPublicoDTO = criaUsuarioPublico(usuario);
            usuariosPublicos.add(usuarioPublicoDTO);
        }

        return usuariosPublicos;
    }

    public void createUsuario(UsuarioDTO usuarioDTO) {
        Usuario novoUsuario = new Usuario(usuarioDTO.getNome(), usuarioDTO.getEmail(), usuarioDTO.getSenha());
        usuarioRepository.save(novoUsuario); //INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)
    }

    public void deletaUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public ResponseEntity<?> atualizaUsuario(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioEncontrado = findUsuarioById(id);

        if (usuarioEncontrado.isEmpty()) {
            System.out.println("Usuário não encontrado");
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }

        Usuario usuario = usuarioEncontrado.get();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuarioRepository.save(usuario);

        return ResponseEntity.ok(criaUsuarioPublico(usuario));
    }
}
