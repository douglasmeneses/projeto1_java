package org.example.projeto1.services;

import lombok.RequiredArgsConstructor;
import org.example.projeto1.models.entities.Usuario;
import org.example.projeto1.models.dto.UsuarioDTO;
import org.example.projeto1.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario getUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id); //SELECT * FROM usuario WHERE id = ?
        if (usuarioOptional.isEmpty()) { //verifico se o valor é null
            throw new RuntimeException("Usuário não encontrado");
        }
        return usuarioOptional.get();
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();   //SELECT * FROM usuario
    }

    public void createUsuario(UsuarioDTO usuarioDTO) {
        Usuario novoUsuario = new Usuario(usuarioDTO.getNome(), usuarioDTO.getEmail(), usuarioDTO.getSenha());
        usuarioRepository.save(novoUsuario); //INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)
    }
}
