//Ung dung Closure de tao logger test cho trang web
function createLogger(namespace){
    function logger(message){
        console.log(`[${namespace}] ${message}`);
    }
    return logger
}

//===================App======================
//----Register.js
const infoLogger = createLogger("info")
console.log(infoLogger("Bat dau gui mail"))
console.log(infoLogger("Gui mail loi lan 1..."))
console.log(infoLogger("Gui mail thanh cong cho user"))
//--FogotPassword.js
 const errorLogger = createLogger("error")
 console.log(errorLogger("Password khong tim thay trong danh sach user"))
 console.log(errorLogger("Gui mail loi lan 1..."))
 console.log(errorLogger("Gui mail thay doi password thanh cong cho user"))
