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





