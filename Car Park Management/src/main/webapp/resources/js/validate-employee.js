function CheckPhone() {
            var phone = document.getElementById("phoneNumber").value;
            var ph = /^[0]{1}[0-9]{9}$/
            if (phone.match(ph)) {
                document.getElementById("PhoneNumberCheck").style.display = "none";
                document.getElementById("phoneNumber").style.borderColor = "#ced4da";
                return true;
            } else {
                document.getElementById("PhoneNumberCheck").style.display = "block";
                document.getElementById("phoneNumber").style.borderColor = "red";
                return false;
            }
        }

        function ValidateEmail() {
            var mail = document.getElementById("Email").value;
            var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
            if (mail.match(mailformat)) {

                document.getElementById("EmailCheck").style.display = "none";
                document.getElementById("Email").style.borderColor = "#ced4da";
                return true;
            } else {

                document.getElementById("EmailCheck").style.display = "block";
                document.getElementById("Email").style.borderColor = "red";
                return false;
            }
        }
        function CheckPassword() {
            var password = document.getElementById("Password").value;
            var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/
            if (password.match(passw)) {
                document.getElementById("PasswordCheck").style.display = "none";
                document.getElementById("Password").style.borderColor = "#ced4da";
                return true;
            } else {
                document.getElementById("PasswordCheck").style.display = "block";
                document.getElementById("Password").style.borderColor = "red";
                return false;
            }
        }
        function goBack() {
            window.history.back();
        }