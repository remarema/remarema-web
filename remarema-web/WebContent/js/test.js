function updateSoftwareVersionList() {
	$.ajax({
		type: "GET",
		url: "Bla.irgendwas?PackageId=" + $("#softwareVersionList").val(),
		async: true,
		error: function(Request, Message, ThrownError)
		{
			alert("JsonRequest.Error: " + Message + ", " + ThrownError);
		},
		success: function(Data)
		{
			var Success = false;
			var JsonData = null;
			try
			{
				JsonData = $.parseJSON(Data);
				Success = true;
			}
			catch(e)
			{
				Success = false;
			}
			if (Success)
			{
				alert(JsonData);
			}
			else
			{
				alert("JsonRequest.JsonParseError: " + Data);
			}
		}
	});
	alert();
}