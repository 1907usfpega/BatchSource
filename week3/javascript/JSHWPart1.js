//Fill in the functions and submit them to your branch in a file called JSHWPart1.js
//gp
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    if (n<=1){
        return n;
    }
	else{
        return this.fibbonacci(n-1)+this.fibbonacci(n-2);
	}
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    var sorted=false;
	while(!sorted) {
		sorted=true;
		for (var j=0;j<array.length-1;j++) {
			if (array[j]>array[j+1]) {
				let temp=array[j+1];
				array[j+1]=array[j];
				array[j]=temp;
				sorted=false;
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
    if (n<=1)
		return 1;
	else
		return n*this.factorial(n-1);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
homework.rotateLeft = function(array, n) {
    let rotations = n%array.length;
    for (let i=0; i<rotations;i++){
        let hold=array[0];
		for (let j=0;j<array.length-1;j++) {
            //let temp=array[j+1];
			//array[j+1]=array[j];
			//array[j]=temp;
            //sorted=false;
            array[j]=array[j+1];
        }
        array[array.length-1]=hold;		
    }
    return array;
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
    let stack=[];
    let chars=bracketsString.split("");
    for(let i=0;i<chars.length;i++){
        switch(chars[i]){
            case "{":
                stack.push(chars[i]);
                break;
            case "[":
                stack.push(chars[i]);
                break;
            case "(":
                stack.push(chars[i]);
                break;
            case "}":
                if (stack.pop()!="}")
                    return false;
            case "}":
                if (stack.pop()!="]")
                    return false;
            case ")":
                if (stack.pop()!=")")
                    return false;   
        }
    }
    if(stack.length != 0) return false;
    return true;
};