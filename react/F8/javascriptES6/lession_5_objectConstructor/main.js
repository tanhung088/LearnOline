var User = function (firstName, lastName, age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    // this o tren la doi tuong doc tao bang User
    // VD tao 1 user = new User() thi this la user
    this.getName = function(){
        return `${this.firstName} ${this.lastName}`;
    }
}
//De add property or method into User :
User.prototype.className = 'A';
//Khi do property avatar se nam trong phan proto cua object
// Tuong tu add method
User.prototype.getClassName = function(){
    return `${this.className}`;
}

var author = new User('Hung', 'Nguyen', 24);
var user = new User('Nhan', 'Pham', 28);

console.log(author.className);
console.log(author.getClassName());

// User la mo ta thuoc tinh chung
// author va user la object duoc tao nen tu User
//cach  kiem tra 1 doi tuong co phai constructor hay ko va thoc mo ta thoc tinh nao
console.log(author.constructor === User)
//Them thuoc tinh vao tung doi tuong
author.title = 'Hoc js co ban';
user.comment = 'Cac bai giang rat tot';

console.log(author.getName());
console.log(user.getName());
console.log(author);
console.log(user);
