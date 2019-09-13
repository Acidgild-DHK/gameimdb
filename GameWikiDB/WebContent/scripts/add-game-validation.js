function formValidation(){
	var title = document.addGameForm.game_title;
	var releaseDate = document.addGameForm.release_date;
	
	if (validateGame(title) && validateDate(releaseDate)){
		return true;
	}
	return false;
}

function validateGame(title){
	if (title.value.length == 0){
		alert("Game title is required.");
		return false;
	}
	return true;
}

function validateDate(releaseDate){
	var pat = /^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$/;
	// Match the date format through regular expression
	  if(releaseDate.value.match(pat))
	  {
		  var pdate = releaseDate.value.split('-');
		  var yy  = parseInt(pdate[0]);
		  var mm = parseInt(pdate[1]);
		  var dd = parseInt(pdate[2]);
		  // Create list of days of a month [assume there is no leap year by default]
		  var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];
		  if (mm==1 || mm>2)
		  {
			  if (dd>ListofDays[mm-1])
			  {
				  alert('Invalid date format!');
				  return false;
			  }
		  }
		  if (mm==2)
		  {
			  var lyear = false;
			  if ( (!(yy % 4) && yy % 100) || !(yy % 400)) 
			  {
				  lyear = true;
			  }
			  if ((lyear==false) && (dd>=29))
			  {
				  alert('Invalid date format!');
				  return false;
			  }
			  if ((lyear==true) && (dd>29))
			  {
				  alert('Invalid date format!');
				  return false;
			  }
		  }
		  return true;
	  }
		  alert('Invalid date format!');
	  return false;
}