function maxSubArray(nums: number[]): number {
    let globalMax = Number.MIN_SAFE_INTEGER;
    nums.reduce((localMax, currentNum) => {
        localMax += currentNum;
        globalMax = Math.max(localMax, globalMax); 
        return localMax < 0 ? 0 : localMax;
    }, 0);
    return globalMax;
};
