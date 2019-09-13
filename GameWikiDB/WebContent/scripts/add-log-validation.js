function formValidation(){
	var title = document.logForm.game;
	var time = document.logForm.time;
	
	if (validateTitle(title) && validateTime(time)){
		return true;
	}
	return false;
}

function validateTitle(title){
	if (title.value.length == 0){
		alert("Game title is required.");
		return false;
	}
	return true;
}

function validateTime(time){
	if (time.value < 0){
		alert("Time can't be negative.");
		return false;
	}
	return true;
}