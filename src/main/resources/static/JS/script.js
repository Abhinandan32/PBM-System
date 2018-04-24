//const URL='localhost:8080/rest/cabinets'; 
const $list =$('.tab-list');

function readData() {

    var form = new FormData();
form.append("file", "");

var settings = {
  "async": true,
  "crossDomain": true,
  "url": "localhost:8080/rest/cabinets",
  "method": "GET",
  "headers": {
    "Cache-Control": "no-cache",
    "Postman-Token": "df5ad2cd-6a63-4dd4-881e-3b8f2a953081"
  },
  "processData": false,
  "contentType": false,
  "mimeType": "multipart/form-data",
  "data": form
}
$.ajax(settings)

.done(ret => {
      //  console.log(ret);
    ret.forEach(tab => {
        const $element = $(`
        <tr>
            <td>${tab.id}</td>
            <td>${tab.realTime}</td>
            <td>${tab.estimatedTime}</td>
            <td>${tab.valuationCost}</td>
            <td>${tab.adjustedCost}</td>
            <td>${tab.current}</td>
            <td>${tab.plcInput}</td>
            <td>${tab.plcOutput}</td>
            <td>${tab.driveAmount}</td>
            <td>${tab.safety}</td>
            <td>${tab.protectionAmount}</td>
            <td>${tab.contactorsAmount}</td>
            <td>${tab.offerer}</td>
            <td>${tab.project}</td>
            <td>${tab.archive}<input id="checkBox1" type="checkbox"></td>
            <td>${tab.toValuation}<input id="checkBox2" type="checkbox"></td>
        </tr>`);
    
        $list.append($element);
    });
    })
    .fail(function(a) {
        
        console.log(a.statusCode());
        //console.log(c);
      })

//     $.ajax({
// url : URL
// })
// .done(ret => {
//   //  console.log(ret);
// ret.forEach(tab => {
//     const $element = $(`
//     <tr>
//         <td>${tab.id}</td>
//         <td>${tab.realTime}</td>
//         <td>${tab.estimatedTime}</td>
//         <td>${tab.valuationCost}</td>
//         <td>${tab.adjustedCost}</td>
//         <td>${tab.current}</td>
//         <td>${tab.plcInput}</td>
//         <td>${tab.plcOutput}</td>
//         <td>${tab.driveAmount}</td>
//         <td>${tab.safety}</td>
//         <td>${tab.protectionAmount}</td>
//         <td>${tab.contactorsAmount}</td>
//         <td>${tab.offerer}</td>
//         <td>${tab.project}</td>
//         <td>${tab.archive}<input id="checkBox1" type="checkbox"></td>
//         <td>${tab.toValuation}<input id="checkBox2" type="checkbox"></td>
//     </tr>`);

//     $list.append($element);
// });
// })
// .fail(function(a) {
    
//     console.log(a.statusCode());
//     //console.log(c);
//   })
}