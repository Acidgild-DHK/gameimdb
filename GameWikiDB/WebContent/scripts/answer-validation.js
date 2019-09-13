function formValidation(){
	var answer = document.answerForm.answer
	
	if (answer.value.length == 0){
		alert("Answer is required")
		return false;
	} else {
		return true;
	}
}