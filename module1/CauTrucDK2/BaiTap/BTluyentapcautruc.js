function kiemTraBai1() {
    let a = parseInt(document.getElementById("soA").value);
    let b = parseInt(document.getElementById("soB").value);
    if (a % b == 0) {
        document.getElementById("ketQuaBai1").innerText = "a chia hết cho b";
    } else {
        document.getElementById("ketQuaBai1").innerText = "a không chia hết cho b";
    }
}

function kiemTraBai2() {
    let tuoi = parseInt(document.getElementById("tuoi").value);
    if (tuoi > 15) {
        document.getElementById("ketQuaBai2").innerText = "bạn đã đủ điều kiện"
    } else {
        document.getElementById("ketQuaBai2").innerText = "bạn không đủ điều kiện"
    }
}

function kiemTraBai3() {
    let kiemTra = parseInt(document.getElementById("soBatKi").value);
    if (kiemTra == 0) {
        document.getElementById("ketQuaBai3").innerText = "Số bạn nhập bằng 0"
    } else if (kiemTra > 0) {
        document.getElementById("ketQuaBai3").innerText = "Số bạn nhập lớn hơn 0"
    } else {
        document.getElementById("ketQuaBai3").innerText = "Số bạn nhập nhỏ hơn 0"
    }

}

function kiemTraBai4() {
    let soThu1 = parseInt(document.getElementById("soThu1").value);
    let soThu2 = parseInt(document.getElementById("soThu2").value);
    let soThu3 = parseInt(document.getElementById("soThu3").value);
    let max = soThu1;
    if (soThu2 > soThu1) {
        if (soThu2 > soThu3) {
            max = soThu2;
        } else {
            max = soThu3;
        }
    } else {
        if (soThu3 > soThu1) {
            max = soThu3;
        }
    }
    document.getElementById("ketQuaBai4").innerText = "số lớn nhất là:" + max;

}

function kiemTraBai5() {
    let dkt = parseInt(document.getElementById("diemkt").value);
    let dgk = parseInt(document.getElementById("diemGiuaKi").value);
    let dck = parseInt(document.getElementById("diemCuoiKi").value);
    let thongbao = document.getElementById("ketQuaBai5");
    let dTong = (dkt + dgk * 2 + dck * 3) / 6;
    if (dTong >= 7.5) {
        thongbao.innerText = "A";
    } else {
        if (dTong >= 6.5) {
            thongbao.innerText = "B";
        } else {
            thongbao.innerText = "Tạch";
        }
    }
}

function kiemTraBai6() {
    let dThu = parseInt(document.getElementById("doanhThu").value);
    let hoaHong = dThu * 2 / 10;
    document.getElementById("ketQuaBai6").innerText = "Hoa Hồng = " + hoaHong + "$";
}

function kiemTraBai7() {
    let sDien = parseInt(document.getElementById("soDien").value);
    let cuoc = document.getElementById("ketQuaBai7");
    if (sDien <= 5) {
        cuoc.innerText = "Số tiền là :" + sDien * 2200 + "VND";
    } else {
        cuoc.innerText = "Số tiền là" + sDien * 5000 + "USD";
    }

}