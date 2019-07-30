// JavaScript is NOT related to Java
// NOT COMPILED, IT IS INTERPRETED
// Loosely typed = variable types are assigned at run time
var a = 10;
console.log(a);
a = "chaos";
console.log(a);
var b,c,d,e,f,g,h,e;
b="10";
c=true;
d={}; //object
e=null;
g=(0/0);
h=[]; //array
i = function(){}
j=4;
/*
DATATYPES
  PRIMITIVES
    boolean
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
          everything that isn't falsy
          Object
    number
    string
    undefined
    symbol
    null
  OBJECTS
*/
// console.log(5==5);
// console.log(5=="5");
// console.log(5==="5");
console.log("Test:");
console.log(false==1);  //false
console.log(false==0);  //true
console.log(true==1);   //true
console.log(true==12);  //false
console.log(false==1);  //false
console.log("5"!==5)    //true

console.log(7+7+7);
console.log(7+7+"7");
console.log("7"+"7"+"7");

var person = {
  "name": "Jimmy",
  "age": 74
};
person.numOfFeet=2;

function Human(name,age) {
  this.name=name;
  this.age=age;
};

//Maker function
function makeHuman(name,age) {
  var h={};
  h.name=name;
  h.age=age;
  return h;
}

//Another Maker function
function makeHuman2(name,age) {

  var p={
    "name":name,
    "age":age
  }
  return p;
}

//Arrays
var arr=[10,20,30];
arr[9]=5;
arr[1000]="Why";

//Functions
// 3 invocations
// 1.) Function form
  // "this" refers to the global object.
  // in browser it is "window"
function divideByZero(Kitty,Kat) {
  console.log("hey kitty kitty");
  return Kitty+Kat;
}
// 2.) Constructor form
  // "this" refers to the object being created
var conFunc = new function(a,b) {
  return a*b;
}
// 3.) Method
  // "this" refers to person
person.getInfo = function() {
  return this.age;
}

crazy = function(at, least, three) {
  console.log(at);
  console.log(least);
  console.log(three);
  console.log(arguments[5]);
}

/*
SCOPES
FUNCTION SCOPE
  THINGS THAT ARE DECLARED INSIDE A FUNCTION.
  USE THE "var" KEYWORD. IF YOU LEAVE OUT "var," YOU'LL CREATE AN IMPLICIT GLOBAL.
  ACCESSIBLE ONLY INSIDE THE FUNCTION.

GLOBAL SCOPE
  DECLARED OUTSIDE OF ANY FUNCTION. ACCESSIBLE ANYWHERE.
  SHADOWING - IF MULTIPLE VARIABLES HAVE THE SAME NAME, JS WILL USE THE ONE THAT WAS
  DECLARED THE MOST RECENTLY. VARIABLE NAME CLASHES ARE BAD. DIFFICUT TO DEBUG AND TEST.
  "let" DOES NOT ESCAPE BLOCKS, BUT "var" DOES.
  HOISTING - MOVES DECLARATION TO TOP OF SCOPES
  WATCH OUT!!
  IMPLICIT GLOBALS - VARIABLES DECLARED IN FUNCTIONAL SCOPE WITHOUT THE "var" KEYWORD,
  UNLESS YOU'RE IN STRICT MODE.
  GENERALLY, STAY AWAY FROM USING GLOBALS.
*/

/* CLOSURE - AN INNER FUNCTION THAT HAS ACCESS TO THE OUTER FUNCTION'S VARIABLE (SCOPE CHAIN)
   HAS THREE SCOPE CHAINS:
   1.) IT HAS ACCESS TO ITS OWN SCOPE (VARIABLES DEFINED BETWEEN ITS CURLY BRACES)
   2.) IT HAS ACCESS TO THE OUTER FUNCTION'S VARIABLES
   3.) IT HAS ACCESS TO THE GLOBAL VARIABLES
*/

// var count = 0;
// function add() {
//
//   count++;
//   return count;
// }

// function add() {
//   var count = 0;
//   count++;
//   return count;
// }

// function add() {
//   var count = 0;
//   function plus() {
//     count += 1;
//     return count;
//   }
// }

// WITH CLOSURE
var add = (function(){
  var count = 0;
  return function(){
    count += 1;
    return count;
  }
}());
