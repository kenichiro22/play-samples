basePath = '';

files = [
  ANGULAR_SCENARIO,
  ANGULAR_SCENARIO_ADAPTER,
  'e2e/**/*.js'
];

autoWatch = false;

browsers = ['Chrome'];

singleRun = true;

urlRoot = '/__karma/';

proxies = {
  '/': 'http://localhost:9000/'
};

junitReporter = {
  outputFile: 'test_out/e2e.xml',
  suite: 'e2e'
};

