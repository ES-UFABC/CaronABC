const botaoMenu = document.querySelector('.cabecalho__menu');
const menu = document.querySelector('.menu_lateral');


botaoMenu.addEventListener('click', () => {
    menu.classList.toggle('menu-lateral--ativo')
})
