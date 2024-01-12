promise1 = new Promise((resolve, reject)=>{
    setTimeout(()=>{
        resolve(1);
    }, 2000);
})
//promise 1 thuc hien resolve trong 2 s

promise2 = new Promise((resolve, reject)=>{
    setTimeout(()=>{
        resolve();
    }, 4000)
})
//promise 2 thuc hien resolve trong 4s

//promis.all thuc hien trong 4s
//co nghia la ca 2 promise se thuc hien cung luc, khi ca 2 deu thuc hien xong resove
//thi promise.all se thuc hien then
// Va thoi gian thuc hien cua Promise.all bang thoi gian thuc hien cua 
// pormise con co thoi gian thuc hien lau nhat
Promise.all([promise1,promise2])
.then(()=>{
    console.log("Da thuc hien xong 2 promise");
})
.catch((err)=>{
    if(err){
        console.log("da xay ra loi o 1 trong 2 promise hoac ca 2 promise");
    }
})