function fibonacciNum(number: number): number {
    if (number == 0) {
        return 0;
    }
    if (number == 1) {
        return 1;
    }
    return fibonacciNum(number - 1) + fibonacciNum(number - 2);
}

let sum = 0;
console.log('dãy fibonacci là:');
for (let i = 1; i < 10; i++) {
    let fibo = fibonacciNum(i);
    console.log(fibo);
    sum += fibo;
}
console.log('tổng các phần tử');
console.log(sum);