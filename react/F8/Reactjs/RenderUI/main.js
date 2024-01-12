//Hoc ve cach render ra UI voi react
const postItem = React.createElement(
    "div",
    {
        className : "post-item",
    },
    React.createElement(
        'h2',
        {
            title : 'Hoc react tai F8'
        },
        'Hoc Reactjs'
    ),
    React.createElement(
        'p',
        {},
        'Reacjs tu co ban den nang cao'
    )
)
console.log(postItem);
//get root element
const rootEle = document.querySelector('#root')
//react -> dom
//(param 1, param 2) param 1 ele can render, param 2 la container chua ele can render
ReactDOM.render(postItem, rootEle)