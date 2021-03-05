
function tinhtoan(nut) {
    let phep = nut;
    let so1=document.getElementById("so1").value;
    let so2=document.getElementById("so2").value;
    switch (phep) {
        case 'Additilion(+)': {
            let ketqua = so1 - -so2;
            document.getElementById("result").innerHTML = "Addition :" + ketqua;
            break;
        }
        case 'Subtraction(-)': {
            let ketqua = so1 - so2;
            document.getElementById("result").innerHTML = "Subtraction:" + ketqua;
            break;
        }
        case 'Multipcation(X)':{
            let ketqua = so1*so2;
            document.getElementById("result").innerText="Multiplication :"+ketqua;
            break;
        }
        case 'Division(/)':{
            let ketqua = so1/so2;
            document.getElementById("result").innerText="Division:"+ketqua;
            break;
        }
    }

}