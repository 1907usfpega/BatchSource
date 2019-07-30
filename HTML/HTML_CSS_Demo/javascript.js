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

function makePerson()
{
    
}