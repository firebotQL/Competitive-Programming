
export class God{
/**
 * @returns Human[]
 */
  static create(){
    return [new Man(), new Woman()];
  }
}

export class Human {
}

export class Man extends Human {
}

export class Woman extends Human {
}
