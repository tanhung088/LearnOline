var course = [
  {
    id: 1,
    name: 'React',
    coin: 250
  },
  {
    id: 2,
    name: 'HTML CSS',
    coin: 100
  },
  {
    id: 3,
    name: 'Javascript',
    coin: 300
  },
  {
    id: 4,
    name: 'PHP',
    coin: 200
  },
  {
    id: 5,
    name: 'PHP',
    coin: 50
  }
];
/*
  Reduce() duoc dung khi can tra ve 1 gia tri duoc tinh toan va ra ket qua cuoi cung
  VD nhu can tinh toan sum coin cua cac khoa hoc
*/

var i = 0;

var totalCoin = course.reduce((accumulator, currentValue, currentIndex, originArray)=>{
  //current index la gia tri index cua curentValue
  i++;
  var total = accumulator+ currentValue.coin;
  console.table({
    LuotChay: i,
    accumulator: accumulator,
    currentValueCoin: currentValue.coin,
    total: total
  });
  return total;
},0);
 // so 0 la initial la gia tri ban dau khi chay lan dau tien co nghia la accumulator khi chay lan dau tien = 0
 //o cac luot chay tiep theo accumulator se duoc gan bang voi gia tri duoc tra ve cua function o day la total
 /*
  Trong truong hop ko co tham so initial thi accumulator se co  KDL tuong uong voi element cua mang
  VD trong truong hop nay thi la object va accumulator o luot chay dau tien se mang gia tri dau tien cua mang
  Trong khi do currentValue se mang gia tri thu 2 trong mang
 */
/*
  Trong truong hop giai quyet bai toan ma can tinh toan cac phan tu trong mang thi can initital
*/
console.log('------Khong co initial-------------')
var notInitial = course.reduce((accumulator, currentValue)=>{
  i++;
  console.log(accumulator);
  console.log(currentValue);
  return currentValue;
});