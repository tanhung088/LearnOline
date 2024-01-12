const sports = [
  {
      name: 'Bóng rổ',
      like: 6
  },
  {
      name: 'Bơi lội',
      like: 5
  },
  {
      name: 'Bóng đá',
      like: 10
  },
]
function getMostFavoriteSport(array){
  return list = array.filter((a, index)=>{
    return a.like > 5;
  });
}

//console.log(listArray);
// Kỳ vọng
console.log(getMostFavoriteSport(sports)) 
// Output: [{ name: 'Bóng rổ, like: 6 }, { name: 'Bóng đá, like: 10 }]





