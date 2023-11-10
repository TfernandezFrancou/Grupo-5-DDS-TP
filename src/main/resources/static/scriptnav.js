document.getElementById('close-menu').addEventListener('click', function () {
    document.getElementById('mySidenav').style.width = '0';
});
document.getElementById('toggle-menu').addEventListener('click', function () {
    const sidenav = document.getElementById('mySidenav');
    const content = document.getElementsByClassName('content')[0];
    const menuLinks = document.getElementById('menu-links');

    if (sidenav.style.width === '0px' || sidenav.style.width === '') {
        sidenav.style.width = '250px';
        content.classList.add('opened');
        menuLinks.style.display = 'block'; // Mostrar los enlaces cuando el menú se abre
    } else {
        sidenav.style.width = '0';
        content.classList.remove('opened');
        menuLinks.style.display = 'none'; // Ocultar los enlaces cuando el menú se cierra
    }
});

