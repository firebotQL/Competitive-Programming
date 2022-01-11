function twoSum(nums: number[], target: number): number[] {
    const map = nums.reduce((result, cur, index) => {
        result[cur] = index;
        return result;
    }, {});

    let j;

    for(let i = 0; i < nums.length; i++) {
        j = map[target - nums[i]];
        if (j && i !== j) {
            return [i, j]
        }
    }
};
