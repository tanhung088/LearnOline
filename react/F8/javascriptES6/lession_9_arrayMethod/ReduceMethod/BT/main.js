/*
  Tại SEA GAMES 31 vừa qua, đoàn thể thao Việt Nam đã đứng đầu bảng tổng sắp huy chương.
   Hãy tạo hàm getTotalGold có 1 tham số là mảng.
   Tính tổng số huy chương vàng mà đoàn thể thao Việt Nam đạt được trong kỳ SEA Game lần này.
*/
var sports = [
  {
      name: 'Bơi lội',
      gold: 11
  },
  {
      name: 'Boxing',
      gold: 3
  },
  {
      name: 'Đạp xe',
      gold: 4
  },
  {
      name: 'Đấu kiếm',
      gold: 5
  },
]

var getTotalGold = function (array) {
  return sumgold = array.reduce((accumulator, currentValue)=>{
    return accumulator + currentValue.gold;
  },0);
}

// Expected results:
console.log(getTotalGold(sports)) // Output: 23






