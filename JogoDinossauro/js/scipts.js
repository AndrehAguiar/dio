const DINO = document.querySelector(".dino");
const BACKGROUND = document.querySelector(".container");

let isJumping = false;
let gameOver = false;
let position = 0;
let fps = 20;

const handleKeyUp = (event) => {
    if (event.keyCode === 32) {
        if (!isJumping) {
            jump();
        }
    }
}

const down = () => {
    let downInterval = setInterval(() => {
        if (position <= 0) {
            isJumping = false;
            clearInterval(downInterval);
        } else {
            position -= fps;
            DINO.style.bottom = `${position}px`;
        }
    }, fps);
}

const up = () => {
    let upInterval = setInterval(() => {
        if (position >= 150) {
            clearInterval(upInterval);
            down();
        } else {
            position += fps;
            DINO.style.bottom = `${position}px`;
        }
    }, fps);
}

const jump = () => {
    isJumping = true;
    up();
}

const getRandomTime = () => {
    return Math.random() * 6000;
}

const moveCactus = (CACTUS, cactusPosition) => {
    let randonTime = getRandomTime();
    let moveCactusLeft = setInterval(() => {
        if (cactusPosition < -60) {
            clearInterval(moveCactusLeft);
            BACKGROUND.removeChild(CACTUS);

        } else if (cactusPosition > 0 && cactusPosition < 60 && position < 60) {
            console.log("GAME OVER!");
            clearInterval(moveCactusLeft);
            BACKGROUND.removeChild(CACTUS);
            if (!gameOver) {
                finishGame();
            }

        } else {
            CACTUS.style.left = `${cactusPosition -= 10}px`;

        }
    }, fps); {
        let cactusTimeOut = setTimeout(createCactus, randonTime);
        !gameOver ? cactusTimeOut : clearTimeout(cactusTimeOut)
    }
}

const createCactus = () => {
    if (!gameOver) {
        const CACTUS = document.createElement('DIV');
        let cactusPosition = window.screen.width;

        CACTUS.classList.add('cactus');
        CACTUS.style.left = `${cactusPosition}px`;
        BACKGROUND.appendChild(CACTUS);

        moveCactus(CACTUS, cactusPosition);
    }
}

const clearCactus = (el, idx, arr) => {
    BACKGROUND.appendChild(el);
}

const finishGame = () => {
    gameOver = true;
    document.body.innerHTML = '<h1>Game Over!</h1>';
    document.querySelectorAll(".cactus").forEach(clearCactus);
}

createCactus();
document.addEventListener('keyup', handleKeyUp);