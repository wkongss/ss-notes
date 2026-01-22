const FETCHURL = "https://naas.isalman.dev/no";

// Standard promise
const myPromise = fetch(FETCHURL)
    .then((res) => {
        return res.json();
    })
    .then((data : { reason : string }) => {
        console.log(data.reason);
    })


// Async function
async function f() : Promise<void> {
    const promise : Response = await fetch(FETCHURL);
    const data : string = (await promise.json()).reason;

    console.log(data);
}

f();