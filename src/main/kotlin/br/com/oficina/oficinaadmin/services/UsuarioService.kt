package br.com.oficina.oficinaadmin.services

import br.com.oficina.oficinaadmin.extensions.toUsuario
import br.com.oficina.oficinaadmin.extensions.toVeiculo
import br.com.oficina.oficinaadmin.modelos.DadosCadastro
import br.com.oficina.oficinaadmin.modelos.Usuario
import br.com.oficina.oficinaadmin.repositorys.UsuarioRepository
import br.com.oficina.oficinaadmin.repositorys.VeiculoRepository
import br.com.oficina.oficinaadmin.services.validations.Validation
import org.springframework.stereotype.Service
import org.springframework.security.crypto.password.PasswordEncoder

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val veiculoRepository: VeiculoRepository,
    private val validacoes: List<Validation>,
    private val passwordEncoder: PasswordEncoder
) {

    fun getAll(): List<Usuario> {
        return repository.findAll().toList()
    }

    fun cadastrar(dados: DadosCadastro) {
            validacoes.forEach { it.validar(dados) }

            val usuario = repository.save(dados.toUsuario(passwordEncoder))
            val veiculo = dados.toVeiculo(usuario)
            val veiculoSalvo = veiculoRepository.save(veiculo)

            usuario.veiculos.add(veiculoSalvo)
            repository.save(usuario)
    }

}