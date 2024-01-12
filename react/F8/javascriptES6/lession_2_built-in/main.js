console.log('Nguyen Tan Hung');
var a = 'console log demo';
console.error(a);

confirm('confrim demo: Are you 18 years old?');
prompt('prompt demo: How old are you?');

/* set timeout de thuc thi code trong function va trong thoi gian timeout se thuc hien */
setTimeout(() => {
    alert('set time out demo');
}, timeout = 2000);

/* set interval */
setInterval(function() {
    console.log('Day la log'+Math.random());
}, timeout = 2000);   