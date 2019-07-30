//Javascript is NOT related to Java
//not compiled- it is interpreted
//lossely typed- variable type are assigned at runtime
var a = 10;
console.log(a);
a = "chaos";
console.log(a);
var b, c, d, e, f, g, h, e;
b = "10";
c = true;
d = {}; //this is an object
e = null;
g = (0 / 0);
h = []; // this is an array
i = function () {};
j = 4;

//difference between undefined and not defined
//undefined has been delcare but not instancated
//not defined has never been declared
/*Datatypes
    primitives
        Boolean
            true or false
            XD
            ALSO
            we have truthy and falsy
                falsy
                    0
                    undefined
                    null
                    false
                    ""
                    NaN
                
                truthy
                    true
                    1
                    "1"
                    Everything that isn't falsy
                    Object
                
        Number
        String
        Undefined
        Symbol
    Objects
    
*/
//type coercion
//don't care about the type
//console.log(5 == 5);
//console.log(5 == "5");
//check if the values are equal along with data type
//console.log(5 === "5");

console.log("Tests:"); //What i think      Answers
console.log(false == 1); //false             false
console.log(false == 0); //true              true
console.log(true == 1); //true              true
console.log(true == 12); //true              false
console.log(false == 1); //false             false
//!== is (not ===)
console.log("5" !== 5); //false             true

console.log(7 + 7 + 7); //21
console.log(7 + 7 + "7"); //147
console.log("7" + 7 + 7); //777
console.log(7 + "7" + 7); //777

//Objects in js
//property - value pairs
var person = {
    "name": "Jimmy",
    "age": 74
};
//can delcare fields for objects outside of initalization
//objects are very flexable
person.numOfFeet = 2;

function Human(name, age) {
    this.name = name;
    this.age = age;
}
//can do var Matt = new Human("matt", 33);
//Matt.name = matt
//Matt.age = 33

function makeHuman(name, age) {
    var h = {};
    h.name = name;
    h.age = age;
    return h;
}

function makeHuman2(name, age) {
    var p = {
        "name": name,
        "age": age
    }
    return p;
}

//Arrays
var arr = [10, 20, 30];

arr[9] = 5;
arr[1000] = "why!";
//fuctions - 3 invocations

//fuction form - "this" refers to the gloabal object
// in the browser it revers to windo
function divideByZero(kitty, kat) {
    console.log("hey kitty kitty")
    return (kitty + kat);

}

//constructor form - "this" referst to the object 
// being created
var conFunc = new function (a, b) {
    return a * b;
}

//method form - "this" refers to person
person.getInfo = function () {
    return this.age;
}

crazy = function (at, least, three) {
    console.log(at);
    console.log(least);
    console.log(three);
    console.log(arguments[5]);

}

/*
Scopes
Fuctions Scope
things that are declared inside a fuction
use the "var keyword" if you leave it out you create in implicit global
onlyy accessable in fcn
Global scope
declare outside of a fuction, Accessible anywhere
//shadowing - if multiple variablies ahve the same name, JS will use the one 
//that was create most recently
"let does not escape blocks, "var" does
Hoising moves delcaration to top of scope
EX//    var a = 1;          //global var a
        function1 () {      
        b = 6;              //global bc not var declaration
        }
        function2() {
        let c = 3;          //belongs to fuction2
        for ... {
        var d = 4           //belongs to fuction2, not to the for loop bc var
        }                   //if it was let then it would belong for loop
        
        }
WATCH OUT!!!!!!
Implicit globals - varialbe declared in fuctinal scopus without "var keyword
unless your in the strict mod
Generally, say awasy form using globals


Closure- an inner fuction that has acces to the outer fuction's varible(scope chain)
Closure mimips encapsulation
has 3 scop chains
1. it has access to its own scope( variable sdefined between it's curly braces)
2. it has acess to the outer fuctions's  varibles
3. it has access to the global variables
*/

//Build a reusable counter

/*
// outsider and affect it
var count = 0;

function add() {
    count++;
    return count;
}
*/

/*
always returns 1
function add() {
    var count = 0;
    count++;
    return count;
}*/


/*
undefined
function add() {
    var count = 0;
     function plus() {
        count+=1;
        return count;
    }
    
}*/

//With closure;
var add = (function () {
    let count = 0;
    return function () {
        count += 1;
        return count;
    }
}()); // the () make the inner fuction into an immeadiatly invoked fcn. 
