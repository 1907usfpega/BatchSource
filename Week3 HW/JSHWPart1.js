var homework = {};
homework.fibonacci = function fib(n){ //completed
  let count = -1;
  let a = 0;
  let b = 1;
  let c;
  let f;
  if (n==0){
    return 0;
  }
  else if (n==1){
    return 1;
  }
  else{
    while (count < n){
      f = a;
      c = a + b;
      a = b;
      b = c;
      count += 1;
    }
    return f;
  }
};

homework.sort = function sort(arr){ //completed
  let n = arr.length;
  for(let i=0; i<n-2; i++){
    for(let j=0; j<n-i-1; j++){
      if(arr[j] > arr[j+1]){
        let temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
      }
    }
  }
  return arr;
};

homework.factorial = function factorial(n){ //completed
  let factorial = 1;
  while(n > 1){
    factorial *= n;
    n -= 1;
  }
  return factorial;
};

homework.rotateLeft = function(arr, n){ //completed
  let count = 0;
  while(count<n){
    arr[arr.length] = arr[0]; //put first item at end of array
    arr.shift(); //remove item from beginning of array & this will update arr.length
    count++;
  }
  return arr;
};

homework.balancedBrackets = function (bracketsString){
  let arr = [] //use as stack so it's LIFO
  pairs = {
    //list opening brackets as key & closing brackets as value
    "(":")",
    "[":"]",
    "{":"}"
  };

  //treat string as character array
  //& loop thru
  for(let i=0; i<str.length; i++){
    //Opening brackets?
    if(str[i]=="(" || str[i]=="[" || str[i]=="{"){
      arr.push(str[i]); //append
    }
    //closing brackets
    else if (str[i]==")" || str[i]=="]" || str[i]=="}"){
      if(arr.length==0){
        return false; //encountered closing bracket with no opening bracket
      }
      //let last = arr[arr.length-1]
      let last = arr.pop(); //get last opening bracket
      //if closing pair doesn't match opening pair from pairs
      if(str[i]!=pairs[last]){
        return false;
      }
    }
  }

  if (arr.length!=0){
    //return false for strings like (()
    return false;
  }

  return true;
}