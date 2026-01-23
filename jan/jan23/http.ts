const REQURL = "https://naas.isalman.dev/no";

// AJAX Demo
// NOTE - Node does not include XMLHTTPRequest, but most browsers do
// const ajaxReq = new XMLHttpRequest();

// ajaxReq.onload = () => {
//     const res = ajaxReq.responseText;
//     console.log(res);
// };

// ajaxReq.open("GET", REQURL);

// ajaxReq.send();

// Fetch Demo

fetch(REQURL)
    .then((res) => {
        return res.json();
    })
    .then((data) => {
        console.log(data);
    });
