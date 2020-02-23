export class Warrior {
  private name:string;
	public health:number;
  constructor(name:string){
    this.name=name;
    this.health=100;
  }
  
  public strike = function(enemy:Warrior, swings:number) {
      enemy.health = Math.max(0, enemy.health - (swings * 10));
  }
    
}
