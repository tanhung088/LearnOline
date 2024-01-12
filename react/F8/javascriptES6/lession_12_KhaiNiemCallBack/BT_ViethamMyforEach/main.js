Array.prototype.myForEach = function(cb){
  for(var index in this){
    if(this.hasOwnProperty(index)){ // kiem tra index co chua element la ownProperty cua mang hay ko, bo qua prototype
      cb(this[index], index);
    }
  }
}

const arrs = ['javascript', 'php', 'reactjs'];
arrs.myForEach(arr=>{
  console.log(arr);
});