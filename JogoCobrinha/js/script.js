let canvas = document.getElementById("snake");
let context = canvas.getContext("2d");
let direction = "right";
let flag = false;
let snake = [];
let score = 0;
let level = 1;
let box = 32;
let dificult = 300;
let food;
let game;

const getPosition = () => {
    return Math.floor(Math.random() * 15 + 1) * box
}

// Define o tamanho dos nós da "snake"
snake[0] = {
    x: 8 * box,
    y: 8 * box
}

food = {
    x: getPosition(),
    y: getPosition()
}

// Desenha o campo de jogo
const createBG = () => {
    context.fillStyle = "yellowgreen";
    context.fillRect(0, 0, 16 * box, 16 * box);
}

// Desenha a "snake"
const createSnake = () => {
    for (let i = 0; i < snake.length; i++) {

        context.fillStyle = "green";
        context.fillRect(snake[i].x, snake[i].y, box, box);
    }

}

// Desenha a comida
const createFood = () => {

    context.fillStyle = "darkred";
    context.fillRect(food.x, food.y, box, box);
}

// Altera a direção quando alguma tecla arrow direction for pressionada
const updateDirection = (event) => {
    switch (event.key) {
        case "ArrowLeft":
            direction = direction == "right" ? direction : "left";
            break;
        case "ArrowUp":
            direction = direction == "down" ? direction : "up";
            break;
        case "ArrowRight":
            direction = direction == "left" ? direction : "right";
            break;
        case "ArrowDown":
            direction = direction == "up" ? direction : "down";
            break;
        default:
            play();
            break;
    }
}

// Finaliza o jogo quando a "snake" colidir com as paredes ou nela mesma
const gameOver = () => {

    clearInterval(game);
    context.font = "50pt Fredoka One";
    context.fillStyle = "red";
    context.textAlign = "center";
    context.fillText("Game Over!", canvas.width / 2, canvas.height / 2)

}

// Verifica se a posição é válida para continuar o jogo
const checkPosition = () => {
    switch (direction) {
        case "right":
            flag = snake[0].x > 15 * box;
            break;
        case "left":
            flag = snake[0].x < 0;
            break;
        case "down":
            flag = snake[0].y > 15 * box;
            break;
        case "up":
            flag = snake[0].y < 0;
            break;
    }
    if (flag) gameOver();
}

const updateScore = () => {
    score += 1;
    let placar = document.getElementById('score');
    placar.innerHTML = score;
}

const levelUp = () => {

    context.font = "50pt Fredoka One";
    context.fillStyle = "red";
    context.textAlign = "center";
    context.fillText(`Level UP!${level}`, canvas.width / 2, canvas.height / 2)


}

// Verifica a condição do level
// Se a "snake" > que 10 + level -> Up level
const checkLevel = () => {
    if (snake.length >= (10 + level)) {
        level++;

        let spLevel = document.getElementById("level");
        spLevel.innerHTML = level;
        snake = snake.splice(0, level);
        dificult *= 1.01;
        createBG();
        createSnake();
        levelUp();
    }
}

// Define o movimento da "snake"
const movieSnake = (snakeX, snakeY) => {

    if (food.x == snake[0].x & food.y == snake[0].y) {

        food.x = getPosition();
        food.y = getPosition();

        updateScore();
        checkLevel();

    } else {

        snake.pop();
    }

    let newHead = {
        x: snakeX,
        y: snakeY
    }

    snake.unshift(newHead);

}

// Verifica a direção do movivento
const checkDirection = () => {

    let snakeX = snake[0].x;
    let snakeY = snake[0].y;

    if (direction == "right") snakeX += box;
    if (direction == "left") snakeX -= box;
    if (direction == "up") snakeY -= box;
    if (direction == "down") snakeY += box;

    flag = snake.filter(position => position.x === snake[0].x & position.y === snake[0].y).length > 1;
    if (flag) gameOver();

    movieSnake(snakeX, snakeY);
}

// Inicia o jogo
const startGame = () => {
    createBG();
    createSnake();
    checkDirection();
    checkPosition();
    createFood();
}

// Diplay a tela do jogo
const play = () => {

    document.querySelector(".play").remove();
    document.querySelector(".canvas").style.display = "block";
    document.querySelector(".placar").style.display = "flex";

    // Define os frames/s
    game = setInterval(startGame, dificult);
}

// Escuta as teclas
document.addEventListener('keydown', updateDirection);