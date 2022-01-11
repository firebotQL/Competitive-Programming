function containsDuplicate(nums: number[]): boolean {
    const numbersMap = {};
    return nums.some((number) => {
        if (!numbersMap[number]) {
            numbersMap[number] = true;
            return false;
        }
        return true;
    }) 
};