/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    const str = s.split('');
    const vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];

    const n=str.length;
    let i=0;
    let j=n-1;

    while(i<=j){
        let isIVowel = vowels.includes(str[i]);
        let isJVowel = vowels.includes(str[j]);

        if(!isIVowel){
            i++;
        }
        if(!isJVowel){
            j--;
        }
        if(isIVowel && isJVowel) {
            const temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
    return str.join('');
};