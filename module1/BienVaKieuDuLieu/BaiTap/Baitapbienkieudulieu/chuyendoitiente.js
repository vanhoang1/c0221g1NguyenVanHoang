function doitien()
{
    let tiennhap = document.getElementById("tiennhap").value;
    let a = document.getElementById("from");
    let vao = a.options[a.selectedIndex].value;
    let b = document.getElementById("to");
    let ra = b.options[b.selectedIndex].value;
    if (vao !== ra) {
        if (vao>ra) {
            let dosang = tiennhap * 23000;
            document.getElementById("result").innerHTML = dosang;
        }
        if (vao<ra) {
            let dosang = tiennhap / 23000;
            document.getElementById("result").innerHTML = dosang;
        }
    }
        else    {
        document.getElementById("result").innerHTML = tiennhap;
        }
    if (ra == 1){
        let donvi="VND";
        document.getElementById("donvi").innerText=donvi;
    }
        if (ra==2){
            let donvi="USD";
            document.getElementById("donvi").innerText=donvi;
        }
    }
