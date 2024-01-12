class Course{
    constructor(name,price){
        this.name = name;
        this.price = price;

        
    }
    //luu neu dung arrow function se bi loi vi arrow ko co context
    getName = function(){
        return this.name;
    }
}
const jsCourse = new Course("javascript", 1000);
console.log(jsCourse.getName());