//dung de xu ly nghi ngo xem co du lieu do hay khong
var obj = {
    name: "a",
    cat1 :{
        name: "b",
        cat2:{
            name:"c",
            cat3:{
                name:"d"
            }
        }
    }
}
if(obj.cat1?.cat2?.cat3){
    console.log(obj.cat1.cat2.cat3.name);
}