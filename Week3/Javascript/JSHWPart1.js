var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function (n) {
    // console.log(n);
    var fib;
    if (n < 2) {
        fib = n;
    }
    else {
        fib = this.fibonacci(n - 2) + this.fibonacci(n - 1);
        //there's probably a better way to do this that doesn't involve recursion twice for each, buuuuut this does work, so.
    }
    //console.log("fib " + n + ": " + fib);
    return fib;
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function (array) {
    //bubblesort! Just because.
    var sorted;
    var arr = array;
    do {
        sorted = true;
        for (i = 0; i < arr.length - 1; i++) {
            //compare current value to next value
            if (arr[i] > arr[i + 1]) {
                sorted = false; //it wasn't sorted
                //swap the values
                let temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }//end for
    } while (!sorted);//if we had to do any swaps, do another loop


    return arr;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function (n) {
    var f;
    if (n < 2) {
        f = 1;
    }
    else {
        f = homework.factorial(n - 1) * n;
    }
    //console.log(n+"! = "+f)
    return f;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function (array, n) {
    n = n % array.length;
    var i;
    var arr = array;
    for (i = 0; i < n; i++) {
        let first = arr[0];
        let j;
        for (j = 0; j < array.length - 1; j++) {
            arr[j] = arr[j + 1];
        }
        arr[arr.length - 1] = first;
        //console.log(array);
    }
    return arr;
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
homework.balancedBrackets = function (bracketsString) {
    var l = bracketsString.length;
    var balanced = true;
    /* for (let i = 0; i < l / 2 && balanced; i++) {
        let b1 = bracketsString[i];
        let b2 = bracketsString[l - 1 - i];
        //console.log("compare: " + b1 + b2);
        if (
            (b1 == "(" && b2 == ")") ||
            (b1 == "[" && b2 == "]") ||
            (b1 == "{" && b2 == "}")
        ) {
            //console.log("yes!");
        }
        else {
            //console.log("no");
            balanced = false;
        }
    }//end for */

    let stack = [];
    for (let j = 0; j < l && balanced; j++) {
        switch (bracketsString[j]) {
            case "{":
                stack.push("{");
                break;
            case "[":
                stack.push("[");
                break;
            case "(":
                stack.push("(");
                break;
            case "}":
                if (stack.pop() != "{") {
                    balanced = false;
                }
                break;
            case "]":
                if (stack.pop() != "[") {
                    balanced = false;
                }
                break;
            case ")":
                if (stack.pop() != "(") {
                    balanced = false;
                }
                break;
        }//end switch
    }//end for

    if (stack.length != 0) {
        balanced = false;
    }
    return balanced;
};


