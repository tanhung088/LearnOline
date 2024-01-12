/*
  CallBack la ham duoc goi tu phia ben trong cua ham khac
*/
function myFunction(param){
  //typeof param == function
  param("Hoc ve callback");
}
function myCallBack(value) {
  console.log("Value : ", value);
}
//ta goi 
myFunction(myCallBack);