var getRandNumber = function(min,max,length){
    var array = [];
    for(var i = 0; i < length; i++){
        array.push(Math.random() * (max - min) + min);
    }
    return array;
}
var a = getRandNumber(10,20,7);
console.log(a.length);