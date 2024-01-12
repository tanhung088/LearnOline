const numbers = [1, 2 ,3, 4, 5]
//dau tien thuc hien voi method reduce binh thuong
// cach dau tien se ko co initial
// thi accumulator o luot chay dau tien se la gia tri dau tien trong mang
// currentValue se la gia tri thu 2 trong mang
const result1 = numbers.reduce((accumulator, currrentValue, index, originiArray)=>{
  return accumulator+currrentValue
});
console.log("Khong co inital: ",result1);
//cach 2 co initial
/*
  Neu co inital thi o luot chay dau tien accumulator se mang gia tri cua initial
  O nhung luot chay tiep theo no se mang gia tri cua return co nghia la bien tich tru cua ham
  Trong bai toan  tren thi la results2
  Luot chay 1:
  _ accumulator = inital = 0
  _ currrentValue = numbers[0] = 1
  _bien tich tru return accumulator + currrentValue = 0 + 1 = 1
  Luot chay 2:
  _ accumulator = accumulator + currrentValue = 0 + 1 = 1
  _ currrentValue = numbers[1] = 2
  _bien tich tru return accumulator + currrentValue = 1 + 2 = 3
  Luot chay 3:
  _ accumulator = accumulator + currrentValue = 1 + 2 = 3
  _ currrentValue = numbers[2] = 3
  _bien tich tru return accumulator + currrentValue = 3 + 3 = 6
  Luot chay 4:
  _ accumulator = accumulator + currrentValue = 3 + 3 = 6
  _ currrentValue = numbers[3] = 4
  _bien tich tru return accumulator + currrentValue = 6 + 4 = 10
  Luot chay 5:
  _ accumulator = accumulator + currrentValue = 6 + 4 = 10
  _ currrentValue = numbers[4] = 5
  _bien tich tru return accumulator + currrentValue = 10 + 5 = 15
*/
const result2 = numbers.reduce((accumulator, currrentValue, index, originiArray)=>{
  return accumulator + currrentValue
},0)
console.log("Co initial : ",result2)


//Dua vao tinh chat tren ta se tu xay dung CusReduce1 va CusReduce2
// Dau tien la CusReduce 2 ko co initial
Array.prototype.CusReduce = function (callback, ele) {
  let i =0;
  if(arguments.length > 2 ){
    i = 1;
    ele = this[0];
  }
  for( ; i < this.length; i++){
    ele = callback(ele, this[i], i, this);
  }
  return ele;
}
const result2CusReduce2 = numbers.CusReduce((total, number)=>{
  return total + number;
}, 10);
console.log("CusReduce2 ko co initial: ",result2CusReduce2);