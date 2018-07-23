document.addEventListener("DOMContentLoaded", function() {

    //1. Getting an HTML element by id
    var box1 = document.getElementById('box1');    
    console.log(box1);
        
    //2. Getting an HTML element by class name
    var redBoxes = document.getElementsByClassName('red');
    console.log(redBoxes);

    //3. Getting HTML elements by tag name
    var divBoxes = document.getElementsByTagName('div');
    console.log(divBoxes);   

    //4. Filtering the div boxes to include only odd-numbered boxes
    var oddNumberedBoxes = document.querySelectorAll('div:nth-child(odd)');
    console.log(oddNumberedBoxes);

    //5. Getting all list Items and filtering to only include special
    var specialItems = document.querySelectorAll("li.special");
    console.log(specialItems);
      
    //6. Getting the last box
    var h2s = document.querySelectorAll("div.box");
    console.log(h2s[h2s.length - 1]);

    //7. Getting the parent box of the .text class
    var parent = document.querySelector(".text").parentNode;
    console.log(parent);

    //8. Getting the box after the blue-one
    var boxAfterList = document.querySelector("div.blue").nextElementSibling;
    console.log(boxAfterList);

    //9. Getting all children inside the grey box except <br/>
    var greyBoxChildren = Array.from(document.getElementsByClassName("grey")[0].children).filter(function(el){return el.tagName !== 'BR'});
    console.log(greyBoxChildren);

    //10. Getting the value of the text box
    var textBoxValue = document.getElementById("nameField").value;
    console.log(textBoxValue);

    //11. Setting the value of the text box to Tech Elevator
    document.getElementById("nameField").value = "Tech Elevator Again";
    
    //12. Getting the value of the first <p> tag in the green box
    var greenBoxChildren = document.getElementsByClassName('green')[0].children;
    var greenBoxPTag = Array.from(greenBoxChildren).filter(function(el){return el.tagName === 'P'});    
    console.log("Before " + greenBoxPTag[0].innerHTML);

    //13. Changing the html
    greenBoxPTag[0].innerHTML = "<b>This HTML was changed by JavaScript</b>";

    //14. Changing all of the li tags to something better
    var allLis = document.getElementsByTagName("li");
    for(var i = 0; i < allLis.length; i++) {
        allLis[i].textContent = "Set the .text() through vanilla JS";
    }

    //15. Changing the link attribute in the green box
    var greenBoxLink = document.querySelector('.green a');
    greenBoxLink.href = "http://www.techelevator.com";

    //16. Changing the boxes in the grey box    
    var checkboxes = document.querySelectorAll(".grey input[type=checkbox]");
    for(var i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = true;
    }

    //17. Making all of the other boxes grey and the black box red
    //var blackBox = $(".grey");
    //var otherBoxes = $(".box").not(".grey");        
    //blackBox.removeClass("grey").addClass("red");
    //otherBoxes.removeClass().addClass("box").addClass("black");
    
    //18. Adding a new list item
    var newChildElement = document.createElement("li"); 
    newChildElement.textContent = "Item 6";
    document.getElementsByTagName("ul")[0].appendChild(newChildElement);

    //19. Moving the even numbered items from the yellow box to the green box
    var list = $("li").filter(":even").detach();
    $(".green").children().filter("ol").append(list);
    

});