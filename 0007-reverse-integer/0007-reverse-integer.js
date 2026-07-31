/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let ans = Number(
        Math.abs(x).toString().split('').reverse().join(''));

    if (x < 0) ans = -ans;

    return(
        ans < -(2**31)||ans> (2**31) -1
    ) ? 0 : ans;
};