function kiemTraBai1() {
    let doC = parseFloat(document.getElementById("doC").value);
    let doF = parseFloat(document.getElementById("doF").value);
    if (doC > 0) {
        let CsangF = (doC * 9) / 5 + 32;
        document.getElementById("doF").value = parseFloat(CsangF);
        doF = 0;
    }
    if (doF > 0) {
        let FsangC = (doF - 32) * 5 / 9;
        document.getElementById("doC").value = parseFloat(FsangC);
    }
}

function kiemTraBai2() {
    let m = document.getElementById("met").value;
    let ft = m * 3.2808
    document.getElementById("ketQuaBai2").innerText = "Feet =" + ft;

}

function kiemTraBai3() {
    let canhA = document.getElementById("canhA").value;
    let dt = canhA * canhA;
    document.getElementById("ketQuaBai3").innerText = "Diện tích hình vuông=" + dt;
}

function kiemTraBai4() {
    let canh1 = document.getElementById("canhThu1").value;
    let canh2 = document.getElementById("canhThu2").value;
    let dt = canh1 * canh2;
    document.getElementById("ketQuaBai4").innerText = "Diện tích hình chủ nhật=" + dt;
}

function kiemTraBai5() {
    let canh1td = document.getElementById("canhKe1").value;
    let canh2td = document.getElementById("canhKe2").value;
    let dt = (canh1td * canh2td) / 2;
    document.getElementById("ketQuaBai5").innerText = "Diện tích hình tam giác=" + dt;
}

function kiemTraBai6() {
    let a = parseInt(document.getElementById("soA").value);
    let b = parseInt(document.getElementById("soB").value);
    let c = document.getElementById("ketQuaBai6");
    if (a == 0) {
        if (b == 0) {
            c.innerText = " phương trình có vô số nghiệm.";
        } else {
            c.innerText = "phương trình vô nghiệm."
        }
    } else {
        c.innerText = "phương trình có nghiệm " + (-b) / a;
    }

}

function kiemTraBai7() {
    var a = document.getElementById("soABac2").value;
    var b = document.getElementById("soBBac2").value;
    var c = document.getElementById("soCBac2").value;
    var ketqua = document.getElementById("ketQuaBai7");

    if (a == 0) {

        if (b == 0) {
            if (c == 0) {
                ketqua.innerText = "Phuong trinh vo so nghiem";

            } else {
                ketqua.innerText = "Phuong trinh vo nghiem";
            }
        } else {
            ketqua.innerText = "Phuong trinh co nghiem duy nhat: " + (-c / b);
        }
    } else {
        var delta = b * b - 4 * a * c;
        if (delta > 0) {
            var x1 = (-b + Math.sqrt(delta)) / (2 * a);
            var x2 = (-b - Math.sqrt(delta)) / (2 * a);
            ketqua.innerText = "Nghiem thu nhat x1 = " + x1 + "\n Nghiem thu hai x2 = " + x2;
        } else if (delta == 0) {
            var sum = -b / 2 * a;
            ketqua.innerText = "Phuong trinh co nghiem kep: x1 = x2 = " + sum;
        } else {
            ketqua.innerText = "Phuong trinh vo nghiem";
        }
    }
}

function kiemTraBai8() {

    let tuoi1 = document.getElementById("tuoi").value;
    let tuoi2 = parseInt(document.getElementById("tuoi").value)
    if (tuoi1 - tuoi2 == 0) {
        if (tuoi2 > 0 && tuoi2 < 120) {
            document.getElementById("ketQuaBai8").innerText = "bạn là người";
        } else {
            document.getElementById("ketQuaBai8").innerText = "bạn không phải là người";
        }
    } else {
        document.getElementById("ketQuaBai8").innerText = "bạn không phải là người";
    }
}

function kiemTraBai9() {
    let a = parseInt(document.getElementById("canhABai9").value);
    let b = parseInt(document.getElementById("canhBBai9").value);
    let c = parseInt(document.getElementById("canhCBai9").value);
    if (a > 0 && b > 0 && c > 0) {
        if (a + b > c) {
            if (b + c > a) {
                if (a + c > b) {
                    document.getElementById("ketQuaBai9").innerText = " là cạnh của một tam giác";
                } else {
                    document.getElementById("ketQuaBai9").innerText = " không là cạnh của một tam giác";
                }
            } else {
                document.getElementById("ketQuaBai9").innerText = " không là cạnh của một tam giác";
            }
        } else {
            document.getElementById("ketQuaBai9").innerText = " không là cạnh của một tam giác";
        }
    } else {
        document.getElementById("ketQuaBai9").innerText = " không là cạnh của một tam giác";
    }

}

function kiemTraBai10() {
    let sDien = parseInt(document.getElementById("soDien").value);
    let cuoc = document.getElementById("ketQuaBai10");
    if (sDien <= 5) {
        cuoc.innerText = "Số tiền là :" + sDien * 2200 + "VND";
    } else {
        cuoc.innerText = "Số tiền là :" + sDien * 5000 + "USD";
    }

}

function kiemTraBai11() {
    let thuNhap = parseInt(document.getElementById("thuNhap").value);
    let ketqua = document.getElementById("ketQuaBai11");
    if (thuNhap > 5000000)
        ketqua.innerText = "Thuế phải nộp là" + thuNhap * 10 / 100;
    else {
        ketqua.innerText = "Thuế phải nộp là" + thuNhap * 40 / 100;
    }
}

function kiemTraBai12() {
    let tienGoc = document.getElementById("tienGoc").value;
    let thang = document.getElementById("thang").value;
    let ls = document.getElementById("laiXuat").value;
    let laiNganHang = tienGoc * Math.pow((1 + ls), thang);
    document.getElementById("ketQuaBai12").innerText = "Tiền lãi ngân hàng là :" + laiNganHang;
}
