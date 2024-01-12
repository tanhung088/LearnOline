//fetch
var apiTest = "https://jsonplaceholder.typicode.com/comments";
fetch(apiTest)
    .then(respone=>{
        return respone.json();
        //tuong tu JSON.parse Json -> javascript type
    })
    .then(data=>{
        console.log(data);
    })