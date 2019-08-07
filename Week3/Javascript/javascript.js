// JavaScript is NOT related to Java!!
// not compiled, instead interpreted
// loosely typed -- variable typs are assigned at runtime

var a = 10;
console.log(a);

a = "chaos"
console.log(a);

var b,c,d,e,f,g,h,e;
b = "10";
c = true;
d = {}; //object
e = null;
g = (0/0);
h = []; //array

i = function(){};
j = 4;

//type coercion
/*
console.log(5==5);
console.log(5=="5");
console.log(5==="5");
*/

console.log(false==1); // false
console.log(false==0); // true
console.log(true==1); // true
console.log(true==12); // false
console.log(false==1); // false
console.log("5"!==5); // true

console.log(7+7+7); //21
console.log(7+7+"7"); //147
console.log("7"+7+7); //777
console.log(7+"7"+7); //777



//object in JS
//property-value pairs

//object literal
var person = {
    "name": "Jimmy",
    "age": 74
};

person.numOfFeet = 2;

//constructor
function Human(name, age){
    this.name = name;
    this.age = age;
}

//Maker function
function makeHuman(name, age){
    var h={};
    h.name = name;
    h.age = age;
    return h;
}
//Another Maker function
function makeHuman2(name, age){
    var p ={
        "name":name,
        "age":age
    }
    return p;
}

//Arrays
var arr = [10,20,30];
arr[9] = 5;
arr[100] = "why??";


//Functions - 3 invocations
//function form - "this" refers to the global object
function divideByZero(kitty,kat){
    console.log("hey, kitty kitty");
    return (kitty+kat);
}
//constructor form - "this" refers to the object being created
var conFunc = new function(a,b){
    return a*b;
}
//method form - "this" refers to person
person.getInfo = function(){
    return this.age;
}


crazy = function(at, least, three){
    console.log(at);
    console.log(least);
    console.log(three);
    console.log(arguments[5]);
}


//Build a reusable counter
/*
var count = 0;
function add(){
    count++;
    return count;
}
*/

// function add(){
//     var count =0;
//     count++;
//     return count;
// }

// function add(){
//     var count = 0;
//     function plus(){
//         count+=1;
//         return count;
//     }
// }

//WITH CLOSURE!
var add = (function(){
    var count = 0;
    return function(){
        count+=1;
        return count;
    }
}());










