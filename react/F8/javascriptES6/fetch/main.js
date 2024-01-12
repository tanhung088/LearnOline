//fetch
var apiTest = "http://localhost:3000/courses";
fetch(apiTest)
    .then(respone=>{
        return respone.json();
        //tuong tu JSON.parse Json -> javascript type
    })
    .then(data=>{
        console.log(data);
    })