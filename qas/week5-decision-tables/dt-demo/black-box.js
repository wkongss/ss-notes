
/**
 * Takes in four boolean values and returns a mystery value
 * @param {boolean} a 
 * @param {boolean} b 
 * @param {boolean} c 
 * @param {boolean} d 
 * @returns A mystery value
 */
export function testFunction(a, b, c, d) {
    return !a * b * !d + a * c;
}
