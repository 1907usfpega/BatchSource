var homework = 
{
    fibonacci : function(num)
    {
        //declaring our variables
		let n2 = 0;
		let n1 = 1;
        let temp = 0;
        if(num == 0)
        {
            return 0;
        }
		//using number as our starting point, loop down until we hit 2
		for(i = num; i>=2; i--)
		{
			//store n2 in temp
			temp = n2;
			//set n2 equal to n1
			n2 = n1;
			//increment n1 by temp
			n1 = n1 + temp;
        }
        console.log(n1);
        return n1;
    },

    arraysort : function(list)
    {
        //int used for swapping
		let temp = 0;
		//loop through the whole list
		for(i = 0; i < list.length-1; i++)
		{
			//loop through the rest of the list from i
			for(j = 0; j < list.length-i-1; j++)
			{
				//if the number in the current index is greater than the number in the index to the right
				if(list[j] > list[j+1])
				{
					//swap em around, using the temp to hold the value while we swap
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
		return list;
    },

    factorial : function(num)
    {
        //if we are at the end
		if(num <= 1)
		{
			return 1;
		}
		else
		{
			//recursive call to the number-1
			return num * homework.factorial(num-1);
		}
    }
}

window.onload = function()
{
    document.getElementById("Q1").innerHTML = "Question 1, Fibonacci(0): "+homework.fibonacci(0)+", Fibonacci(1): "+homework.fibonacci(1)+", Fibonacci(10): "+homework.fibonacci(10);
    document.getElementById("Q2").innerHTML = "Question 2, Array Sort([2,4,5,1,3,1]): "+homework.arraysort([2,4,5,1,3,1])
    document.getElementById("Q3").innerHTML = "Question 3, Factorial(0): "+homework.factorial(0)+"Factorial(1): "+homework.factorial(1)+"Factorial(6): "+homework.factorial(6);
    //console.log(homework.fibonacci(2));
    //pokemon.moves[0].move.name
}
