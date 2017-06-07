// Check valid date
function isDate(txtDate)
{
    var currVal = txtDate;
    if(currVal == '')
    	return false;

    //Declare Regex
    var rxDatePattern = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;
    var dtArray = currVal.match(rxDatePattern); // is format OK?

    if (dtArray == null)
    	return false;

    //Checks for dd/mm/yyyy format.
    dtDay = dtArray[1];
    dtMonth = dtArray[3];
    dtYear = dtArray[5];

    if (dtMonth < 1 || dtMonth > 12)
        return false;
    else if (dtDay < 1 || dtDay> 31)
        return false;
    else if ((dtMonth==4 || dtMonth==6 || dtMonth==9 || dtMonth==11) && dtDay ==31)
        return false;
    else if (dtMonth == 2)
    {
        var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
        if (dtDay> 29 || (dtDay ==29 && !isleap))
        return false;
    }
    return true;
}

// Check valid date when click submit
$(function() {
    $('#btnSubmit').bind('click', function(){
    	$('#personForm').validator();
        var txtVal =  $('#birthDate').val();
        if(isDate(txtVal))
            // alert('Valid Date');
            // Do something ....
        	return true;
        else
            // alert('Invalid Date');
            // Do something ....
        	return false;
    });
});

// Date input
$(document).ready(function(){
	var date_input=$('input[name="birthDate"]'); //our date input has the name "date"
	var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	var options={
		format: 'dd/mm/yyyy',
		container: container,
		todayHighlight: true,
		autoclose: true,
	};
	date_input.datepicker(options);
})
