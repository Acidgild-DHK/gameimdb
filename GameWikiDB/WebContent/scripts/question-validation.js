function formValidation(){
	var question = document.questionForm.question;
	var answer = document.questionForm.answer;
	var password = document.questionForm.password;
	
	if(validatePass(password)){
		if (validateQuestion(question)){
			if (validateAnswer(answer)){
				return true;
			}
		}
	}
	return false;s
}

function validatePass(password){
	if (password.value.length > 0){
		return true;
	} else {
		alert("Password is required.");
		return false;
	}
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