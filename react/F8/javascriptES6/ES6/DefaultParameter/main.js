//trong es6 neu muon dinh nghia 1 default param thi
const logger = (log, type = 'log') => {
    console[type](log);
}
//trong ham nay thi type duoc gan 1 gia tri mac dinh la log
//nhung khi goi ham ta muon thay doi gia tri cua type thanh warn hoac error
//logger('message...', 'warn');
logger('message...', 'error');