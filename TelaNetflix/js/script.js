let hideModal = () => {

    let modal = document.querySelector(".modal");
    modal.remove();

}

let getBtnClose = () => {

    let btnClose = document.createElement("DIV");
    btnClose.classList.add("close");
    btnClose.innerHTML = "X";

    return btnClose;
}

let getModal = () => {

    let modal = document.createElement("DIV");
    modal.classList.add("modal");
    modal.append(getBtnClose());

    return modal;
}

let showTrailer = () => {
    let modal = getModal();
    modal.innerHTML += '<iframe width = "700" height = "400" src = "https://www.youtube.com/embed/HwPaUiMuTVg" title = "YouTube video player" frameborder = "0" allow = "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen > < /iframe>'

    document.body.appendChild(modal);
    document.querySelector(".close").addEventListener('click', hideModal);

}

let showDetails = () => {
    let modal = getModal();
    let container = document.createElement("DIV");
    let img = document.createElement("IMG");
    img.src = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/m1JxuEwEufGqNAPJj7Tbk2pYGqh.jpg";
    let article = document.createElement("ARTICLE");
    article.innerHTML = `
    <h3>Um Homem Comum (2018)</h3>
    <ul>
    <li>Classificação: 14 anos</li>
    <li>Lançamento no Brasil: 29/11/2018 (BR)</li>
    <li>Gênero: Ação, Drama, Guerra </li>
    <li>Duração: 1h 30m</li>
    <li onclick="hideModal(showTrailer())">Reproduzir trailer</li>
    </ul>
    <h4>Sinopse</h4>
    <p>A história segue um criminoso de guerra na clandestinidade (Kingsley), que inicia um relacionamento com sua empregada, uma atriz islandesa em ascensão. Quando as buscas para o encontrarem ficam mais intensas, ele percebe que ela é única pessoa em que pode confiar.</p>
    <h3>Brad Silberling</h3>Director, Writer`;
    container.appendChild(img);
    container.appendChild(article);
    modal.appendChild(container);

    document.body.appendChild(modal);
    document.querySelector(".close").addEventListener('click', hideModal);
}

$('.owl-carousel').owlCarousel({
    loop: false,
    margin: 10,
    nav: false,
    responsive: {
        0: {
            items: 1
        },
        600: {
            items: 3
        },
        1000: {
            items: 5
        }
    }
})