export function htmlspecialchars(formData: string): string {
  return formData.replace(/&/g, '&amp;')
                  .replace(/>/g, '&gt;')
                  .replace(/</g, '&lt;')
                  .replace(/"/g, '&quot;');
}
