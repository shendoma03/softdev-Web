
<!DOCTYPE html>
<html>
<head>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<meta charset="UTF-8">
<title>Register</title>
<style>
body {
    background: url('./images/sprinkler.jpg') no-repeat fixed center center;
    background-size: cover;
    font-family: Montserrat;
}

.logo {
    width: 213px;
    height: 36px;
    background: url('http://i.imgur.com/fd8Lcso.png') no-repeat;
    margin: 30px auto;
}

.login-block {
    width: 320px;
    padding: 20px;
    background: #fff;
    border-radius: 5px;
    border-top: 5px solid #00cc00;
    margin: 0 auto;
}

.login-block h1 {
    text-align: center;
    color: #000;
    font-size: 18px;
    text-transform: uppercase;
    margin-top: 0;
    margin-bottom: 20px;
}

.login-block input {
    width: 100%;
    height: 42px;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    font-size: 14px;
    font-family: Montserrat;
    padding: 0 20px 0 50px;
    outline: none;
}

.login-block input#username {
    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.login-block input#username:focus {
    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.login-block input#password {
    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.login-block input#password:focus {
    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.login-block input:active, .login-block input:focus {
    border: 1px solid #00cc00;
}

.login-block button {
    width: 100%;
    height: 40px;
    background: #00cc00;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #00b41e;
    color: #fff;
    font-weight: bold;
    text-transform: uppercase;
    font-size: 14px;
    font-family: Montserrat;
    outline: none;
    cursor: pointer;
}

.login-block button:hover {
    background: #c2f2d0;
}

</style>
<script>
function validateForm() {
	var isValid = validateIfEmpty(document.getElementById("username"), "User name is required.")
	if (isValid) 
		isValid = validateIfEmpty(document.getElementById("password"), "Password is required.")
	if (isValid) 
		isValid = validateIfEmpty(document.getElementById("firstname"), "First name is required.")
	if (isValid) 
		isValid = validateIfEmpty(document.getElementById("lastname"), "Last name is required.")
		
	return isValid
}

function validateIfEmpty(formElement, msg) {
    if (formElement == null || formElement.value == "") {
    	alert(msg);
    	formElement.focus();
    	return false;
    }    	
    return true;
}

</script>
</head>
<body>
<br>
<br>
<div class="login-block">
<form method="post" action="controller?rh=access&cmd=registerUser">>
    <h1>Register</h1>
Username: <input name="username" type="text" id="username" placeholder="Username"></td><br>
Password: <input name="password" type="password" id="password" placeholder="******"></td><br>
First name: <input name="fname" type="text" id="firstname" placeholder="First name"></td><br>
Last name: <input name="lname" type="text" id="lastname" placeholder="Last name"></td><br>
    <button>Submit</button>
    </form>
</div>



</body>
</html>