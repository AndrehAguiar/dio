let body = document.getElementsByTagName("BODY")[0];
let hero = document.querySelector('.hero');
let srcExhaust = document.querySelector('.exhaust');
let screenHeight = window.innerHeight;
let screenWidth = window.innerWidth;
let spScore = document.getElementById('score');
let score = 0;
let startStatus = false;

// Altera o estado do turbo
let changeExhaust = (state) => {
    let path = state == "turbo" ? "hero_turbo.gif" : "hero.gif";
    let src = srcExhaust.src.split('/');
    src.splice((src.length - 1), 1, path);
    srcExhaust.src = src.join("/");
}

let gameover = () => {
    document.querySelector(".cover").style.display = "flex";
    document.getElementsByTagName("H1")[0].innerHTML = "GAME OVER";
    document.getElementsByTagName("H2")[0].innerHTML = `SCORE: ${score}`;
    startStatus = false;
    score = 0;
}

let moveEnemy = () => {

    let leftEnemy = setTimeout(moveEnemy, 10);
    enemies = document.querySelectorAll('.enemy');

    for (let i = 0; i < enemies.length; i++) {
        let leftPosition = parseInt(getComputedStyle(enemies[i]).getPropertyValue('left'));
        if (leftPosition >= (screenWidth / 4) * 3) {
            let position = leftPosition - 3;
            enemies[i].style.left = `${position}px`;
            leftEnemy;
            if (leftPosition == (screenWidth / 4) * 3) {
                let enemyID = enemies[i].src.split("_")[1];
                enemies[i].src = `img/enemy_${enemyID}`;
            }
        } else if (leftPosition > 0) {
            let position = leftPosition - 1;
            enemies[i].style.left = `${position}px`;
            leftEnemy;
        } else {
            if (!startStatus) {
                enemies[i].remove();
                continue;
            }
            gameover();
            clearTimeout(leftEnemy);
        }
    }
}

// Cria o inimigo
let createEnemy = () => {
    let enemies = document.querySelectorAll('.enemy');

    let enemyID = Math.floor(Math.random() * 5 + 1);
    let top = Math.floor(Math.random() * (900 - 150) + 150);

    let enemy = document.createElement('IMG');
    enemy.src = `img/enemy-turbo_${enemyID}.gif`;
    enemy.style.left = `${ screenWidth }px`;
    enemy.style.top = `${ top }px`;
    enemy.style.position = `absolute`;
    enemy.classList.add(`enemy`);
    body.appendChild(enemy);
    if (enemies.length < 10) {
        setTimeout(() => {
            createEnemy();
        }, 5000);
    }
}

let removeEnemy = (async(enemy, topPosition) => {
    enemy.src = "img/ship_exp.gif";
    enemy.style.top = `${topPosition - (enemy.offsetHeight / 2)}px`;
    enemy.classList.remove("enemy");
    spScore.innerHTML = startStatus ? score += 1 : score;
    setTimeout(() => {
        enemy.remove();
    }, 500);

});

let chkShot = (async(leftPosition, topPosition) => {
    let enemies = document.querySelectorAll('.enemy');

    for (let i = 0; i < enemies.length; i++) {
        if (enemies[i].src !== "img/ship_exp.gif") {
            let enemyLeftPosition = parseInt(getComputedStyle(enemies[i]).getPropertyValue('left'));
            let enemyTopPosition = parseInt(getComputedStyle(enemies[i]).getPropertyValue('top'));

            if (leftPosition >= enemyLeftPosition && leftPosition <= (enemyLeftPosition + enemies[i].offsetWidth)) {
                if (topPosition >= enemyTopPosition && topPosition <= (enemyTopPosition + enemies[i].offsetHeight)) {
                    await removeEnemy(enemies[i], topPosition);
                    return true;
                }
            }
        }
    }
    return false;
});

// Move os tiros da tela
let moveShot = (async() => {
    let shots = document.querySelectorAll('.shot');
    let shotMove = setTimeout(moveShot, 5);
    for (let i = 0; i < shots.length; i++) {
        // Verifica a posição do tiro específico
        let leftPosition = parseInt(getComputedStyle(shots[i]).getPropertyValue('left'));
        let topPosition = parseInt(getComputedStyle(shots[i]).getPropertyValue('top'));
        // Verifica a posição do tiro
        if (leftPosition < screenWidth) {
            shots[i].style.left = `${leftPosition + 5}px`;
            let onTarget = await chkShot(leftPosition, topPosition);
            if (onTarget) {
                shots[i].src = "img/hero_shot_exp.gif";
                shots[i].classList.remove("shot");
                setTimeout(() => {
                    shots[i].remove();
                }, 1000);
            }
        } else {
            // Remove o tiro específico se a posição estiver fora da tela
            shots[i].remove();
        }
    }
    if (shots.length > 0) {
        // Callback da função se houver algum tiro ativo
        shotMove;
    } else {
        // Limpa o timeout se não houver tiro ativo
        clearTimeout(shotMove);
    }
});

// Cria o tiro
let createShot = (async() => {
    shots = document.querySelectorAll('.shot');
    let shot = document.createElement('IMG');
    let leftPosition = parseInt(getComputedStyle(hero).getPropertyValue('left'));
    let topPosition = parseInt(getComputedStyle(hero).getPropertyValue('top'));

    shot.src = "img/hero_shot.gif";
    shot.style.left = `${leftPosition + (hero.offsetWidth) + 5}px`;
    shot.style.top = `${parseInt(topPosition + (hero.offsetHeight / 2) + 8)}px`;
    shot.classList.add(`shot`);
    shot.style.position = `absolute`;
    body.appendChild(shot);
    if (shots.length === 0) {
        moveShot();
    }
});

// Função move o herói pra cima
let moveUp = (async() => {
    let topPosition = parseInt(getComputedStyle(hero).getPropertyValue('top'));
    var upMove = setTimeout(moveUp, 10);
    if (topPosition > 0) {
        let position = topPosition - 1;
        hero.style.top = `${ position }px `;
        upMove;
    } else {
        clearTimeout(upMove);
    }
});

// Função move o herói pra baixo
let moveDown = (async() => {
    let topPosition = parseInt(getComputedStyle(hero).getPropertyValue('top'));
    var downMove = setTimeout(moveDown, 10);
    if (topPosition <= screenHeight - hero.offsetHeight - 30) {
        let position = topPosition + 1;
        hero.style.top = `${ position }px`;
        downMove;
    } else {
        clearTimeout(downMove);
    }
});

// Função move o herói pra direita
let moveRight = (async() => {
    let leftPosition = parseInt(getComputedStyle(hero).getPropertyValue('left'));

    var leftMove = setTimeout(moveRight, 10);
    if (leftPosition <= (parseInt(screenWidth / 2))) {
        let position = leftPosition + 1;
        hero.style.left = `${ position }px`;
        leftMove;
    } else {
        changeExhaust("normal");
        clearTimeout(leftMove);
        moveLeft();
    }
});

// Função move o herói pra esquerda
let moveLeft = (async() => {

    let leftPosition = parseInt(getComputedStyle(hero).getPropertyValue('left'));
    let leftMove = setTimeout(moveLeft, 10);
    if (leftPosition > 0) {
        let position = leftPosition - 1;
        hero.style.left = `${ position }px`;
        leftMove;
    } else {
        clearTimeout(leftMove);
    }
});

// Verifica a tecla pressionada
let chkEvent = (async(key) => {
    switch (key) {
        case 'ArrowDown':
            await moveDown("move");
            break;
        case 'ArrowUp':
            await moveUp("move");
            break;
        case 'ArrowRight':
            changeExhaust("turbo");
            await moveRight();
            break;
        case 'ArrowLeft':
            changeExhaust("normal");
            await moveLeft();
            break;
        case ' ':
            await createShot();
            break;
        default:
            break;
    }
});

let start = () => {
    startStatus = true;
    document.querySelector(".cover").style.display = "none";

    enemies = document.querySelectorAll('.enemy');
    for (let i = 0; i < enemies.length; i++) {
        enemies[i].remove();
    }

    hero.style.top = `${ parseInt((screenHeight / 2) - hero.offsetHeight) }px`;

    createEnemy();
    moveEnemy();
    window.addEventListener('keydown', (eventKey) => {
        eventKey.preventDefault();
        chkEvent(eventKey.key)
    });
}

// Escuta o window para iniciar com o player centralizado
window.addEventListener('load', (event) => {
    event.preventDefault();

    createEnemy();
    moveEnemy();
    screenHeight = window.innerHeight;
    screenWidth = window.innerWidth;

    hero.style.top = `${ parseInt((screenHeight / 2) - hero.offsetHeight) }px`;
});

// Escuta o window resize para manter a posição do player
window.addEventListener('resize', (event) => {
    event.preventDefault();

    let topPosition = parseInt(getComputedStyle(hero).getPropertyValue('top'));
    screenHeight = window.innerHeight;
    screenWidth = window.innerWidth;
    hero.style.top = `${ parseInt(topPosition) }px`;
});