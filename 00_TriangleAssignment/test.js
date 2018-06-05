let junit = require("junit");
let ctrl = require("./index.js")
let it = junit();


(async () => {
        let input = [[7,10,5], [7,5,7], [7,7,7], [1,2,"hello"], [1,2], [1,0,2], [1,2,3]]
        let testNames = ["scalene", "isosceles", "equilateral", "NaN", "missing sides", "side 0", "no triangle"];
        let res = ["scalene", "isosceles", "equilateral", "invalid", "invalid", "invalid", "invalid"];
        for (let i = 0; i < input.length; i++) {
            it(testNames[i] +" test ", () => it.eq(ctrl.typeOfTriangle(input[i][0], input[i][1], input[i][2]), res[i]));
          }
            let { total, tested, passed, failed } = await it.run();
        })();
