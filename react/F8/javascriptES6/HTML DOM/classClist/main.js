/*
  Cho trước file HTML có các thẻ div, các bạn hãy thêm class box vào các thẻ div này nhé.
*/

var listDiv = document.querySelectorAll('div');
for(var i = 0; i< listDiv.length; i++){
    listDiv[i].classList.add('box');
}