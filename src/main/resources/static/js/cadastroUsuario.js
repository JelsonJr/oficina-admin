function formatarCampoCpf(valor) {
    return valor.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
}

document.addEventListener("DOMContentLoaded", () => {
    const campoCPF = document.getElementById("cpf");
    const campoPlaca = document.getElementById("placa")

    campoCPF.addEventListener("input", (e) => {
        const valorAtual = e.target.value.replace(/\D/g, '');
        e.target.value = formatarCampoCpf(valorAtual);
    });

    campoPlaca.addEventListener("input", (e) => {
        const valorAtual = e.target.value.toUpperCase();
        e.target.value = valorAtual.replace(/[^A-Z0-9]/g, '');
    });
});
