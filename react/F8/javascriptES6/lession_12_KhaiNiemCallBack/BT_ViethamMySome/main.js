var courses = [
  {
    id: 1,
    name: 'React',
    coin: 250
  },
  {
    id: 2,
    name: 'HTML CSS',
    coin: 0
  },
  {
    id: 3,
    name: 'Javascript',
    coin: 300
  },
  {
    id: 4,
    name: 'PHP',
    coin: 0
  },
  {
    id: 5,
    name: 'PHP',
    coin: 0
  }
];

Array.prototype.mySome = function(cb){
  for(var index in this){
    if(this.hasOwnProperty(index)){
      var result = cb(this[index], index, this);
      if(result){
        return true;
      }
    }
  }
  return false;
}

var checkBoolean = courses.mySome((course, index, courses)=>{
  return course.coin === 300;
})
console.log(checkBoolean);