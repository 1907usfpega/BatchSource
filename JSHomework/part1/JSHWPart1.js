var homework = {
	fib : function(n) {
		if (typeof(n) !== 'number') {
			console.log("Cannot find the fibonacci number of something that isn't a number :)");
			return null;
		}
		if (n === 0 || n === 1) {
			return n
		}
		i = 2;
		minus1 = 0;
		minus2 = 1;
		output = 1;
		while(i <= n) {
			output = minus1 + minus2;
			minus1 = minus2;
			minus2 = output;
			i++;
		}
		return output;
	},

	bubbleSort : function(inArr) {
		if (!Array.isArray(inArr)) {
			console.log("Hey! That's not an array ya dingus!");
			return null;
		}

		for(i = 1; i < inArr.length; i++) {
			for(j = 0; j < inArr.length - 1; j++) {
				if(inArr[j] > inArr[j+1]) {
					temp = inArr[j];
					inArr[j] = inArr[j+1];
					inArr[j+1] = temp;
				}
			}
		}
		return inArr;
	},

	nFactorial : function(n) {
		if (typeof(n) !== 'number') {
			console.log("How am I supposed to factorialize something that's not a number?");
			return null;
		}
		if (n === 0 || n === 1) {
			return 1;
		}
		out = n;
		for(i = n; i > 2; i--) {
			out = out * (i-1);
		}
		return out;
	},

	rotateLeft : function(inArr, rotNo) {
		if(!Array.isArray(inArr)) {
			console.log("First input needs to be an array...");
			return null;
		}
		if(typeof(rotNo) !== 'number') {
			console.log("Why are you doing this? Just give me a number in the second parameter.");
			return null;
		}

		while(rotNo > 0) {
			temp = inArr[0];
			i = 0;
			while(i < inArr.length) {
				inArr[i] = inArr[++i];
			}
			inArr[inArr.length-1] = temp;
			rotNo--;
		}
		return inArr;
	},

	balancedBrackets : function(bracketsString) {
		if(typeof(bracketsString) !== 'string') {
			console.log("That's not even a string >:(");
			return null;
		}
		if(bracketsString.length % 2 !== 0) {
			return false;
		}
		bracketArr = [];
		for(i = 0; i < bracketsString.length; i++) {
			if(bracketsString.charAt(i) === '(') {
				bracketArr.push('(');
			} else if(bracketsString.charAt(i) === '[') {
				bracketArr.push('[');
			} else if(bracketsString.charAt(i) === '{') {
				bracketArr.push('{');
			} else if(bracketsString.charAt(i) === ')') {
				if(bracketArr[bracketArr.length-1] === '(') {
					bracketArr.pop();
				} else {
					return false;
				}
			} else if(bracketsString.charAt(i) === ']') {
				if(bracketArr[bracketArr.length-1] === '[') {
					bracketArr.pop();
				} else {
					return false;
				}
			} else if(bracketsString.charAt(i) === '}') {
				if(bracketArr[bracketArr.length-1] === '{') {
					bracketArr.pop();
				} else {
					return false;
				}
			} else {
				console.log("You gave me something that's not a bracket... Seriously?!?");
				return false;
			}
		}
		return true;
	},

	trueOrFalse : function(i) {
		if(i) {
			return true;
		} else {
			return false;
		}

		// i = -1;
		// if(i) {
		// 	return true;
		// } else {
		// 	return false;
		// }
		//
		// i = [];
		// if(i) {
		// 	return true;
		// } else {
		// 	return false;
		// }
		//
		// i = 0;
		// if(i) {
		// 	return true;
		// } else {
		// 	return false;
		// }
		//
		// i = null;
		// if(i) {
		// 	return true;
		// } else {
		// 	return false;
		// }
		//
		// i = 17;
		// if(i) {
		// 	return true;
		// } else {
		// 	return false;
		// }
	}
};
