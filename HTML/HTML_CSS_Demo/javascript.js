var a = 10;
console.log(a);
a="chaos";
console.log(a);
var b, c, d, e, f, g, h, e, i;
b="10";
c=true;
d={};
e=null;
i=function(){};
g=(0/0);
h=[];
console.log(f);

var person = {
    "name": "Jimmy",
    "age":"74"
}

person.numOfFeet=2;

console.log(person);

/*class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
}*/

function Person(name, age)
{
    this.name = name;
    this.age = age;
}
p = new Person("sds", 12);
console.log(p);

//maker function

function makePerson(name, age)
{
    var p ={
        "name":name,
        "age":age
    }
    return p;
}

var arr = [10,20,30];
arr[9] = 5;

//three function invocations

//function form, "this" refers to the global object
function divideByZero(kitty, kat)
{
    console.log("What's New Pussycat?");
    return(kitty+kat);
}

//constructor form: "this" refers to the object being created

var conFunc = new function(a, b)
{
    return a*b;
}

//method: "this" refers to person

person.getInfo = function(){
    return this.age+2;
}
//overloading aint possible in javascript
crazy = function(at, least, three)
{
    console.log(at);
    console.log(least);
    console.log(three);
}

//build a reusable counter
/*var count = 0;
function add()
{
    return count++;
}*/

/* function add()
{
    var count = 0;
    return ++count;
} */

var add = (function(){
    let count = 0; //or var
    return function(){
        return ++count;
    }
}());