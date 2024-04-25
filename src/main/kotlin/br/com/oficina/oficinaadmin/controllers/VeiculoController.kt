package br.com.oficina.oficinaadmin.controllers

import br.com.oficina.oficinaadmin.modelos.DadosCadastroVeiculo
import br.com.oficina.oficinaadmin.exceptions.CadastroInvalidoException
import br.com.oficina.oficinaadmin.services.UsuarioService
import br.com.oficina.oficinaadmin.services.VeiculoService
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/veiculo")
class VeiculoController(
    private val service: VeiculoService,
    private val usuarioService: UsuarioService
) {
    @GetMapping
    fun index(model: Model, @RequestParam(name = "cadastroSuccess", required = false) cadastroSuccess: Boolean) : String {
        if(cadastroSuccess) {
            model.addAttribute("cadastroSuccess", "Veículo cadastrado com sucesso")
        }

        model.addAttribute("veiculos", service.getAll())

        return "veiculo/index"
    }

    @GetMapping("/cadastro")
    fun formularioDeCadastro(model: Model, request: HttpServletRequest): String {
        model.addAttribute("dadosCadastroVeiculo", DadosCadastroVeiculo("", "", 0))
        model.addAttribute("usuarios", usuarioService.getAll())

        return "veiculo/cadastro"
    }

    @PostMapping("/cadastro")
    fun cadastrar(
        @Valid @ModelAttribute dadosCadastro: DadosCadastroVeiculo,
        usuarioId: Long,
        bindingResult: BindingResult,
        model: Model,
        request: HttpServletRequest
    ): String {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dadosCadastroVeiculo", dadosCadastro)
            return "veiculo/cadastro"
        }

        try {
            this.service.cadastrar(dadosCadastro, usuarioId)
        } catch (ex: CadastroInvalidoException) {
            model.addAttribute("erroDeCadastro", ex.message)
            return "veiculo/cadastro"
        }

        return "redirect:/veiculo?cadastroSuccess=true"
    }
}