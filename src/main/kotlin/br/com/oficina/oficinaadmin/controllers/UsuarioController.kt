package br.com.oficina.oficinaadmin.controllers

import br.com.oficina.oficinaadmin.exceptions.CadastroInvalidoException
import br.com.oficina.oficinaadmin.modelos.DadosCadastro
import br.com.oficina.oficinaadmin.services.UsuarioService
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/usuario")
class UsuarioController(
    private val service: UsuarioService
) {

    @GetMapping
    fun index(model: Model, @RequestParam(name = "cadastroSuccess", required = false) cadastroSuccess: Boolean): String {
        if(cadastroSuccess) {
            model.addAttribute("cadastroSuccess", "Usuário cadastrado com sucesso")
        }

        model.addAttribute("usuarios", service.getAll())
        return "usuario/index"
    }

    @GetMapping("/cadastro")
    fun cadastro(model: Model, ): String {
        model.addAttribute(
            "dadosCadastro", DadosCadastro(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                0
            )
        )

        return "usuario/cadastro"
    }

    @PostMapping("/cadastro")
    fun cadastrar(
        @Valid @ModelAttribute dados: DadosCadastro,
        bindingResult: BindingResult,
        model: Model,
        request: HttpServletRequest
    ): String {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dadosCadastro", dados)
            return "usuario/cadastro"
        }

        try {
            this.service.cadastrar(dados)
        } catch (ex: CadastroInvalidoException) {
            model.addAttribute("erroDeCadastro", ex.message)
            return "usuario/cadastro"
        }

        return "redirect:/usuario?cadastroSuccess=true"
    }
}