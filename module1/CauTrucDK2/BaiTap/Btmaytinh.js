var soThu1=null;
var soThu2=null;
var tinh=null
function daygiatri(soNhapVao) {
    let sodc = soNhapVao;
    let xem=document.getElementById("oNhapSo").value;
    switch (xem) {
        case '+':
        case '-':
        case 'X':
        case '/':
        {
            document.getElementById("oNhapSo").value="";
            break;
        }
    }
    switch (sodc) {
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case '0': {
            let giaTri = parseInt(document.getElementById("oNhapSo").value + sodc);
            document.getElementById("oNhapSo").value = giaTri;
            break;
        }
    }
}
function phepTinh(phep) {
    let dau=phep;
    let xem=document.getElementById("oNhapSo").value;
    if (xem>0){
        soThu1=xem;
        document.getElementById("oNhapSo").value=0
    }
    switch (dau) {
        case '+':
        {
            tinh="+";
            document.getElementById("oNhapSo").value="+";
            break;
        }
        case '-':
        {
            tinh="-";
            document.getElementById("oNhapSo").value="-";
            break;
        }
        case 'X':
        {
            tinh="X";
            document.getElementById("oNhapSo").value="X";
            break;
        }
        case '/':
        {
            tinh="/";
            document.getElementById("oNhapSo").value="/";
            break;
        }
    }
}
function tinhToan() {
    soThu2= parseInt( document.getElementById("oNhapSo").value);
    var ketQua;
    if (soThu1>0) {
         ketQua = soThu1;
         soThu1=0;
    }
    console.log(tinh);
    switch (tinh) {
        case '+':{
            ketQua= parseInt(ketQua )+soThu2;
            break;
        }
        case '-':{
            ketQua= parseInt(ketQua )-soThu2;
            break;
        }
        case 'X':{
            ketQua= parseInt(ketQua )*soThu2;
            break;
        }
        case '/':{
            ketQua= parseInt(ketQua )/soThu2;
            break;
        }
    }

document.getElementById("oNhapSo").value=ketQua;
}