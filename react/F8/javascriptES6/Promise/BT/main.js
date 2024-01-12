//Bai toan in ra 1 doi 1s in ra 2 doi 1s in ra 3 doi 1s
//dau tien se tao 1 function doi goi la sleep
sleep = (timeSleep)=>{
    return new Promise((resolve, reject)=>{
        setTimeout(()=>{
            resolve();
        }, timeSleep)
    })
}
sleep(1000)
    .then(()=>{
        console.log(1);
        return sleep(1000);
    })
    .then(()=>{
        console.log(2);
        return sleep(1000);
    })
    .then(()=>{
        console.log(3);
    })