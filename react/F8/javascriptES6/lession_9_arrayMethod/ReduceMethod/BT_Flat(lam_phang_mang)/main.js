/*
  Flat(lam phang) ma detph sau:
  array= [1, 2 [3, 4], 5, 6, [7, 8, 9], [10, 11]];
  
*/
var array= [1, 2, [3, 4], 5, 6, [7, 8, 9], [10, 11]];
var flatArray1 = array.reduce((accumulator, currentValue)=>{
  return accumulator.concat(currentValue); 
}, []);
console.log(flatArray1);
/*
  Bai toan 2 thuc hien voi mang chua mang va object
*/
var topic = [
  {
    topicName: 'Front-end',
    course: [
      {
        id: 1,
        title: 'PHP'
      },
      {
        id: 2,
        title: 'Javascript'
      }
    ]
  },

  {
    topicName: 'Back-end',
    course: [
      {
        id: 3,
        title: 'React'
      },
      {
        id: 4,
        title: 'Vue'
      }
    ]
  }
];

var flatArray2 = topic.reduce((newArray, topicItem)=>{
  return newArray.concat(topicItem.course);
}, []);
console.log('---------------Result BT2---------------');
console.log(flatArray2);
//De chuyen sang ma html va chuyen ma html do thang chuoi:
var htmls = flatArray2.map((element)=>{
  return `

        <tr>
          <td>ID: ${element.id}</td>
          <td>Title: ${element.title}</td>
        </tr>

  `;
});
console.log('----Duoi day htmls la array-----------');
console.log(htmls);
// chuyen thanh chuoi
console.log('----Sau khi chuyen htmls thanh chuoi-----------');
console.log(htmls.join(''));
