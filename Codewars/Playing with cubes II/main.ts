class Cube {

  constructor(num?: number) {
    if (!num) this._side = 0;
    else this._side = Math.abs(num);
  }

  public getSide(): number {
    return this._side;
  }

  public setSide(value: number) {
    this._side = Math.abs(value);
  }

  private _side: number;

}
