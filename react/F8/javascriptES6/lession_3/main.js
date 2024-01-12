//Thuc hanh ve parameter va argument

function writeLog(){
    var myString = ' ';
    for(var param of arguments){
        myString += `${param} - `
    }
    console.log(myString);
}
//goi ham
writeLog('a', 'b', 'c', 'd');
