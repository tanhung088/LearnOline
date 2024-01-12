/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
*/
var isValid = function(s) {
    let stack = [];
    let bracketMap = {
        '(': ')',
        '[': ']',
        '{': '}'
    };
    
    for (let char of s) {
        if (char in bracketMap) {
            // If the character is an opening bracket, push it onto the stack
            stack.push(char);
        } else {
            // If the character is a closing bracket
            let lastOpeningBracket = stack.pop();
            if (!lastOpeningBracket || char !== bracketMap[lastOpeningBracket]) {
                // If there's no corresponding opening bracket or it doesn't match
                return false;
            }
        }
    }
    
    // If the stack is empty, all brackets are matched
    return stack.length === 0;
};

// Example usage
console.log(isValid("()"));      // Output: true
console.log(isValid("()[]{}"));  // Output: true
console.log(isValid("(]"));      // Output: false


