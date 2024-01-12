/*
  stopPropagation la chan su kien noi bot
  Event noi bot co nghia la khi ta thuc hien 1 event cua ele node con thi sau khi thuc hien no
  thi event cua ele node cha se thua hien theo va cac ele node cap cao hon cung se noi len va thuc hien
*/
// O bai ta co ele div co con la button
var divEle = document.querySelector('div');
var btnEle = divEle.querySelector('button');
divEle.onclick = function(e) {
    console.log("Div event");
}
btnEle.onclick = function(e) {
    e.stopPropagation();
    console.log("btn event");
}