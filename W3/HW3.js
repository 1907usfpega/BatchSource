var homework = {};

homework.fibonacci = function(n) {
    // if (typeof(n) == )

    if (n == 0 || n == 1) {
        return n;
    } else {
        return this.fibonacci(n - 2) + this.fibonacci(n - 1);
    }
}

homework.sort = function(array) {
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array.length - i - 1; j++) {
            let first = array[j];
            let second = array[j + 1];
            if (first > second) {
                array[j] = second;
                array[j + 1] = first;

            }

        }
    }
    return array;
}


homework.factorial = function(n) {
    if (n < 2) {
        return 1;
    } else {
        return n * this.factorial(n - 1);
    }
};

homework.rotateLeft = function(array, n) {
    n = n % array.length;
    for (let i = 0; i < n; i++) {
        let temp = array[0];
        for (let j = 0; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }
        array[array.length - 1] = temp;
    }
    return array;
};

homework.roateLeft2 = function(array, n) {
    let array2 = [];
    for (let i = 0; i < array.length; i++) {
        array2[i] = array[i + (n % array.length)];

    }
    return array2;
};

homework.balancedBrackets = function(bracketsString) {
    let stack = [];
    let characters = bracketsString.split("");
    for (let i = 0; i < characters.length; i++) {
        switch (characters[i]) {
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
                if (stack.pop() != "{") {
                    return false;
                }
                break;
            case "]":
                if (stack.pop() != "[") {
                    return false;
                }
                break;
        };
    }
    return (stack.length == 0);
};