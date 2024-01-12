function isCatSound(X) {
    // Characters in the cat sound
    const catSoundChars = ['m', 'e', 'o', 'w'];

    // Variable to keep track of the current cat sound character index
    let catSoundIndex = 0;

    // Iterate through the string X
    for (let i = 0; i < X.length; i++) {
        const char = X.charAt(i);

        // If the current character matches the current cat sound character
        if (char === catSoundChars[catSoundIndex]) {
            catSoundIndex++;
            console.log("test");
            // If all cat sound characters have been found
            if (catSoundIndex === catSoundChars.length) {
                console.log("dung");
                return true;
            }
        }
    }

    // If not all cat sound characters were found
    return false;
}

// Test the function with example strings
const X1 = "mmmmeoooow";
const X2 = "meow";
const X3 = "meowwww";
const X4 = "mmeeooww";
const X5 = "meo";
const X6 = "mow";
const X7 = "mew";
const X8 = "maaow";

console.log(isCatSound(X1)); // true
console.log(isCatSound(X2)); // true
console.log(isCatSound(X3)); // true
console.log(isCatSound(X4)); // true
console.log(isCatSound(X5)); // false
console.log(isCatSound(X6)); // false
console.log(isCatSound(X7)); // false
console.log(isCatSound(X8)); // false
