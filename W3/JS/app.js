//javascript is not compiled-interpreted, loosely typed= variable type are assigned at runtime.
var a = 10;
console.log(a);
a = "Chaos";
console.log(a);

var b, c, d, e, f, g, h, e;
b = "10";
c = true;
d = {}; //object
e = null;
g = (0 / 0);
h = []; //array
i = function () {};
j = 4;
//underfined has been declared, not defined has not been declared
/*datatypes 
primitives: 
boolean- true or false also truthy and falsy
    falsy: 0,underfined,null,false,"",NaN
    truthy:true,everything that isn't falsy, object
number-
string-
undefined-
symbol-
null-
objects-
*/
// console.log(5 == 5);
// console.log(5 == "5"); //type coercion-don't care about the type
// console.log("Tests: ")
// console.log(false == 1); //false
// console.log(false == 0); //true 0 is a falsy value
// console.log(true == 1); //true
// console.log(true == 12); //false
// console.log(false == 1); //false
// console.log("5" !== 5); //true

console.log(7 + 7 + 7);
console.log(7 + 7 + "7"); //147 because 7+7 is 14 and last 7 is a string
console.log("7" + 7 + 7); //777 because the first 7 is a string
console.log(7 + "7" + 7); //777

/*objects in JS, value pairs, objects are dynamic
object literal */
var person = {
    "name": "Jimmy",
    "age:": 74
};

person.numOfFeet = 2;

//constructor
function Person(name, age) {
    this.name = name;
    this.age = age;
}
//maker function
function makeHuman(name, age) {
    var h = {};
    h.name = age;
    h.age = age;
    return h;
}
//Another maker function
function makeHuman2(name, age) {
    var p = {
        "name": name,
        "age": age

    }
    return p;
}
//arrays
var arr = [10, 20, 30, "ft"];

//functions -3 invocations
//function form - this refers to the glocal object. in browser it is window
function divideByZero(kitty, kat) {
    console.log("hello");
    return (kitty + kat);
}

//constructor form-this refers to the object being created
var conFunc = new function (a, b) {
    return a * b;
}

//method-this refers to the person object
person.getInfo = function () {
    return this.age;
}
//javascript cannot overload
crazy = function (at, least, three) {
    console.log(at);
    console.log(least);
    console.log(three);
    console.log(arguments[5]);
}

/*scopes-runtime of a variable
function globe=nested inside the function
global scope=declare outside of a function, accessible anywhere
shadowing, same variable name, used the one declared on the most recentl.
"let" does not escape blocks (scopes), "var" does
hoisting moves declaration to the top of the scope
implicit blobals is variable declared in function scope wihout the var keyword.
*/

/*closure- a function inside of a function that has access to the outer function's variable(scope chain)
mimics encapsulation
it has access to its own scope, has access the outer function's variables,has access to the gloval variables
*/

// function add() {
//     var count = 0;

//     function plus() {
//         count += 1;
//         return count;
//     }
// }

//with closure
var add = (function () {
    var count = 0;
    return function () {
        count += 1;
        return count++
    }
}());