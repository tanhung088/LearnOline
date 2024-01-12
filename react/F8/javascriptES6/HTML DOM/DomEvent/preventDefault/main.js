var tag_a = document.links; // lay tat ca the a co link
//tag_a dang la 1 htmlcolection nen ta dung vong lap de duyet qua va lay tung the a trong no  
for (var i = 0; i < tag_a.length; i++) {
    tag_a[i].onclick = function(e) {
        console.log(e.target.href);
        /*
          ham startsWith() kiem tra xem co bat dau voi chuoi trong doi so dua vao hay ko
          prevenDefault de chan hanh vi mac dinh cua web
          O day ta se chan chuyen trang neu href cua the a do ko bat dau voi http://google.com
        */
        if (!e.target.href.startsWith("http://google.com")) {
            e.preventDefault();
        }
    }
}
console.log(tag_a);
///////////////////////////////////////////////////////////////////
/*
  Ben phia view ta da viet css de cho ul display = none va neu focus va the input thi se display = block
  Chung ta se ngan chan d e khi ko con focus vaa the input nhung display cua ul van la block
  _CHung ta hay de y xem, hanh vi khi mat focus vao input la hanh vi khi chung ta nhap chuot xuong la da mat
  co nghia la onMousedown
  chung ta se chan hanh vi do bang preventDefault
*/
var ulElement = document.querySelector('ul');
ulElement.onmousedown = function(e) {
    e.preventDefault();
}