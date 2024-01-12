// function isNumber(value){
//     if(isNaN(value)){
//         return false;
//     }if(typeof(value) === 'number'){
//         return true;
//     }else{
//         return false;
//     }
// }
/*
    trong cach 1 se giai quyet duoc van de NaN duoc xem nhu 1 number
*/
//cach 2
function isNumber(value) {
    return typeof value === 'number';
}


// Expected results:
console.log(isNumber(999)); // true
console.log(isNumber('abc')); // false
console.log(isNumber('100')); // false