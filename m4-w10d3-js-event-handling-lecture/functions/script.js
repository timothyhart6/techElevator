/* #########################################
Function Expressions and Anonymous Functions
######################################### */
function evenNumbers(num) {
    return num % 2 == 0;
}

function oddNumbers(a) {
    return a % 2 != 0;
}

function ourNumbers(doug) {
    return doug > 2 && doug < 8;
}
//We've seen function declarations that allow us to write reusable code like this: 

function speak(numberOfTimes) {
  for(var i = 0; i < numberOfTimes; i++) {
      console.log("WOOF");   
  }
}

speak(5);

/* We can assign a function to a variable. This is called a "function expression". 
When using this approach, we don't need to provide a function name (unless we want 
to recursively call it). */

// Note that we are assigning an anonymous function to a variable named `fly`.
var fly = function(num) {
    for(var i = 0; i < num; i++) {
        console.log("I'm flying!!");   
    }   
};

fly(3); // here we use the `fly` variable to invoke the function.

var makeDogSound = speak;

makeDogSound(10);

var thinkHappyThoughts = fly;

thinkHappyThoughts(20);

function filter(things, b) {
    var results = [];
    for(var i = 0; i < things.length; i++) {
        if(b(things[i])) {
            results.push(things[i]);
        }
    }
    return results;
}



var input = ['1','2','3','4','5','6','7','8','9'];

console.log(filter(input, evenNumbers));
console.log(filter(input, oddNumbers));
console.log(filter(input, ourNumbers));
console.log(filter(input, function(num){
    return num > 4;
}));

function sumArray() {
    let arr = [1, 2, 3, 4];
    let sum = 0;

    arr.forEach(function(element) {
        if (element %2 == 0) {
            sum += element;
        }
    }); 
    console.log(sum);
}
