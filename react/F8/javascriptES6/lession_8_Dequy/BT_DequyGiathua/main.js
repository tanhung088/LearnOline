var giaithua = function(num){
  if(num > 0){
    return num * giaithua(num - 1);
  }
  return 1;
}
console.log(giaithua(6));