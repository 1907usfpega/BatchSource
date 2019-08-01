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
	},
	
	rotateLeft : function(array, n)
	{
		let rotateAmt = (n % array.length)-1;
		let temp = 0;
		let newArr = [];
		for(i = 0; i < array.length; i++)
		{
			newArr[array.length-1-i] = array[rotateAmt-i];
		}
		for(i = array.length-rotateAmt-2; i >= 0; i--)
		{
			newArr[i] = array[i+rotateAmt+1];
		}
		
		return newArr;
	},

	balancedBrackets : function(bracketsString)
	{
		if(bracketsString.length % 2 != 0)
		{
			console.log("odd length");
			return false;
		}

		let pairsCount = 0;

		for(i = 0; i < bracketsString.length; i++)
		{
			if(bracketsString.charAt(i) == '(')
			{
				console.log("left parenthesis");
				for(j = i; j < bracketsString.length; j++)
				{
					if(bracketsString.charAt(j) == ')')
					{
						console.log("right parenthesis");
						pairsCount++;
						break;
					}
				}
			}
			else if(bracketsString.charAt(i) == '{')
			{
				console.log("left brace");
				for(j = i; j < bracketsString.length; j++)
				{
					if(bracketsString.charAt(j) == '}')
					{
						console.log("right brace");
						pairsCount++;
						break;
					}
				}
			}
			else if(bracketsString.charAt(i) == '[')
			{
				console.log("left bracket");
				for(j = i; j < bracketsString.length; j++)
				{
					if(bracketsString.charAt(j) == ']')
					{
						console.log("right bracket");
						pairsCount++;
						break;
					}
				}
			}
		}

		if(pairsCount == (bracketsString.length/2))
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}

window.onload = function()
{
    document.getElementById("Q1").innerHTML = "Question 1: \n Fibonacci(0): "+homework.fibonacci(0)+"\n Fibonacci(1): "+homework.fibonacci(1)+"\n Fibonacci(10): "+homework.fibonacci(10);
    document.getElementById("Q2").innerHTML = "Question 2: \n Array Sort([2,4,5,1,3,1]): "+homework.arraysort([2,4,5,1,3,1])
    document.getElementById("Q3").innerHTML = "Question 3: \n Factorial(0): "+homework.factorial(0)+" \n Factorial(1): "+homework.factorial(1)+"\n Factorial(6): "+homework.factorial(6);
	document.getElementById("Q4").innerHTML = "Question 4: \n Rotate Left([1,2,3,4,5],3): "+homework.rotateLeft([1,2,3,4,5],3);
	document.getElementById("Q5").innerHTML = "Question 5: \n Balanced Brackets(\"()\"): "+homework.balancedBrackets("()")+"\n Balanced Brackets(\"(())\"): "+homework.balancedBrackets("(())")+"\n Balanced Brackets(\"({){\"): "+homework.balancedBrackets("({){");
}
