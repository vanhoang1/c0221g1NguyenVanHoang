let doiAnh1=document.getElementById("anh1");
let doiAnh2=document.getElementById("anh2");
let doiAnh3=document.getElementById("anh3");
let doiAnh4=document.getElementById("anh4");
let doiAnh5=document.getElementById("anh5");
var so1=null;
var so2=null;
var so3=null;
var so4=null;
var so5=null;
function doihinh(anhDC) {
    let xucXac=1+Math.floor(Math.random() * 5);
    switch (anhDC) {
        case 'anh1':
            so1=xucXac;
            doiAnh1.src="panda_swap_part"+xucXac+"x1.jpg";
             break;
        case 'anh2':
            so2=xucXac;
            doiAnh2.src="panda_swap_part"+xucXac+"x1.jpg";
            break;
        case 'anh3':
            so3 =xucXac;
            doiAnh3.src="panda_swap_part"+xucXac+"x1.jpg";
            break;
        case 'anh4':
            so4=xucXac;
            doiAnh4.src="panda_swap_part"+xucXac+"x1.jpg";
            break;
        case 'anh5':
            so5=xucXac;
            doiAnh5.src="panda_swap_part"+xucXac+"x1.jpg";
            break;
    }
    if (so1<so2<so3<so4<so5 && so5==5)
    {
        window.setTimeout(window.alert, 1000,"win")
    }
}
