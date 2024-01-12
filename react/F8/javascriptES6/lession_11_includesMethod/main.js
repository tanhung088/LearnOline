//includes 
//chi co trong String va Array(prototype)
const _array = ["js", "PHP", "React", "C#"]
const findPHP = _array.includes("PHP", 0);
/*
    0 is default cua param thu 2 cua method, neu 0 la di tu dau mang. Neu am thi lay do dai mang + so am
    syntax array.includes("");
    Chuc nang cua includes la tim xem "doi so truyen vao" co trong mang hay ko. Neu co se tra ve true ko co false
    Neu ham tra ve return thi ham do tra ve chuoi tim thay
*/
const findReact = function (_arr, findStrc) {
    return _arr.includes(findStrc);
}
console.log(_array, "React"); // "React"
console.log(findPHP); // true