//DOM
const h1Dom = document.createElement("h1")
console.log(h1Dom);
h1Dom.title = "Hello"
h1Dom.className = "heading"
h1Dom.innerHTML = "Hello guys!"
document.body.appendChild(h1Dom)
//React
//syntax React.createElement(type, props, children)
//children la phan text ben trong react elment khi hien thi thi no van nam trong phan props
const h1React = React.createElement("h1", {
    title: "Hello",
    className : "heading"
}, "Hello guys")
console.dir(h1Dom);
console.log(h1React);
//tao the li voi tag ul co san
//DOM
const ulDom = document.querySelector("ul")
//them id cho the ulDom
ulDom.id = "h1UldomId"
const li1Dom = document.createElement("li")
li1Dom.innerHTML = "Javascript"

const li2Dom = document.createElement("li")
li2Dom.innerHTML = "Reactjs"

ulDom.appendChild(li1Dom)
ulDom.appendChild(li2Dom)
//React
const ulReact = React.createElement(
    "ul",
    null,
    React.createElement("li", null, "Javascript"),
    React.createElement("li", null, "Reactjs")
)
console.log("ulReact :", ulReact);