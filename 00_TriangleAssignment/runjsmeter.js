var jsmeter = require("jsmeter").jsmeter;
var fs = require("fs");
var fileName = process.argv[2];

fs.readFile(fileName, "utf-8", function (err, src) {
  if (err) throw err;
  var results = jsmeter.run(src, fileName, "JSON");
  // console.log(results);
  console.log('---------------------------');
  for(var idx = 1; idx < results.length; idx++){
    console.log('FUNCTION: ' + results[idx].shortName);
    console.log('NODES: ' + results[idx].nodes );
    console.log('EDGES: ' + results[idx].edges );
    console.log('CYCLOMATIC COMPLEXITY: ' + results[idx].complexity);
    console.log('MI: ' + results[idx].mi);
    console.log('Depth: '+ results[idx].depth);
    console.log('Lines: '+ results[idx].lines);
      console.log('---------------------------');
  }
});
