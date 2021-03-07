function doipheptinh(nut) {
    let phep = nut;
    switch (phep) {
        case 'Additilion(+)': {
            document.getElementById("pheptinh").value= "+";
            break;
        }case 'Subtraction(-)': {
            document.getElementById("pheptinh").value= "-";
            break;
        }case 'Multipcation(X)': {
            document.getElementById("pheptinh").value= "X";
            break;
        }case 'Division(/)': {
            document.getElementById("pheptinh").value= "/";
            break;
        }

    }
}

function tinhtoan() {
    let phep = document.getElementById("pheptinh").value;
    let so1=document.getElementById("so1").value;
    let so2=document.getElementById("so2").value;
    switch (phep) {
        case '+': {
            let ketqua = so1 - -so2;
            document.getElementById("result").innerHTML = "Addition :" + ketqua;
            break;
        }
        case '-': {
            let ketqua = so1 - so2;
            document.getElementById("result").innerHTML = "Subtraction:" + ketqua;
            break;
        }
        case 'X':{
            let ketqua = so1*so2;
            document.getElementById("result").innerText="Multiplication :"+ketqua;
            break;
        }
        case '/':{
            let ketqua = so1/so2;
            document.getElementById("result").innerText="Division:"+ketqua;
            break;
        }
    }
}

function daygiatri(sonhapvao) {
    let pheptinh=document.getElementById("pheptinh").value;
    if(pheptinh==0){
        let sodc = sonhapvao;
        switch (sodc) {
            case '1': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s1").value);
                document.getElementById("so1").value = giatri;
                break;
            }
            case '2': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s2").value);
                document.getElementById("so1").value = giatri;
                break;
            }
            case '3': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s3").value);
                document.getElementById("so1").value = giatri;
                break;
            }
            case '4': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s4").value);
                document.getElementById("so1").value = giatri;
                break;
            }
            case '5': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s5").value);
                document.getElementById("so1").value = giatri;
                break;
            }
            case '6': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s6").value);
                document.getElementById("so1").value = giatri;
                break;
            }
            case '7': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s7").value);
                document.getElementById("so1").value = giatri;
                break;
            }
            case '8': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s8").value);
                document.getElementById("so1").value = giatri;
                break;
            }
            case '9': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s9").value);
                document.getElementById("so1").value = giatri;
                break;
            }
            case '0': {
                let giatri = parseInt(document.getElementById("so1").value + document.getElementById("s0").value);
                document.getElementById("so1").value = giatri;
                break;
            }

        }
    }
    if(pheptinh!="") {
        let sodc = sonhapvao;
        switch (sodc) {
            case '1': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s1").value);
                document.getElementById("so2").value = giatri;
                break;
            }
            case '2': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s2").value);
                document.getElementById("so2").value = giatri;
                break;
            }
            case '3': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s3").value);
                document.getElementById("so2").value = giatri;
                break;
            }
            case '4': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s4").value);
                document.getElementById("so2").value = giatri;
                break;
            }
            case '5': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s5").value);
                document.getElementById("so2").value = giatri;
                break;
            }
            case '6': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s6").value);
                document.getElementById("so2").value = giatri;
                break;
            }
            case '7': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s7").value);
                document.getElementById("so2").value = giatri;
                break;
            }
            case '8': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s8").value);
                document.getElementById("so2").value = giatri;
                break;
            }
            case '9': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s9").value);
                document.getElementById("so2").value = giatri;
                break;
            }
            case '0': {
                let giatri = parseInt(document.getElementById("so2").value + document.getElementById("s0").value);
                document.getElementById("so2").value = giatri;
                break;
            }

        }
    }


}
var doimau= null;
doimau.addEventListener("chuottoi",onmouseover);
doimau.addEventListener("chuotdi",onmouseout);
function chuottoi(ctoi) {
    let phim= ctoi;
    switch (phim) {
        case '1':
            document.getElementById("s1").style.background="red";
            break;
        case '2':
            document.getElementById("s2").style.background="red";
            break;
        case '3':
            document.getElementById("s3").style.background="red";
            break;
        case '4':
            document.getElementById("s4").style.background="red";
            break;
        case '5':
            document.getElementById("s5").style.background="red";
            break;
        case '6':
            document.getElementById("s6").style.background="red";
            break;
        case '7':
            document.getElementById("s7").style.background="red";
            break;
        case '8':
            document.getElementById("s8").style.background="red";
            break;
        case '9':
            document.getElementById("s9").style.background="red";
            break;
        case '0':
            document.getElementById("s0").style.background="red";
            break;
        case 'Additilion(+)':
            document.getElementById("cong").style.background="blue";
            break;
        case 'Subtraction(-)':
            document.getElementById("tru").style.background="blue";
            break;
        case 'Multipcation(X)':
            document.getElementById("nhan").style.background="blue";
            break;
        case 'Division(/)':
            document.getElementById("chia").style.background="blue";
    }
}
function chuotdi(cdi) {
    let phim= cdi;
    switch (phim) {
        case '1':
            document.getElementById("s1").style.background="whitesmoke";
            break;
        case '2':
            document.getElementById("s2").style.background="whitesmoke";
            break;
        case '3':
            document.getElementById("s3").style.background="whitesmoke";
            break;
        case '4':
            document.getElementById("s4").style.background="whitesmoke";
            break;
        case '5':
            document.getElementById("s5").style.background="whitesmoke";
            break;
        case '6':
            document.getElementById("s6").style.background="whitesmoke";
            break;
        case '7':
            document.getElementById("s7").style.background="whitesmoke";
            break;
        case '8':
            document.getElementById("s8").style.background="whitesmoke";
            break;
        case '9':
            document.getElementById("s9").style.background="whitesmoke";
            break;
        case '0':
            document.getElementById("s0").style.background="whitesmoke";
            break;
        case 'Additilion(+)':
            document.getElementById("cong").style.background="whitesmoke";
            break;
        case 'Subtraction(-)':
            document.getElementById("tru").style.background="whitesmoke";
            break;
        case 'Multipcation(X)':
            document.getElementById("nhan").style.background="whitesmoke";
            break;
        case 'Division(/)':
            document.getElementById("chia").style.background="whitesmoke";

    }

}
