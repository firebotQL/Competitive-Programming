export function abbrevName(name: string): string {
    return name.split(/\s+/).map((subStr) => subStr.charAt(0).toUpperCase()).join('.');
}
