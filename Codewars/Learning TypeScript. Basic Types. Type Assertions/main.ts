export class SuccessServerResult {
  constructor (public httpCode: number, public resultObject:Object) {}
}

export class ErrorServerResult {
  constructor (public httpCode: number, public message:string) {}
}

export function getResult(result: any) {
  if (result.httpCode === 200) {
    // Returning resultObject if everything is OK
    return (result as SuccessServerResult).resultObject;
  } else {
    // Returning result.message in case of error
    // FIXME: help TypeScript Compiler to understand that result here 
    // is the instance of ErrorServerResult...
    return (result as ErrorServerResult).message;
  }
}
