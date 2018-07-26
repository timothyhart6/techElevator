/*
    Example of a multi-line comment just like in C#/Java    
*/

// Single line comment

// Functions start with the word function
// - They don't have a return type
function variables() {
    const daysPerWeek = 7;  //declares a variable which value cannot be changed    
    console.log(`There are ${daysPerWeek} days in the week.`);

    let daysPerMonth = 30;  //declres a variable where value can be changed
    daysPerMonth = "thirty";
    console.log(`There are ${daysPerMonth} days in the month.`);

    const weekdays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
    console.table(weekdays);
}

// Functions can accept parameters
//  - parameters do not define a data type
function printParameters(param1, param2) {
    console.log(`The value of param1 is ${param1}`);
    console.log(`The value of param2 is ${param2}`);
}


function equality(x, y) {

    console.log(`x ${x} is ${typeof x}`);
    console.log(`y ${y} is ${typeof y}`);
   
    console.log(`x == y : ${x == y}`);      // true
    console.log(`x === y : ${x === y}`);    // false
}

/* Objects are simple key-value pairs 
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {

    const person = {
        firstName: "Bill",
        lastName: "Lumbergh",
        age: 42,
        employees: [
            "Peter Gibbons",
            "Milton Waddams",
            "Samir Nagheenanajar",
            "Michael Bolton"
        ],
        toString: function () {
            return `${this.lastName}, ${this.firstName} (${this.age})`;
        }
    };
person.firstName = "Doug";
    console.table(person);

    console.log(`${person.firstName} ${person.lastName}`);

    for (let i = 0; i < person.employees.length; i++) {
        console.log(`Employee ${i + 1} is ${person.employees[i]}`);
    }

    console.log(person.toString());
}


function callingFunctions() {
    const result1 = square(6);
    const result2 = square(2);
}


function square(value) {
    return value * value;
}

/*
#################
Scope
#################

Functions can access variables declared outside of them, so be careful.
*/


/*
########################
Function Overloading
########################
 
Function Overloading is not available in Javascript. If you declare a 
function with the same name, more than one time in a script file, the 
earlier ones are overriden and the most recent one will be used. 
*/

function Add(num1, num2) {
    return num1 + num2;
}

function Add(num1, num2, num3) {
    return num1 + num2 + num3;
}


/* 
########################
Math Library
########################
 
A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
    console.log("Math.PI : " + Math.PI);
    console.log("Math.LOG10E : " + Math.LOG10E);
    console.log("Math.abs(-10) : " + Math.abs(-10));
    console.log("Math.floor(1.99) : " + Math.floor(1.99));
    console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
    console.log("Math.random() : " + Math.random());
}


/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {

    console.log(`.length -  ${value.length}`)
    console.log(`.endsWith('World') - ${value.endsWith('World')}`);
    console.log(`.startsWith('Hello') - ${value.startsWith('Hello')}`);
    console.log(`.indexOf('Hello') - ${value.indexOf('Hello')}`);

    /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}



/*
########################
Array Methods
########################
*/
const numbers = [-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function arrayMethods() { 
    // Adding items to an array
    numbers.push([11, 12, 13, 14, 15, 16]);

    // Slice can be used to get a copy of an array
    const copy = numbers.slice();    
}


// Other Array Functions
// using Arrow Operators
function filterFunctions() {     
                        
    // Filter accepts a single argument indicating the element in the array
    const oddNumbers = numbers.filter(number => number % 2 == 1);
    console.table(oddNumbers);

    const evenNumbers = numbers.filter(number => number % 2 == 0);
    console.table(evenNumbers);
    
    const evenPositives = numbers.filter(number => number % 2 == 0 && number > 0);
    console.table(evenPositives);    
}

