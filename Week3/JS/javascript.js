//JavaScript is NOT related to Java
//not  compiled- interpreted
//Loosely typed= variable types are assigned at runtime
var a=10;
console.log(a);
a= "chaos";
console.log(a);
var b,c,d,e,f,g,h,e;
b="10";
c=true;
d= {};//object
e=null;
g=(0/0);
h=[];//array
i=function(){};
j=4;
/*Datatypes
    primitives
        boolean
            true or false 
            XD
            ALSO
            we have truthy  and falsy
                Falsy
                    0
                    undefined
                    null
                    false
                    ""
                    NaN
                Truthy
                    True
                    1
                    Everything that isn't falsy
                    Object
        number
        string
        undefined
        symbol
        null
    objects    
*/
//Type coercion
//console.log(5==5);
//console.log(5=="5");
//console.log(5==="5");
/*
console.log("Tests:")
console.log(false==1);
console.log(false==0);
console.log(true==1);
console.log(true==12);//false
console.log(false==1);
console.log("5"!==5);
*/
console.log(7+7+7);
console.log(7+7+"7");
console.log("7"+7+7);
console.log(7+"7"+7);

//Objects in JS
//property -value pairs

//object literal
var person= {
    "name": "Jimmy",
    "age": 74
};
person.numOfFeet=2;

function Human(name,age){
    this.name=name;
    this.age=age;
}
//Maker function
function makeHuman(name,age){
    var h={};
    h.name=name;
    h.age=age;
    return h;
}
//Another Maker Function
function makeHuman2(name,age){
    var p={
        "name":name,
        "age":age

    }
    return p;
}
//Arrays
var arr=[10,20,30];
arr[9]=5;
arr[1000]="WHy";
//functions- 3 invocations
//function form- "this" refers to the global object.
//in browser it is "window"
function divideByZero(kitty,kat){
    console.log("hey kitty kitty");
    return (kitty+kat);
}
//Constructor form- "this" refers to the object being created
var conFunc= new function(a,b){
    return a*b;
}
//Method- "this" refers to person
person.getInfo= function(){
    return this.age;
}

crazy = function(at, least,three){
    console.log(at);
    console.log(least);
    console.log(three);
    console.log(arguments[5]);
}
// Scopes
// Function Scope
// Things that are declared inside a function.
// Use the “var” keyword. If you leave out “var,” you’ll create an implicit global.
// Accessible only inside the function.
// Global Scope
// Declared outside of any function. Accessible anywhere.
// Shadowing - if multiple variables have the same name, JS will use the one that was 
//declared the most recently. Variable name clashes are bad. Difficult to debug and test.
//"let" does not escape blocks, "var" does
//Hoisting-moves declaration to top of scope
// WATCH OUT!!
// Implicit Globals - variables declared in functional scope without the “var” keyword, 
//unless you’re in strict mode.
// Generally, stay away from using globals.

//Closure- an inner function that has access to the outer function's variable(scope chain)
// closure mimics encapsulation
//has 3 scope chains:
//1. it has access to its own scope( variables defined between its curly braces)
//2. it has acess the outer function's varibles
//3. it has access to the global variables

//Build a reusable conunter
/*var count=0;
function add(){
    count++;
    return count;
}

function add(){
    var count=0;
    count++;
    return count;
}

function add(){
    var count =0;
    return function plus(){
        count +=1;
        return plus;
    }

}*/
//With Closure!
var add= function(){
   var count=0;
    return function (){
        count+=1;
        return count;
    }
}();