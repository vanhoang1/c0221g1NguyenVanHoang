function tinhdtb() {
    let t = document.getElementById('toan').value;
    let h = document.getElementById('hoa').value;
    let l = document.getElementById('ly').value;
    //tính tổng điểm, nếu dùng "+"" thì là ghép chuỗi nên ta sẽ dùng 2 dấu "-"
    let tong = t- - h - - l;
    let tb = tong/3;
    document.getElementById('diemtb').value = tb;
}
function csangf() {
    let c=document.getElementById('doc').value;
    let f=c*9/5 - - 32;
    document.getElementById('dof').value=f;
}
function tinhdientich() {
    let r=document.getElementById('bankinh').value;
    let dt= r*r*3.14;
    let cv= r*2*3.14;
    document.getElementById('dientich').value=dt;
    document.getElementById('chuvi').value=cv;

}