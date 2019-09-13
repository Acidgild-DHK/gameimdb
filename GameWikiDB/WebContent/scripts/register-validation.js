function formValidation(){
	var uname = document.registrationForm.username;
	var tag = document.registrationForm.name;
	var rname = document.registrationForm.flname;
	var age = document.registrationForm.age;
	var email = document.registrationForm.email;
	var question = document.registrationForm.question;
	var answer = document.registrationForm.answer;
	var pass = document.registrationForm.password;
	if (validateUName(uname, 5, 13)){
		if (validateTag(tag)){
			if(validateRName(rname)){
				if(validateAge(age)){
					if(validateEmail(email)){

						if (validateQuestion(question)){
							if(validateAnswer(answer)){
								if (validatePass(pass)){
									return true;
								}
							}
						}
					}
				}
			}
		}
	}
	
	return false;
}

function validateLength(str, mx, my){

	var len = str.value.length;
	if (len == 0 || len > my || len < mx){
		return false;
	}
	return true;
}
function validateUName(uname,mx,my){
	var pat = /^[a-zA-z][0-9a-zA-Z]*$/;
	if (uname.value.match(pat) && validateLength(uname,mx,my)){
		return true;
	} else {
		alert('Username must have alphanumeric with length 6 -12. It must begin with a letter.');
		return false;
	}
}

function validateTag(tag){
	var len = tag.value.length;
	if (len == 0){
		alert("Gamer Tag cannot be empty.");
		return false;
	}
	return true;
}

function validateEmail(email){
	var pat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (email.value.match(pat)){
		return true;
	} else {
		alert("Invalid email");
		return false;
	}
}

function validatePass(pass){
	var pat = /^[0-9a-zA-Z]+$/;
	if ( validateLength(pass,6,13) && pass.value.match(pat)){
		return true;
	} else {
		alert("Password must have alphanumeric with length 6 -12.");
		return false;
	}
}

function validateRName(rname){
	var pat = /^[0-9a-zA-Z'_]*$/;
	if (rname.value.match(pat) && rname.value.length > 0){
		return true
	} else {
		alert("Name must be alphanumeric, ', or _");
		return false;
	}
}

function validateAge(age){
	var a_num = age.value;
	if (a_num < 13 || a_num > 120){
		alert("Must be 13 years or older (max=120) to register.");
		return false;
	}
	return true;
}

function validateQuestion(question){
	var len = question.value.length;
	if (len == 0){
		alert("Question is required.");
		return false;
	}
	return true;
}

function validateAnswer(answer){
	var len = answer.value.length;
	if (len == 0){
		alert("Answer is required.");
		return false;
	}
	return true;
}