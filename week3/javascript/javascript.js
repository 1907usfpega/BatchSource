//not related to java
//not compiled but interpreted
var a=10;
console.log(a);
a="chaos";
console.log(a);

var b,c,d,e,f,g,h,e;
b="10";
c=true;
d={};
e=null;
g=(0/0);
h=[];

i=function(){};

/*datatypes
    primitives
        boolean
            true or false (1 or 0)
            ALSO
            truthy or falsy
                falsy values
                    0, undefined, null, false, "", NaN
                truthy values
                    true, everything that isnt falsy, object
        number

        string
        undefined
        symbol
    


*/
//type coercion
/*console.log(5==5);
console.log(5=="5");
console.log(5==="5");
*/
console.log("tests:");
console.log(false==1);//false
console.log(false==0);//true
console.log(true==1);//true
console.log(true==12);//false
console.log(false==1);//false
console.log("5"!==5);//true


function Human(name,age){
    this.name=name;
    this.age=age;
}
//maker function
function makeHuman(name,age){
    var h{};
    h.name=name;
    h.age=age;
    return h;
}
//maker function
function makeHuman2(name,age){
    var p={
        "name":name,
        "age":age
    }
    return p;
}

var arr=[10,20,30];
arr[9]=5;
arr[1000]="why";

//this refers to global object in function form
//in constructor form "this" is preceding object
//method form "this" refers to person

crazy = function (at,least,three){
    console.log(at);
    console.log(least);
    console.log(three);
}


//javascript cant overload