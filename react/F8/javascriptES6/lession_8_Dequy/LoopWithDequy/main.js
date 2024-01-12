var loop = function (start, end, cb) {
    if(start < end){
        cb(start);
        return loop(start + 1, end, cb);
    }
  }

  var array = ['PHP', 'Javascript', 'C#', 'React'];
  loop(0, array.length, function(index){
    console.log(array[index]);
  })