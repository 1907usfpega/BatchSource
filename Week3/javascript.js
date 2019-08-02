//JavaScript is not related to Java
//not compiled -interpreted
//loosely typed= variable types are assigned at runtime
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
i=function{}{};
j=(4);
/*Datatypes
    primitives
        boolean
            true or false
            XD
            ALSO
            we have truthy and falsy
            Falsy
            undefined
            null
            false
            **

            NaN
            Truthy
                True
                1
                Everything that isnt falsy
                Object

        number
        string
        undefined
        symbol
        null
*/
//console.log(5==5);
//console.log(5=="5");
//console.log(5==="5");
console.log("test:");
console.log(false==1);
console.log(false==0);
console.log(true==1);
console.log(true==12);//false
console.log("5"!==5);

console.log(7+7+7);
console.log(7+7+"7");
console.log("7"+7+7);
console.log(7+"7"+7);

//objects in JS
//property -value pairs

//object literal
var person={
    "name": "Jimmy",
    "age": 74
};
person.numOfFeet=2;

function Human(name,age){
    this.name=name;
    this.age=age;

}
//Marker function
function makeHuman(name,age){
    var h{};
    h.name=name;
    h.age=age;
    return h;
}
//another Maker Function
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
arr[1000]="why";

//funtions- 3 innovations 
//function form- "this" refers to the global object.
//in browser it is "window"
function divideByZero(kitty,kat) {
console.log("hey kitty kitty");
return (kitty-kat);
}
//Constructor form- "this" refers to the object being created
var conFunc=new function(a,b){
    return a*b;

}
//method- "this" refers to person
person.getInfo=function(){
    return this.age;

}
crazy =function(at, least, three){
    console.log(at);
    console.log(least);
    console.log(three);
}

//closure- an inner function that has access to the outer function's variable(scope chain)
//closure mimics encapsulation
//has 3 scopes
//1. it has access to its own scope
//2. it has access to the out function's variables
//3. it has access to the global variables
//var count=0;
//function add(){
    //count++;
    //return count;

//}

// function add(){
//     var count=0;
//     function plus (){
//         count +=1;
//         return count;
//     }
// }
//with closure
// var add= (function(){
//     let count=0;
//     return function(){
//         count+=1;
//         return count;

//     }

// })