var inputTextValue = "";
var inputText = document.querySelector("input[type='text']")
inputText.onchange = function(e){
  inputTextValue = e.target.value;
}
console.log(inputTextValue);
console.log(inputText);
