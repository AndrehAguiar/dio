const IMG_PATH = "./img/";
const main = document.querySelector('.memory-game');
const list = [1, 2, 3, 4, 5, 6, 7, 8];

let score = 0;
let hasFlipped = lockBoard = false;
let firstCard, secondCard, listSorted;

const sortCards = (list) => {
    return list.sort(() => Math.random() - 0.5);
}

const createDiv = () => {
    let div = document.createElement("DIV");
    div.classList.add("card");
    div.addEventListener('click', flipCard);
    main.appendChild(div);
}

const createCardBack = () => {
    let cardBack = document.createElement("IMG");
    cardBack.src = `${IMG_PATH}card_bg.jpg`;
    cardBack.classList.add('card-back');
    return cardBack;
}

const createCardFront = (el, idx, arr) => {
    let cardFront = document.createElement("IMG");
    cardFront.src = `${IMG_PATH}card_${listSorted[idx]}.jpg`;
    cardFront.classList.add('card-front');
    cardFront.classList.add('hidden');
    arr[idx].setAttribute('data-card', listSorted[idx]);
    arr[idx].appendChild(cardFront);
    arr[idx].appendChild(createCardBack());
}

const createCard = () => {
    for (let i = 0; i < 2; i++) {
        list.forEach(createDiv);
    }
    const dvCard = document.querySelectorAll(".card");
    dvCard.forEach(createCardFront);
    dvCard.forEach(createCardBack);
}

const showHideCard = (el, flag = false) => {
    let time = 220;
    if (flag) {
        time = 1750;
    }
    if (!el.classList.contains("flip") || flag) {
        setTimeout(() => {
            el.childNodes.forEach(el => el.classList.toggle("hidden"));
            enableDisableCards(el);
        }, time)
    }
}

const enableDisableCards = (el) => {
    if (el.classList.contains('flip')) {
        el.removeEventListener('click', flipCard);
        return;
    }
    el.addEventListener('click', flipCard);
}

const chkCardMatch = () => {
    if (firstCard.dataset.card === secondCard.dataset.card) {
        enableDisableCards(firstCard);
        enableDisableCards(secondCard);
        score++;
        chkFinish();
        return;
    }
    unflipCards();
    showHideCard(firstCard, true);
    showHideCard(secondCard, true);
}

const flipCard = (event) => {
    if (lockBoard) return;
    let el = event.target.parentNode;
    showHideCard(el);
    el.classList.add("flip");
    if (!hasFlipped) {
        hasFlipped = true;
        firstCard = el;
        return;
    }
    secondCard = el;
    hasFlipped = false;
    chkCardMatch();
}

const unflipCards = () => {
    lockBoard = true;
    setTimeout(() => {
        firstCard.classList.remove('flip');
        secondCard.classList.remove('flip');
        resetBoard();
    }, 1500);
}

const resetBoard = () => {
    [hasFlipped, lockBoard] = [false, false];
    [firstCard, secondCard] = [null, null];
}

const chkFinish = () => {
    const cards = document.querySelectorAll('.card');
    console.log(score);
    if (score < cards.length / 2) return;
    setTimeout(() => {
        cards.forEach(el => {
            el.classList.remove('flip');
            showHideCard(el);
            setTimeout(() => {
                main.removeChild(el);
            }, 1200)
        });
        startGame(true);
    }, 5000)
}

const startGame = (flag = false) => {
    let time = flag ? 1200 : 0;
    setTimeout(() => {
        listSorted = sortCards([...sortCards(list), ...sortCards(list)]);
        createCard();
    }, time)
}

window.addEventListener('load', startGame(false));