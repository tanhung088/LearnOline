function run(object) {
    var array = [];
    for(var key in object){
        var results = `Thuộc tính ${key} có giá trị ${object[key]}`;
        array.push(results);
    }
    return array;
}

// Expected results:
console.log(run({ name: 'Nguyen Van A', age: 16 }));