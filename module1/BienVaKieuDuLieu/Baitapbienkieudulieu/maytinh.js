function pcong() {
    let so1=document.getElementById("so1").value;
    let so2=document.getElementById("so2").value;
    let cong= so1- -so2;
    document.getElementById("result").innerText=cong;
    document.getElementById("phep").innerText="Addition :"
}
function ptru() {
    let so1=document.getElementById("so1").value;
    let so2=document.getElementById("so2").value;
    let tru = so1 - so2;
    document.getElementById("result").innerText= tru;
    document.getElementById("phep").innerText="Subtraction :"
}
function pnhan() {
    let so1=document.getElementById("so1").value;
    let so2=document.getElementById("so2").value;
    let nhan = so1*so2;
    document.getElementById("result").innerText=nhan;
    document.getElementById("phep").innerText="Multiplication :"
}
function pchia() {
    let so1=document.getElementById("so1").value;
    let so2=document.getElementById("so2").value;
    let chia = so1/so2;
    document.getElementById("result").innerText=chia;
    document.getElementById("phep").innerText="Division :"
}