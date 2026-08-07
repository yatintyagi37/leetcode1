/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if(numRows === 1 || numRows >= s.length){
        return s;
    }

    let rows = new Array(numRows).fill("");

    let currentRow = 0;
    let goingDown = true;

    for(let char of s){
        rows[currentRow] += char;

        if(currentRow===0){
            goingDown = true;
        }
        else if(currentRow === numRows-1){
            goingDown = false;
        }
        if(goingDown){
            currentRow++;
        }
        else{
            currentRow--;
        }
    }
    return rows.join("");
};