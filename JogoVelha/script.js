let users = ["X", "O"];
let userX = [];
let userO = [];
let user;

let rules = {
    "line1": [1, 2, 3],
    "line2": [4, 5, 6],
    "line3": [7, 8, 9],
    "col1": [1, 4, 7],
    "col2": [2, 5, 8],
    "col3": [3, 6, 9],
    "diag1": [1, 5, 9],
    "diag2": [3, 5, 7]
}

let selectUser = () => {
    user = Math.floor((Math.random() * 1) + 1);
    user = users[user]
}

let selectElement = (id) => {
    if (user === 0) {
        userX.push(id);
    } else {
        userO.push(id)
    }
    user = user === "X" ? "O" : "X";
    document.querySelector("#player").innerHTML = user;
    document.getElementById(id).innerHTML = user;
}

selectUser();
document.querySelector("#player").innerHTML = user;