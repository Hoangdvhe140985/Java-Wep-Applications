function update(){
    var re = document.getElementsByTagName("input");
    var name = re[0].value;
    var phone = re[1].value;
    var date  = re[2].value;
    var address = re[5].value;
    var email = re[6].value;
    var account = re[7].value;
    var password = re[8].value;
    var department = re[9].value;
    
    if(name == "" && phone == "" && date == "" && address == ""
    && email == ""&& account == ""&& password == ""&& department == ""){
        alert("Please enter your input");
    }else if(name == ""){
        alert("Please enter name!");
    }else if(mail == ""){
        alert("Please enter phone number!");
    }else if(pass == ""){
        alert("Please enter date!");
    }else if(repass == ""){
        alert("Please enter address!");
    }else if(repass == ""){
        alert("Please enter email!");
    }else if(repass == ""){
        alert("Please enter account!");
    }else if(repass == ""){
        alert("Please enter password!");
    }else if(repass == ""){
        alert("Please enter department!");
    }
    
    
}


