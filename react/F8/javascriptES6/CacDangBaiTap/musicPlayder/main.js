//dau tien lay ra cac ele tab-item
const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);
const tabItem = $$(".tab-item");
const paneItem = $$(".tab-pane");
//Lay tab active
const tabActive = $(".tab-item.active");
const tabLine = $(".tabs .line");
//gan left and width cho tabLine tuong ung voi tab active
tabLine.style.left = tabActive.offsetLeft + 'px';
tabLine.style.width = tabActive.offsetWidth + "px";

console.log([tabActive]);
console.log([tabLine]);
// dung vong lap duyen qua tung phan tu va gan event onclick vao tung phan tu do
tabItem.forEach((tab, index) => {
    tab.onclick = function(){
        //xoa active trong item va gan lai active vao tab duoc click
        $(".tab-item.active").classList.remove('active');
        this.classList.add('active');

        //cung voi do thay doi phan tab-pane
        $(".tab-pane.active").classList.remove('active');
        paneItem[index].classList.add("active");
        //cung voi do se thay doi gtab line
        tabLine.style.left = this.offsetLeft + 'px';
        tabLine.style.width = this.offsetWidth + 'px';

        // console.log(paneItem[index]);
        // console.log(this);
    }
});
console.log("tab item : " ,tabItem);
console.log("pane item : ", paneItem);