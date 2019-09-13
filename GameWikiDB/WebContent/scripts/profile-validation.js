function formValidation(){
	var tag = document.profileForm.gamer_tag;
	var email = document.profileForm.email;
	var name = document.profileForm.name;
	var age = document.profileForm.age;
	
	if (validateTag(tag)){
		if (validateEmail(email)){
			if(validateName(name)){
				if(validateAge(age)){
					return true;
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

function validateEmail(email){
	var pat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (email.value.match(pat)){
		return true;
	} else {
		alert("Invalid email");
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

function validateName(name){
	var pat = /^[0-9a-zA-Z'_]*$/;
	if (name.value.match(pat) && name.value.length > 0){
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