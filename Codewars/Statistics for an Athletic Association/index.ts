export class G964 {

    public static getH : Function = (seconds) : Number => Math.floor(seconds / 60 / 60);
    public static getM : Function  = (seconds) : Number => Math.floor(seconds / 60) % 60;
    public static getS : Function  = (seconds) : Number => seconds % 60;
    public static converters: Function[] = [G964.getH, G964.getM, G964.getS];

    public static stat = (strg) => {
        var stats = strg.split(',').map((score) => {
            let match = /(\d+)\|(\d+)\|(\d+)/g.exec(score);
            return +match[1] * 60 * 60 + +match[2] * 60 + +match[3];
        });

        let range = G964.formatForPrint(G964.getRange(stats), G964.converters);
        let avg = G964.formatForPrint(G964.getAvg(stats), G964.converters);
        let median = G964.formatForPrint(G964.getMedian(stats), G964.converters);
        return `Range: ${range} Average: ${avg} Median: ${median}`;
    };

    public static formatForPrint(sec, converters): String {
        return converters
            .map((converter) => converter(sec))
            .map((value) => G964.pad(value))
            .join('|');
    }


    public static getRange(stats): Number {
        return Math.max(...stats) - Math.min(...stats);
    }

    public static getAvg(stats): Number {
        return Math.floor(stats.reduce((result, stat) => result + stat, 0) / stats.length);
    }

    public static getMedian(stats): Number {
        const sStats = stats.sort((a, b) => b - a);
        const mid = Math.floor(sStats.length / 2);
        if (stats.length % 2 == 0) {
            return Math.floor((sStats[mid - 1] + sStats[mid]) / 2);
        }
        return sStats[mid];
    }

    public static pad(num) {
        return ('00'+ num).slice(-2);
    }

}
