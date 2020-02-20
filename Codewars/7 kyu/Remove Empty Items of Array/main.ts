export function clean(array: any[]): any[] {
    return array.filter((item, idx, arr) => idx in arr);
}
