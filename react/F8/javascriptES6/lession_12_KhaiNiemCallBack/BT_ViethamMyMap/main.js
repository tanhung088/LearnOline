const numbers = [1, 2, 3];
Array.prototype.myMap = function(cb) {
  var arr = [];
    for(var i = 0; i < this.length; i++){
      arr.push(cb(this[i], i));
    }
    return arr;
}

// Expected results
//functikn trong myMap(function) chinh la cb()
console.log(numbers.myMap(function (number) {
    return number * 2;
})) // Output: [2, 4, 6]

console.log(numbers.myMap(function (number, index) {
    return number * index;
})) // Output: [0, 2, 6]


