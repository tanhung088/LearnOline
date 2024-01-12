//trong es6 ta co the phan ra tung phan tu trong mang hoac object
var array = ["javascript", "PHP", "NOdeJs"];
//Ta se tao 3 bien a, b, c va gan cho no tung phan tu trong mang
var [a , b, c] = array;
console.log("A :",a);
console.log("B :",b);
console.log("C :",c);
//hoac
var [d, , e] = array;
console.log("D :",d);
console.log("E :",e);
//hoac
var [f, ...rest] = array;
console.log("F :",f);
console.log("rest :",rest);

// Tuong tu ta se dung voi object
console.log("-----------Object----------------------");
var Course = {
    name:"javascript",
    price: 1000,
    childObject:{
        name: "DOM",
        price: 500
    }
}
var {name , price} = Course;
console.log("Name :", name);
console.log("Price :", price);

//Lay destruc object long nhau
console.log("---Destruc Object long nhau---");
// de doi ten key thi ta dung : VD name : parentName
//de lay key trong childObject childObject{name}
var { name: parentName, price, childObject : {name : childName}} = Course;
console.log("parentName :", parentName);
console.log("childName :", childName);
//Neu muon them 1 thuoc tinh ko co trong object thi ta dung default param
//VD: var {name , price, description = "default description"}
