package br.com.oficina.oficinaadmin.repositorys

import br.com.oficina.oficinaadmin.modelos.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}