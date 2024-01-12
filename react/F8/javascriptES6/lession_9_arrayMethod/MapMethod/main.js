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
/*
  map() se duyet qua tung phan tu co trong mang
  AP dung khi chung ta muon thay doi hoac them thuoc tinh vao cac phan tu co trong mang
  va return ve 1 array moi
  * Thuong dung de show view treb web
*/
var newCourses = course.map((course, index)=>{
  return {
    id: course.id,
    name : `Course : ${course.name}`,
    coin: course.coin,
    coinText : `Price : ${course.coin}`,
    index : index
  }
});
console.log(newCourses);

var h2Text = course.map((course, index)=>{
  return `<h2>${course.name}</h2>`
});
console.log(h2Text.join(''));
