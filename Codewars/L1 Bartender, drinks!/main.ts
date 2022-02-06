export function getDrinkByProfession(profession:string): string {
  var drink: string = {
    "jabroni" : "Patron Tequila",
    "school counselor": "Anything with Alcohol",
    "programmer": "Hipster Craft Beer",
    "bike gang member": "Moonshine",
    "politician": "Your tax dollars",
    "rapper": "Cristal"
    }[profession.toLowerCase()]
  return drink ? drink : "Beer";
}
