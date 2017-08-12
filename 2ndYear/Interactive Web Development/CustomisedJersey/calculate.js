function textPos1(){
    document.getElementById("jerseyName").style.top = "195px";
    document.getElementById("jerseyNumber").style.top = "215px";
    document.getElementById("jerseyName").style.left = "470px";
    document.getElementById("jerseyNumber").style.left = "345px";
}

function textPos2(){
    document.getElementById("jerseyName").style.top = "205px";
    document.getElementById("jerseyNumber").style.top = "225px";
    document.getElementById("jerseyName").style.left = "465px";
    document.getElementById("jerseyNumber").style.left = "340px";
}

function textPos3(){
    document.getElementById("jerseyName").style.top = "265px";
    document.getElementById("jerseyNumber").style.top = "285px";
    document.getElementById("jerseyName").style.left = "465px";
    document.getElementById("jerseyNumber").style.left = "340px";
}

function textPos4(){
    document.getElementById("jerseyName").style.top = "195px";
    document.getElementById("jerseyNumber").style.top = "215px";
    document.getElementById("jerseyName").style.left = "480px";
    document.getElementById("jerseyNumber").style.left = "355px";
}

function textPos5(){
    document.getElementById("jerseyName").style.top = "200px";
    document.getElementById("jerseyNumber").style.top = "250px";
    document.getElementById("jerseyName").style.left = "340px";
    document.getElementById("jerseyNumber").style.left = "210px";
}

function myTeam(position){
    teamNo=position;
    if (position == 1) {
        sizeCost();
        changeGender();
    }else if(position == 2){
        sizeCost();
        changeGender();
    }else if(position == 3){
        sizeCost();
        changeGender();
    }else if(position == 4){
        sizeCost();
        changeGender();
    }else if(position == 5){
        sizeCost();
        changeGender();
    }else if(position == 6){
        sizeCost();
        changeGender();
    }else if(position == 7){
        sizeCost();
        changeGender();
    }else if(position == 8){
        sizeCost();
        changeGender();
    }else if(position == 9){
        sizeCost();
        changeGender();
    }else if(position == 10){
        sizeCost();
        changeGender();
    }else if(position == 11){
        sizeCost();
        changeGender();
    }else if(position == 12){
        sizeCost();
        changeGender();
    }else if(position == 13){
        sizeCost();
        changeGender();
    }

}

var teamNo = 1;

function changeGender() {
    if(teamNo==1){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/DodgersMan.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
             textPos2();
        }
        else if (document.getElementById("female").checked) {
            document.getElementById("defaultImg").src = "images/DodgersWomen.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos3();
        }
    }
    else if(teamNo==2){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/MetsMan.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
             textPos2();
        }
        else if (document.getElementById("female").checked) {
            document.getElementById("defaultImg").src = "images/MetsWomen.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos1();
        }
    }
    else if(teamNo==3){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/WhiteSoxMan.jpg";
            textPos2();
        }
        else if (document.getElementById("female").checked) {
            document.getElementById("defaultImg").src = "images/WhiteSoxWomen.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos3();
        }
    }
    else if(teamNo==4){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/RedSoxMan.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos2();
        }
        else if (document.getElementById("female").checked) {
            document.getElementById("defaultImg").src = "images/RedSoxWomen.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos3();
        }
    }
    else if(teamNo==5){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/GiantsMan.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos2();
        }
        else if (document.getElementById("female").checked) {
            document.getElementById("defaultImg").src = "images/GiantsWomen.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos4();
        }
    }
    else if(teamNo==6){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/BlueJaysMan.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos2();
        }
        else if (document.getElementById("female").checked) {
            document.getElementById("defaultImg").src = "images/BlueJaysWomen.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos3();
        }
    }
    else if(teamNo==7){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/RoyalsMan.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos2();
        }
        else if (document.getElementById("female").checked) {
            document.getElementById("defaultImg").src = "images/RoyalsWomen.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos3();
        }
    }
    else if(teamNo==8){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/PhilliesMan.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos2();
        }
        else if (document.getElementById("female").checked) {
            document.getElementById("defaultImg").src = "images/PhilliesWomen.jpg";
            document.getElementById("jerseyName").value = "";
            document.getElementById("jerseyNumber").value = "";
            textPos3();
        }
    }else if(teamNo==9){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/PredefineStyle1- Rice.jpg";
            document.getElementById("jerseyName").value = "Rice";
            document.getElementById("jerseyNumber").value = "80";
            textPos5();
        }
        else if (document.getElementById("female").checked) {
            alert("Sorry, no female version available!");
            document.getElementById("female").checked = false;
            document.getElementById("male").checked = true;
            document.getElementById("defaultImg").src = "images/PredefineStyle1- Rice.jpg";
            textPos5();
        }
    }else if(teamNo==10){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/PredefineStyle2- Brown.jpg";
            document.getElementById("jerseyName").value = "Brown";
            document.getElementById("jerseyNumber").value = "32";
            textPos5();
        }
        else if (document.getElementById("female").checked) {
            alert("Sorry, no female version available!");
            document.getElementById("female").checked = false;
            document.getElementById("male").checked = true;
            document.getElementById("defaultImg").src = "images/PredefineStyle2- Brown.jpg";
            textPos5();
        }
    }else if(teamNo==11){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/PredefineStyle3- Montana.jpg";
            document.getElementById("jerseyName").value = "Montana";
            document.getElementById("jerseyNumber").value = "16";
            textPos5();
        }
        else if (document.getElementById("female").checked) {
            alert("Sorry, no female version available!");
            document.getElementById("female").checked = false;
            document.getElementById("male").checked = true;
            document.getElementById("defaultImg").src = "images/PredefineStyle3- Montana.jpg";
            textPos5();
        }
    }else if(teamNo==12){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/PredefineStyle4- Taylor.jpg";
            document.getElementById("jerseyName").value = "Taylor";
            document.getElementById("jerseyNumber").value = "56";
            textPos5();
        }
        else if (document.getElementById("female").checked) {
            alert("Sorry, no female version available!");
            document.getElementById("female").checked = false;
            document.getElementById("male").checked = true;
            document.getElementById("defaultImg").src = "images/PredefineStyle4- Taylor.jpg";
            textPos5();
        }
    }else if(teamNo==13){
        if (document.getElementById("male").checked) {
            document.getElementById("defaultImg").src = "images/PredefineStyle5- Payton.jpg";
            document.getElementById("jerseyName").style.top = "200px";
            document.getElementById("jerseyNumber").style.top = "250px";
            document.getElementById("jerseyName").style.left = "325px";
            document.getElementById("jerseyNumber").style.left = "195px";
            document.getElementById("jerseyName").value = "Payton";
            document.getElementById("jerseyNumber").value = "34";
        }
        else if (document.getElementById("female").checked) {
            alert("Sorry, no female version available!");
            document.getElementById("female").checked = false;
            document.getElementById("male").checked = true;
            document.getElementById("defaultImg").src = "images/PredefineStyle5- Payton.jpg";
            document.getElementById("jerseyName").style.top = "200px";
            document.getElementById("jerseyNumber").style.top = "250px";
            document.getElementById("jerseyName").style.left = "325px";
            document.getElementById("jerseyNumber").style.left = "195px";
        }
    }
}

function resetJersey(){
    textPos2();
    document.getElementById("defaultImg").src = "images/Default.jpg";
    
}

function changeColor(color){
    if(color == 1){
        costColor = 5;
        totalCost();
        document.getElementById("jerseyName").style.color = "black";
        document.getElementById("jerseyNumber").style.color = "black";
    }
    else if(color == 2){
        costColor = 5;
        totalCost();
        document.getElementById("jerseyName").style.color = "blue";
        document.getElementById("jerseyNumber").style.color = "blue";
    }
    else if(color == 3){
        costColor = 5;
        totalCost();
        document.getElementById("jerseyName").style.color = "red";
        document.getElementById("jerseyNumber").style.color = "red";
    }
    else if(color == 4){
        costColor = 5;
        totalCost();
        document.getElementById("jerseyName").style.color = "yellow";
        document.getElementById("jerseyNumber").style.color = "yellow";
    }
    else if(color == 5){
        costColor = 5;
        totalCost();
        document.getElementById("jerseyName").style.color = "green";
        document.getElementById("jerseyNumber").style.color = "green";
    }
    else if(color == 6){
        costColor = 0;
        totalCost();
        document.getElementById("jerseyName").style.color = "white";
        document.getElementById("jerseyNumber").style.color = "white";
    }
}

function sizeCost(){
    
    if (document.getElementById("XS").checked) {
        costSize = 20;
        totalCost();
    }
    else if (document.getElementById("S").checked) {4
        costSize = 22;
        totalCost();
    }
    else if (document.getElementById("M").checked) {
        costSize = 25;
        totalCost();
    }
    else if (document.getElementById("L").checked) {
        costSize = 30;
        totalCost();
    }
    else if (document.getElementById("XL").checked) {
        costSize = 35;
        totalCost();
    }
    
}

var costColor = 0;
var costSize = 0;
var costQuantity = 0;
var total = 0;

function totalCost(){ 
    costQuantity = document.getElementById("quantity").value;
    total = (costSize + costColor) * costQuantity;
    total = Math.round(total*100)/100;
    document.getElementById("cost").value = total;
    if(total >= 30){
        document.getElementById("cost").value = Math.round((total-total*0.15)*100)/100;
        alert("You are entitle to 15% discount for spending more then 30$!");
	}
}



