let canvas = document.getElementById("snake");
let context = canvas.getContext("2d");
let box = 32;
let snake = [];
let food = [];
let direction = "right";

// Define o tamanho dos nós da "snake"
snake[0] = {
    x: 8 * box,
    y: 8 * box
}

food = {
    x: Math.floor(Math.random() * 15 + 1) * box,
    y: Math.floor(Math.random() * 15 + 1) * box
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
    let flag = false;
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

// Define o movimento da "snake"
const movieSnake = (snakeX, snakeY) => {

    snake.pop();

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

// Escuta as teclas
document.addEventListener('keydown', updateDirection);


// Define os frames/s
let game = setInterval(startGame, 100);