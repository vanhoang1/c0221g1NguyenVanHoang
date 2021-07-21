// happy coding 👻
console.log("start");
async function getGitHup() {

    return await new Promise((resolve, reject) => {
        let xHttp = new XMLHttpRequest();
        xHttp.open("GET","https://api.github.com/users/defufasdasnkt");
        xHttp.send();
        xHttp.onload = function () {
            if (this.status == 200) {
                resolve(xHttp.responseText)
            } else {
                reject('Error call API')
            }
        };

    });
}
getGitHup().then(result => {console.log(result)}).catch(error =>{console.log(error)}).finally(() => console.log("end"));
