/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
    if (s.length <= 1) return s;
    let start = 0;
    let maxLength = 1;

    for (let i = 0; i < s.length-1; i++) {
        expandAroundCenter(i, i);
        expandAroundCenter(i, i + 1);
    }

    function expandAroundCenter( left, right) {
        while (left >= 0 && right < s.length && s[left] === s[right]) {
            if (right - left + 1 > maxLength) {
                start = left;
                maxLength = right - left + 1;
            }
            left--;
            right++;
        }
    }

    return s.substring(start, start + maxLength);
};