/*
  Lang nghe va xu ly nhieu cong viec
  Lang nghe hoac huy bo lang nghe
*/
var btnEle = document.querySelector('button');
cviec1 = () => {
    console.log("cviec1");
}
cviec2 = () => {
    console.log("cviec2");
}
btnEle.addEventListener('click', cviec1);
btnEle.addEventListener('click', cviec2);
btnEle.addEventListener('');
setTimeout(function() {
    btnEle.removeEventListener('click', cviec1);
}, 3000)