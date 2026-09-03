console.log("hello")


let myDiv = document.querySelector("div")

myDiv.addEventListener("click", (event) => {
    console.log(event.target)

    if (event.target.tagName == "H1") {
        myDiv.style.backgroundColor = 'yellow'
    }

    if (event.target.dataset.id == 1) {
        myDiv.style.backgroundColor = "blue"
    }

    if (event.target.dataset.id == 2) {
        myDiv.style.backgroundColor = "gray"
    }
    if (event.target.tagName == "P") {
        myDiv.style.backgroundColor = "orange"
    }


})


let arr = [1, 3, 4, 5]
let max = arr[0]
let sum = 0

for (let i = 0; i < arr.length; i++) {
    sum += arr[i]
    if (max < arr[i]) {
        max = arr[i]
    }
}
let find = (max * (max + 1))/2

console.log(Math.abs(sum-find))