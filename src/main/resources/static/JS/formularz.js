var form=document.getElementById("contactForm");
form.onsubmit = function (e) {
  // stop the regular form submission
  e.preventDefault();
  
  var data = {};
  for (var i = 0, ii = form.length; i < ii; ++i) {
    var input = form[i];
    if (input.name) {
      data[input.name] = input.value;
    }
  }

//  $.ajax({
//         contentType :'application/json; charset=ISO-8859-1',
//           method: "POST",
//           url: "http://localhost:8887",
//           data: JSON.stringify(data),
//         })
//         .done(function () {
//             console.log(data);
//             alert("ok");
//              })
//         .fail(function () {

//           alert(JSON.stringify(data));
//         })

var url="localhost:8080/";
   var xhr = new XMLHttpRequest();
   xhr.onreadystatechange=function(){
    if (this.readyState == 4 && this.status == 200) {
        data=JSON.stringify(data);      
   }
}
   xhr.open(form.method, url, true);
   xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
   xhr.send(data);
   console.log(data);

//    xhr.onloadend = function () {};
 }

