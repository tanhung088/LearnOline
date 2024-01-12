//tao 1 promise tu object constructor Promise
//theo tinh chat cua 1 ob constructor neu chung tat set gi do cho no thi no se chay dau tien

var promise = new Promise(
    //set excuetor function
    function(resolve, reject) {
        //resolve la thanh cong
        //reject la that bai
        //neu ham thuc hien resolve() thi se nhay vao then
        //neu han thuc hien reject() thi se nhay vao catch
        //finally luoc chay khi co resolve() hoac reject()
        resolve();
    }
)
// promise
//     .then(function() {
//         return 1;
//         //Neu o ham then nay co gia tri tra ve thi ham then tiep theo co the nhan gia tri do lam doi so va su dung
//     })
//     .then(function(data) {
//         console.log(data);
//         return 2;
//     })
//     .then(function(data) {
//         console.log(data);
//         return 3;

//     })
//     .catch()
//     .finally();
// nhung neu o then() ko return hoac return ve gia tri ko phai Promise thi then() sau do se thuc hien
//Neu then() lai tra ve 1 promise thi then() tiep theo phai doi khi resolve() cua then() truoc do thuc hien
promise
    .then(function() {
        return new Promise(function(resolve) {
            setTimeout(function(){
                resolve([1,2,3]);
            }, 5000)
        })
    })
    .then(function(data){
        console.log("promise 2 then 2",data);
    })