/**
 * ajax.js Asynchronous JavaScript And Xml
 */
function ajaxFnc() {

	let xhtp = new XmlHttpRequest();
	xhtp.open("get", "EmpListServlet");
	xhtp.send();
	xhtp.onreadystatechange = function() {
		if (xhtp.readyState == 4 && xhtp.status == 200) {
			let data = JSON.parse(xhtp.reponseText);
			console.log(data);
		}
	}
}

ajaxFnc();