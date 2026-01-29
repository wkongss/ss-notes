const btn = document.getElementById("btn");
const display = document.getElementById("display")

btn.onclick = async function() {
    fetch("http://localhost:8080/trainers/")
        .then((res) => res.json())
        .then((data) => {
            display.innerText = JSON.stringify(data);
        })
}