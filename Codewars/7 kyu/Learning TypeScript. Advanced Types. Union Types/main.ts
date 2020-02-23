export function join(tokens: string | string[], glue?: string): string {
  return typeof tokens === 'string' ? tokens : tokens.join(glue);
}
