
export interface MonthToRainfallMap {
  [key: string]: number;
}

export interface RainfallMap {
  [key: string]: MonthToRainfallMap;
}

export class G964 {
  public static getNormalized = (data: string): RainfallMap => {
    return data.split(/\n/).reduce((rainfallMap: RainfallMap, currentCityWithRainfalls: string): RainfallMap => {
      const cityMonthSplit: string[] = currentCityWithRainfalls.split(':');
      const city: string = cityMonthSplit[0];
      const monthToRainfallString = cityMonthSplit[1];
      rainfallMap[city] = monthToRainfallString
        .split(',')
        .reduce((monthToRainfallMap: MonthToRainfallMap, currentMonthWithRainfall: string) => {
          const monthToRainfallSplit: string[] = currentMonthWithRainfall.split(/\s+/);
          const month:string = monthToRainfallSplit[0];
          monthToRainfallMap[month] = Number(monthToRainfallSplit[1]);
          return monthToRainfallMap;
        }, {});
      return rainfallMap;
    },                             {});
  }

  public static mean = (town: string, strng: string): number => {
    const rainfallMap = G964.getNormalized(strng);
    if (!rainfallMap[town]) return -1;
    return (
      Object.keys(rainfallMap[town]).reduce((sum: number, currentMonth:string) => {
        return sum + rainfallMap[town][currentMonth];
      }, 0) / 12
    );
  }

  public static variance = (town: string, strng: string): number => {
    const rainfallMap = G964.getNormalized(strng);
    if (!rainfallMap[town]) return -1;
    const mean = G964.mean(town, strng);
    return Object.keys(rainfallMap[town]).reduce((deltaSum: number, currentMonth: string) => {
      return deltaSum + Math.pow(rainfallMap[town][currentMonth] - mean, 2);
    }, 0) / 12;
  }
}
