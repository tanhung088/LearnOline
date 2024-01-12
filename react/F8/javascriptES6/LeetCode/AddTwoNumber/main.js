/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/

function ListNode(val) {
    this.val = val;
    this.next = null;
}

var addTwoNumbers = function (l1, l2) {
    /*
        chuyen array l1 -> nghich dao -> chuoi -> luu vao x
    */

    let x = l1.reverse().join('');
    let y = l2.reverse().join('');

    /*
        (+x + +y) -> tu chuoi chuyen thanh so va cong lai voi nhau
        String() -> sau do chuyen thanh chuoi ket qua da cong
    */
    let sum = String(+x + +y);
    let result = [];
    for(let i = 0; i < sum.length; i++){
        result.push(sum[i]);
    }
    return result.reverse();

};
let l1 = [2, 4, 3];
let l2 = [5, 6, 4];
console.log(addTwoNumbers(l1,l2));
