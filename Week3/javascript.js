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