document.addEventListener("DOMContentLoaded", () => {
    const links = document.querySelectorAll("a");

    links.forEach(link => {
        if (link.href === window.location.href) {
            link.classList.add("font-bold", "opacity-100");
        }
    })
});