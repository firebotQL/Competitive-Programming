function sortedSquares(nums: number[]): number[] {
    const numsMap = {};
    for(var i = 0; i < nums.length; i++) {
        const num = Math.abs(nums[i]);
        numsMap[num] = (numsMap[num] ?? 0) + 1;
    }

    var result = [];
    var value;
    console.log( Object.keys(numsMap));
    return Object.keys(numsMap).reduce((result, key) => {
        value = numsMap[key];
        while(value-- > 0) {
            result.push(+key * +key);
        }
        return result;
    }, []);
};
