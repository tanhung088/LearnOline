var courses = ['HTML & CSS', 'Javascript', 'PHP', 'Java']

function render(arr){
  var listHtml = [];
  listHtml = arr.map(element=>{
    return `<li>${element}</li>`
  });
  console.log("listHtml = ",listHtml);
  //hien tai listHtml dang la 1 mang
  /*
0: "<li>HTML & CSS</li>"
1: "<li>Javascript</li>"
2: "<li>PHP</li>"
3: "<li>Java</li>"
*/
// sau do dung join de convert sang string
 var html = listHtml.join('');
 console.log("html = ",html);
 /*
   html = '<li>HTML & CSS</li><li>Javascript</li><li>PHP</li><li>Java</li>'
 */

  //da co chuoi html ta dung inner vao element ul bang cach dung innerHTML
  return document.querySelector('ul').innerHTML = html;
}

console.log("render = ",render(courses));