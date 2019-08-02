
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    if (typeof(n) !== 'number') {return null;}

    if (n < 2) {
        return n;
    } else {
        return this.fibonacci(n-2) + this.fibonacci(n-1);     
    }
    
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array.length-i-1; j++) {
            let first = array[j];
            let second = array[j+1];

            if (first > second) {
                array[j] = second;
                array[j+1] = first;
            }
        }
    }
    return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    if (n < 2) {
        return 1;
    } else {
        return n * this.factorial(n-1);
    }
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    n = n % array.length;
    
    for(let i = 0; i<n; i++) {
        let temp = array[0];
        for (let j = 0; j < array.length-1; j++) {
            array[j] = array[j+1];
        }
        array[array.length-1] = temp;
    }
    return array;
};

homework.rotateLeft2 = function(array, n) {
    let array2 = [];

    for(let i = 0; i<array.length;i++) {
        array2[i] = array[(i+n) % array.length];
    }
    return array2;
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){

    let stack = [];
    let characters = bracketsString.split("");

    for(let i = 0; i<characters.length; i++) {
        switch(characters[i]) {

            case "{":
                stack.push(characters[i]);
                break;
            case "[":
                stack.push(characters[i]);
                break;
            case "(":
                stack.push(characters[i]);
                break;

            case "}":
                if(stack.pop() != "{") {
                    return false;
                }
                break;
            case "]":
                if(stack.pop() != "[") {
                    return false;
                }
                break;
            case ")":
                if(stack.pop() != "(") {
                    return false;
                }
                break;
        }
    }
/*
    if (stack.length != 0) {
        return false;
    }

    return true;
*/

    return (stack.length == 0);

};



