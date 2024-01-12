/*
  Array method:
  + forEach()
  + every() tra ve boolean
  + some()
  + find()
  + filter
  + map()
  + reduce
  tat ca cac method tren deu co param la function
 */
var course = [
  {
    id: 1,
    name: 'React',
    coin: 250
  },
  {
    id: 2,
    name: 'HTML CSS',
    coin: 0
  },
  {
    id: 3,
    name: 'Javascript',
    coin: 300
  },
  {
    id: 4,
    name: 'PHP',
    coin: 0
  },
  {
    id: 5,
    name: 'PHP',
    coin: 0
  }
];
//Truyen 1 ham qua tham so duoc goi la callback
// duyet qua tung phan tu cua mang
// forEach()
var newlist = [];
course.forEach((course, index) => {
  console.log(index, course);
  console.log(course.name);
  newlist[index] = course.name;
});
console.log("newLIst",newlist);

//every()
/*
  every() se duyet tat ca cac phan tu trong mang va moi lan duyen se goi lai ham ben la tham so
  Va duyet dan phan tu ko thoa man dieu kien trong ham se ngung lai va tra ve boolean
*/
var isFree =  course.every((course, index) => {
  return course.coin ===0;
});
console.log(isFree);
if(isFree){
  console.log('All courses is free')
}else{
  console.log('Have a course not free!');
}

//some()
/*
  Nguoc lai voi every() neu duyet den phan tu true thi se ngung va return boolean
*/
//find()
/*
  Duyet qua tung element Neu gap ele thoa dieu kien se ngung lai va tra ve element do
  Neu ko co tra ve undifined
  Neu co nhieu dieu kien thoa thi chi tra ve ele dau tien
*/
var findPHP =  course.find((course, index) => {
  return course.name === 'PHP';
});
console.log("findMethod",findPHP);
console.log("test", course[1]);
//filer()
/*
  Tuong tu find nhung tra ve tat ca element thoa voi dieu kien va la 1 array
  va mang moi duoc tra ve la 1 mang khac tham khao them tu khoa value type and reference type
*/
var listPHP =  course.filter((course, index) => {
  return course.name === 'PHP';
});
console.log(listPHP);


