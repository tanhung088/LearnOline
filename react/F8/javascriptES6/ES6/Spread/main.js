//tuong tu rest nhung neu dau ... dung truoc array hoac object la spread
//VD array
var array1 = ['javascript', 'PHP', 'NodeJs'];
var array2 = ['ReactJs', 'Dart'];
var array3 = [...array2, ...array1];

console.log("array3 :", array3);
//VD object
var obj1 = {
    name : "javascript"
}

var obj2 = {
    price : 1000
}

var obj3 = {
    ...obj1,...obj2
}
//luu y neu trong object neu ta dat key trung nhau thi no se lay key duoc dinh nghia sau cung
console.log("Object3 : ", obj3);
