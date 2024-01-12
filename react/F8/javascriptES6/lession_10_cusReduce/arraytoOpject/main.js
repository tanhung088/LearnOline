
 //chuyen mang thanh object dung reduce
// Expected results:
var arr = [
  ['name', 'Sơn Đặng'],
  ['age', 18],
];
/*
const arrToObj = (arr)=>{
  return arr.reduce((acc, iValue)=>{
    acc[iValue[0]] = iValue[1];
    return acc;
  }, {});
}
*/
// acc[iValue[0]]  = iValue[1]; ve trai la key con ve phai la value cua 1 object

//cach 2:
const arrToObj = (arr)=>{
  return Object.fromEntries(arr);
}

console.log(arrToObj(arr)); // { name: 'Sơn Đặng', age: 18 }
